package com.yks.common.sys.security.action;

import com.yks.common.sys.security.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2017/6/27.
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/logout")
                .excludePathPatterns("/index2.html")
                .excludePathPatterns("/amzpicture/insert")
                .excludePathPatterns("/ebayAccount/**")
                .excludePathPatterns("/login")
                .excludePathPatterns("/common")
                .excludePathPatterns("/")
                .excludePathPatterns("/api/**");
        super.addInterceptors(registry);
    }

}
