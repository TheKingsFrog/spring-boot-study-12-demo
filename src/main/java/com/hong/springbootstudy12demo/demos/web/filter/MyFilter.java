package com.hong.springbootstudy12demo.demos.web.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

public class MyFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("经过了filter");
        chain.doFilter(request, response);
    }
}
