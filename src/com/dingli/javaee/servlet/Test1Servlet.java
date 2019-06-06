package com.dingli.javaee.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @WebServlet 是注解
 * 其对应 web.xml 对于Servlet的配置
 *
 * 在这里我们唯一需要的就是 urlPatterns 属性
 *
 * 此注解，简化了 web.xml 的配置
 */
public class Test1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
