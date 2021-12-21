package com.pjj.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.List;

public class UploadServlet extends HttpServlet {

    /**
     * 用来处理上传的数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //先判断上传的文件是否是多段的
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload =  new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                //循环判断每一个表单项是普通类型还是上传的文件
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单的name属性：" + fileItem.getFieldName());
                        System.out.println("表单的value属性" + fileItem.getString("UTF-8"));
                    }else {
                        //上传的文件
                        System.out.println("表单的name属性：" + fileItem.getFieldName());
                        System.out.println("上传的文件名" + fileItem.getName());
                        fileItem.write(new File("C:\\Users\\98334\\Desktop\\" + fileItem.getName()));
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {

            }
        }
    }
}























