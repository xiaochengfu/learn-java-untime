package com.xiaochengfu.springbootstudy;

import com.xiaochengfu.springbootstudy.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
//@ServletComponentScan
public class SpringbootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStudyApplication.class, args);
    }

//    @Bean
//    public ServletRegistrationBean<MyServlet> getServletRegistrationBean() {
//        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>(new MyServlet());
////        ArrayList<String> url = new ArrayList<>();
////        url.add("/srv");
////        bean.setUrlMappings(url);
//        bean.setLoadOnStartup(1);
//        return bean;
//    }

}
