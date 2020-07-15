package com.kunguo.linghuawang.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  //TODO 登录验证
 * @author zhaomaohui
 * @ClassName: LoginInterceptor
 * @Description:
 * @date 2020/5/19
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断后台是否登录未登录跳转登录
        if (request.getServletPath().contains("/admin/") &&  !"/admin/".equals(request.getServletPath())){
            Object admin = request.getSession().getAttribute("admin");//后台
            if (admin == null || admin.equals(""))  {
                response.sendRedirect("/admin/");
                return false;
            }
        }
        return true;
    }
}
