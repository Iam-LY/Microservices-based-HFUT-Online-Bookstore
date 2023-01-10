package com.hfut.glxy.springcloud.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 管理员登录拦截器
 */
public class ManagerLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("manager");
        if (loginUser != null) {
            return true;
        }
        request.setAttribute("msg", "请先登录");
        request.getRequestDispatcher("/manager/login").forward(request, response);
        return false;
    }
}