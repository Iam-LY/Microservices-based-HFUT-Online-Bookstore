package com.hfut.glxy.springcloud.config;

import com.hfut.glxy.springcloud.interceptor.ManagerLoginInterceptor;
import com.hfut.glxy.springcloud.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    /**
     * springmvc视图控制器
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("user/login");
        registry.addViewController("/regist").setViewName("user/regist");
        registry.addViewController("/edit").setViewName("user/edit");
        registry.addViewController("/manager/toAddBook").setViewName("manager/book_add");
        registry.addViewController("/manager/").setViewName("manager/login_manager");
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置用户登录拦截器
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
                .excludePathPatterns("/", "/login", "/index", "/toLogin",
                        "/regist", "/register", "/edit", "/manager/**",
                        "/defaultKaptcha", "/css/**", "/img/**", "/script/**", "/uploads/**");
        //配置管理员登录拦截器
        registry.addInterceptor(new ManagerLoginInterceptor())
                .addPathPatterns("/manager/**")
                .excludePathPatterns("/manager/login_manager.html", "/manager/login");
    }
}