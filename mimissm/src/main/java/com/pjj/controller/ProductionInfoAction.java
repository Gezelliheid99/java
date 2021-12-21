package com.pjj.controller;

import com.github.pagehelper.PageInfo;
import com.pjj.pojo.ProductInfo;
import com.pjj.pojo.vo.ProductInfoVo;
import com.pjj.service.ProductionInfoService;
import com.pjj.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author 潘俊杰
 * @date 2021年09月08日 14:04
 */
@Controller
@RequestMapping("/prod")
public class ProductionInfoAction {

    public static final int PAGE_SIZE = 5;
    String saveFileName = "";

    @Autowired
    private ProductionInfoService service;

    /**
     * 显示所有商品
     * @return
     */
    @RequestMapping("/getAll.do")
    public String getAll(HttpServletRequest request){
        List<ProductInfo> productInfos = service.getAll();
        request.setAttribute("list", productInfos);
        return "product";
    }

    /**
     * 商品第一页展示
     * @param request
     * @return
     */
    @RequestMapping("/split.do")
    public String split(HttpServletRequest request){
        PageInfo info = null;
        Object vo = request.getSession().getAttribute("prodVo");
        if (vo != null) {
            service.splitPageVo((ProductInfoVo) vo, PAGE_SIZE);
            request.getSession().removeAttribute("prodVo");
        }else {
            info = service.splitPage(1, PAGE_SIZE);

        }
        request.setAttribute("info", info);
        return "product";
    }

    /**
     * ajax分页
     * @param vo
     * @param session
     */
    @RequestMapping("/ajaxsplit.do")
    @ResponseBody
    public void ajaxSplit(ProductInfoVo vo , HttpSession session){
        PageInfo info = service.splitPageVo(vo, PAGE_SIZE);
        session.setAttribute("info", info);

    }


    /**
     * 异步ajax文件上传
     * @param pimage
     * @return
     */
    @RequestMapping(value = "/ajaxImg.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public Object ajaxImg(MultipartFile pimage,HttpServletRequest request){
        //1.提取文件名
        saveFileName = FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());
        //2.得到图片存放路径
        System.out.println("saveFileName的名字：" + saveFileName);
        try {
            String path = request.getServletContext().getRealPath("/image_big");
            // String path = "E:\\java\\JavaProjects\\mimissm\\src\\main\\webapp\\image_big";
            pimage.transferTo(new File(path+File.separator+saveFileName));
            System.out.println("存放的路径位置：" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回客户端json对象，封装图片的路径，在页面上回显
        JSONObject object  = new JSONObject();
        object.put("imgurl", saveFileName);
        return object.toString();

    }

    @RequestMapping("/save.do")
    public String save(ProductInfo productInfo, HttpServletRequest request){
        productInfo.setpImage(saveFileName);
        productInfo.setpDate(new Date());
        int num = -1;
        try {
            num = service.save(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (num > 0 ){
            request.setAttribute("msg", "添加成功");
        }else {
            request.setAttribute("msg", "添加失败");
        }
        //清空saveFileName
        saveFileName = "";
        return "forward:/prod/split.do";
    }

    /**
     * 更新页面的跳转显示
     * @param pid
     * @param model
     * @return
     */
    @RequestMapping("/one.do")
    public String getById(Integer pid,ProductInfoVo vo , Model model,HttpSession session){
        ProductInfo info = service.queryById(pid);
        model.addAttribute("prod", info);
        //将多条件保存在session中
        session.setAttribute("prodVo", vo);
        return "update";
    }

    /**
     * 更新商品项
     * @param info
     * @param request
     * @return
     */
    @RequestMapping("/update.do")
    public String update(ProductInfo info,HttpServletRequest request){
        if ( !"".equals(saveFileName)) {
            info.setpImage(saveFileName);
        }
        int num = -1;
        try {
            num = service.update(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (num > 0 ){
            request.setAttribute("msg", "更新成功");
        }else {
            request.setAttribute("msg", "更新失败");
        }
        saveFileName = "";
        return "forward:/prod/split.do";
    }

    /**
     * 删除商品项
     * @param pid
     * @param request
     * @return
     */
    @RequestMapping("/delete.do")
    public String delete(Integer pid,ProductInfoVo vo,HttpServletRequest request){
        int num = -1;
        try {
            num = service.deleteById(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (num > 0 ){
            request.setAttribute("msg", "删除成功");
            request.getSession().setAttribute("deleteProdVo", vo);
            System.err.println(vo);
        }else {
            request.setAttribute("msg", "删除失败");
        }
        return "forward:/prod/deleteAjaxSplit.do";
    }

    @RequestMapping(value = "/deleteAjaxSplit.do",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public Object deleteAjaxSplit(HttpServletRequest request){
        PageInfo info = null;
        Object vo = request.getSession().getAttribute("deleteProdVo");

        if (vo != null) {
            info = service.splitPageVo((ProductInfoVo) vo, PAGE_SIZE);
            System.err.println(info);
        }else {
            info = service.splitPage(1, PAGE_SIZE);
        }
        request.getSession().setAttribute("info", info);
        return request.getAttribute("msg");
    }

    /**
     * 批量删除商品项
     * @param pids
     * @param request
     * @return
     */
    @RequestMapping("/deleteBatch.do")
    public String deleteBatch(String pids, HttpServletRequest request){

        String[] ids = pids.split(",");
        int num = -1;
        try {
            num = service.deleteBatch(ids);
            if (num > 0 ){
                request.setAttribute("msg", "批量删除成功");
            }else {
                request.setAttribute("msg", "批量删除失败");
            }
        } catch (Exception e) {
            request.setAttribute("msg", "商品不可删除");
        }
        return "forward:/prod/deleteAjaxSplit.do";
    }

    /**
     *
     * @param vo
     * @param session
     */
    @RequestMapping("/condition.do")
    @ResponseBody
    public void selectCondition(ProductInfoVo vo,HttpSession session){
        List<ProductInfo> list = service.selectCondition(vo);
        session.setAttribute("list", list);
    }



}
















