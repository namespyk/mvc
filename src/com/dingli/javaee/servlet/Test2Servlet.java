package com.dingli.javaee.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test2Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入Servlet");
        request.setCharacterEncoding("UTF-8");
        //获取参数
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");

        System.out.println(name);
        System.out.println(new String(desc.getBytes("ISO-8859-1"),"UTF-8"));

        //修改了后端代码，必须重启tomcat
    }
}
