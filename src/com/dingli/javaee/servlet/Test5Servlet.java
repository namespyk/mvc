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
import java.util.Map;

public class Test5Servlet extends HttpServlet {
    private StudentService service = new StudentServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获取前段参数
         * 2.做类型转换
         * 3.后端验证（这里偷懒）
         * 4.处理参数（一般是封装成对象或者用Map存起来）
         * 5.调用service
         */
        // 后端getParameter方法返回都是String类型
        String name = request.getParameter("name");
        String ageS = request.getParameter("age_s");
        String ageE = request.getParameter("age_e");

//        int ageStart = Integer.parseInt(ageS);
//        int ageEnd = Integer.parseInt(ageE);

        Map<String,Object> whereMap = new HashMap<>();
        if(name != null || "".equals(name)){
            whereMap.put("name",name);
        }
        if(name != null || "".equals(ageS)){
            whereMap.put("ageS",ageS);
        }
        if(name != null || "".equals(ageE)){
            whereMap.put("ageE",ageE);
        }


        System.out.println(whereMap);

        //5.调用service
        List<Student> list = service.query(whereMap);
        System.out.println(list);

        //设置request属性值
        request.setAttribute("list",list);

        //请求转发
        RequestDispatcher rd = request.getRequestDispatcher("/test/student_list.jsp");
        rd.forward(request,response);
    }
}
