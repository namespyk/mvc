package com.dingli.javaee.servlet;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.service.StudentService;
import com.dingli.javaee.service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Test6Servlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        studentService.delete(Long.parseLong(id));
        List<Student> list = studentService.query(new HashMap<>());
        request.setAttribute("list",list);
        RequestDispatcher rd = request.getRequestDispatcher("/test/student_list.jsp");
        rd.forward(request,response);



    }


}
