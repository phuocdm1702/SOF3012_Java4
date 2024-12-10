package com.example.th02296_sd19309_final_sof3012.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;

import java.io.IOException;

@WebFilter(filterName = "LoginFilter", value = {
        "/phong-ban/*",
})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        Filter.super.init(config);
        System.out.println("Chạy 1 lần day nhất");
    }

    public void destroy() {
        Filter.super.destroy();
        System.out.println("Chạy 1 lần duy nhất");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String use = (String) session.getAttribute("us");
        if(use == null){
            System.out.println(use);
            res.sendRedirect("/LoginServlet");
        } else {
            chain.doFilter(request, response);
        }

    }
}
