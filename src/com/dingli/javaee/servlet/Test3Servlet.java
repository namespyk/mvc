package com.dingli.javaee.servlet;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.service.StudentService;
import com.dingli.javaee.service.StudentServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class Test3Servlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取前段add_student.html中的表单数据
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String[] favs = request.getParameterValues("fav");
        String edu = request.getParameter("edu");
        String desc = request.getParameter("desc");


//        System.out.println(new String(name.getBytes("ISO-8859-1"),"UTF-8"));
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(Arrays.asList(favs));
        System.out.println(edu);
        System.out.println(desc);
//        System.out.println(new String(desc.getBytes("ISO-8859-1"),"UTF-8"));


//        name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
//        desc = new String(desc.getBytes("ISO-8859-1"),"UTF-8");

        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setSex(Integer.parseInt(sex));

//        List<Integer> list = new ArrayList<Integer>();
        StringBuilder sb = new StringBuilder(",");
        for(String fav : favs){
//            list.add(Integer.parseInt(fav));
            sb.append(fav).append(",");
        }
//        student.setFavs(list);
        student.setFavs(sb.substring(0,sb.length()-1).toString()); //,1,3,4

        student.setEdu(Integer.parseInt(edu));
        student.setDesc(desc);

        System.out.println(student);

        studentService.insert(student);
    }
}
