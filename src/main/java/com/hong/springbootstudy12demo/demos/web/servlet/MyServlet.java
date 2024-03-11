package com.hong.springbootstudy12demo.demos.web.servlet;

import com.hong.springbootstudy12demo.demos.web.filter.MyFilter;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("hello tomcat!");
    }

    public static void main(String[] args) {
        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory("/hcl", 8081);
        ServletRegistrationBean<MyServlet> servletServletRegistrationBean = new ServletRegistrationBean<>();
        servletServletRegistrationBean.setServlet(new MyServlet());
        servletServletRegistrationBean.setUrlMappings(Arrays.asList("/hcl"));
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hcl"));
        WebServer webServer = tomcatServletWebServerFactory.getWebServer(filterFilterRegistrationBean, servletServletRegistrationBean);
        webServer.start();
    }

}
