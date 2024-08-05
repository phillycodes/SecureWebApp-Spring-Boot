package com.springboot.SecureWebApp.config;

import com.springboot.SecureWebApp.interceptor.BookHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * Description: implementing the WebMvcConfigurer indicating that some external configuration
 * properties are present here.
 */
@Component
public class WebAppConfiguration implements WebMvcConfigurer {

    @Autowired // Injecting this BookHandlerInterceptor
    private BookHandlerInterceptor bookInterceptor;

    // InterceptorRegistry where you can register all of the interceptors that you have in the
    // code. You can configure more than one.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(bookInterceptor);
    }
}
