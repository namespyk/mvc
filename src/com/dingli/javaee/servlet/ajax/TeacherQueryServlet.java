package com.dingli.javaee.servlet.ajax;


import com.dingli.javaee.bean.Teacher;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.TeaParam;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TeacherQueryServlet",urlPatterns = "/teacher/query")
public class TeacherQueryServlet extends HttpServlet {

    private TeacherService service = new TeacherServiceImp1();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TeaParam sp = ParamUtil.getParamBean(request,TeaParam.class);

        System.out.println("--------------"+sp);


        Pager<Teacher> pager = service.query(sp,new Pager<Teacher>(sp.getCurPage(),sp.getPageSize()));

        // 把后端查询到的数据返回给前端
        Writer w = response.getWriter();
        w.write(JsonUtil.toJson(pager));
        w.flush();
        w.close();
    }
}
