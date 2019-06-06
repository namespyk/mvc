package com.dingli.javaee.servlet.ajax;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.service.StudentService;
import com.dingli.javaee.service.StudentServiceImpl;
import com.dingli.javaee.util.JsonUtil;
import com.dingli.javaee.util.ParamUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "StudentAddServlet",urlPatterns = "/student/add")
public class StudentAddServlet extends HttpServlet {

    private StudentService service = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student s = ParamUtil.getParamBean(request,Student.class);

        System.out.println(s);

        service.insert(s);

        // 把后端查询到的数据返回给前端
        Writer w = response.getWriter();
        w.write(JsonUtil.toJson(new MyResponse(true,"添加学生信息成功")));
        w.flush();
        w.close();
    }
}
