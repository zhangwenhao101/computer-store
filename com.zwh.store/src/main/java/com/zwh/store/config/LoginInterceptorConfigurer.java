package com.zwh.store.config;

import com.zwh.store.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

/**
 * @author zwh
 * 处理器拦截器的注册
 */
@Configuration//加载当前拦截器
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //创建拦截器对象
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        ArrayList<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/register.html");
        patterns.add("/web/login.html");
        patterns.add("/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/reg");
        patterns.add("/users/login");
        patterns.add("/districts/**");
        patterns.add("/web/index.html");
        patterns.add("/products/**");
        //拦截器注册
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")//拦截的url
                .excludePathPatterns(patterns);//白名单
    }
}
