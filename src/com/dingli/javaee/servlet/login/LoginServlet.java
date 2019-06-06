package com.dingli.javaee.servlet.login;

import com.dingli.javaee.bean.MyResponse;
import com.dingli.javaee.bean.param.LoginParam;
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

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginParam param = ParamUtil.getParamBean(request,LoginParam.class);
        MyResponse myResponse = null;
        // 获取前端登录参数
        // 判断验证码
        String checkCode = param.getCheckCode();// 用户输入的验证码
        if(checkCode == null || !checkCode.equals(CheckCode.getChecCode(request))){
            myResponse = MyResponse.error("验证密码输入错误!");
        }else if(!"admin".equals(param.getName()) || !"admin123".equals(param.getPass()) ){
            // 判断用户名密码是否正确 目前是写死的admin/admin123
            myResponse = MyResponse.error("用户名或密码输入错误!");
        }else {
            // 如以上验证都通过，这表示登录成功
            myResponse = MyResponse.success("登录成功");
        }


        Writer w = response.getWriter();
        w.write(JsonUtil.toJson(myResponse));
        w.flush();
        w.close();

    }
}
