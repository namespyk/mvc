package com.dingli.javaee.servlet.login;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.StuParam;
import com.dingli.javaee.service.StudentService;
import com.dingli.javaee.service.StudentServiceImpl;
import com.dingli.javaee.util.CheckCode;
import com.dingli.javaee.util.JsonUtil;
import com.dingli.javaee.util.ParamUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(urlPatterns = "/checkCode")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CheckCode.createCheckCode(request,response);
    }
}
