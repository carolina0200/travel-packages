package com.ceiba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Collections;

@ComponentScan({"com.ceiba"})
@SpringBootApplication
public class Application {
    @Bean
    public ErrorViewResolver customErrorViewResolver() {
        final ModelAndView redirectToIndexHtml = new ModelAndView("forward:/index.html", Collections.emptyMap(), HttpStatus.OK);
        return (request, status, model) -> status == HttpStatus.NOT_FOUND ? redirectToIndexHtml : null;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
