package com.dingli.javaee.servlet.ajax;

import com.dingli.javaee.bean.Teacher;
import com.dingli.javaee.service.TeacherService;
import com.dingli.javaee.service.TeacherServiceImp1;
import com.dingli.javaee.util.JsonUtil;
import com.dingli.javaee.util.ParamUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "TeacherUpdateServlet",urlPatterns = "/teacher/update")
public class TeacherUpdateServlet extends HttpServlet {
    private TeacherService service = new TeacherServiceImp1();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher t = ParamUtil.getParamBean(request,Teacher.class);
        System.out.println(t);

        service.update(t);

        Writer w = response.getWriter();
        w.write(JsonUtil.toJson(new MyResponse(true,"修改学生信息成功")));
        w.flush();
        w.close();
    }
}
