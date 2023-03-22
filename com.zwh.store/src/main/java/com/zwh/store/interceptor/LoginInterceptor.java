package com.zwh.store.interceptor;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zwh
 * 拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 检测全局session对象中是否有uid数据，如果有则放行，如果没有重定向到登录页面
     *
     * @param request  请求对象
     * @param response 相应对象
     * @param handler  处理器
     * @return 返回值为true则放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object obj = request.getSession().getAttribute("uid");
        if (obj == null) {
            response.sendRedirect("/web/login.html");
            return false;
        }
        return true;
    }

}
