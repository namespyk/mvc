package com.dingli.javaee.servlet;

import com.dingli.javaee.bean.Teacher;
import com.dingli.javaee.service.TeacherService;
import com.dingli.javaee.service.TeacherServiceImp1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Test4Servlet extends HttpServlet {

    TeacherService teacherService = new TeacherServiceImp1();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String college = request.getParameter("college");
        String subject = request.getParameter("subject");

//        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        college = new String(college.getBytes("ISO-8859-1"),"UTF-8");
        subject = new String(subject.getBytes("ISO-8859-1"),"UTF-8");


        Teacher teacher = new Teacher();
        teacher.setName(name);
        teacher.setCollege(college);
        teacher.setSubject(subject);
        teacher.setAge(Integer.parseInt(age));
        teacher.setSex(Integer.parseInt(sex));
        System.out.println(teacher);

        teacherService.insert(teacher);
    }
}
