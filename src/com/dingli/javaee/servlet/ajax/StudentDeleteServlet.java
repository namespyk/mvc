package com.dingli.javaee.servlet.ajax;

import com.dingli.javaee.bean.param.StuDelParam;
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

@WebServlet(name = "StudentDeleteServlet",urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {

    private StudentService service = new StudentServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StuDelParam s = ParamUtil.getParamBean(request,StuDelParam.class);

        System.out.println(s);

        service.delete(s.getId());

        // 把后端查询到的数据返回给前端
        Writer w = response.getWriter();
        w.write(JsonUtil.toJson(new MyResponse(true,"删除学生信息成功")));
        w.flush();
        w.close();
    }
}
