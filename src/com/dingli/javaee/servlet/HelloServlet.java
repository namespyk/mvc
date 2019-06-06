package com.dingli.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 *  自定义的 servlet 必须继承
 *  javax.servlet.http.HttpServlet
 *
 *  并重写 doGet、doPost或doService方法中的至少一个
 */
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决输出乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // request 请求对象
        // response 响应对象
        Writer writer = response.getWriter();
        writer.write("<p>Hellow Servlet<p>");
        writer.write("");
        writer.write("你好，Servlet");

        writer.flush();
        writer.close();

    }
}
