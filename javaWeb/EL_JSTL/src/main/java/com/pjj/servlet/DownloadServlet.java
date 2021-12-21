package com.pjj.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.beans.Encoder;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.spec.EncodedKeySpec;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取要下载的文件名
        String downloadFileName = "c.jpg";
        //2.获取要下载的内容
        ServletContext servletContext = getServletContext();
        //3.在回传前，通过响应头告诉客户端返回的数据类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("返回的数据类型是:" + mimeType);
        response.setContentType(mimeType);
        //4.还要告诉客户端收到的数据是用于下载使用
        //Content-Disposition表示收到的数据怎么处理
        response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(downloadFileName,"UTF-8"));
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        //获取响应的输出流
        OutputStream outputStream = response.getOutputStream();
        //读取流中全部输出复制给输出流
        IOUtils.copy(resourceAsStream, outputStream);
        //5.把下载的文件回传给客户端

    }


}
