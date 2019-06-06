package com.dingli.javaee.servlet.ajax;

import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.service.StudentService;
import com.dingli.javaee.bean.Student;
import com.dingli.javaee.bean.param.StuParam;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",urlPatterns = "/student/query")
public class StudentServlet extends HttpServlet {

    private StudentService service = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StuParam sp = ParamUtil.getParamBean(request,StuParam.class);
        System.out.println(".....");
        System.out.println(sp);


        Pager<Student> pager = service.query(sp,new Pager<Student>(sp.getCurPage(),sp.getPageSize()));

        // 把后端查询到的数据返回给前端
        Writer w = response.getWriter();
        w.write(JsonUtil.toJson(pager));
        w.flush();
        w.close();
    }
}
