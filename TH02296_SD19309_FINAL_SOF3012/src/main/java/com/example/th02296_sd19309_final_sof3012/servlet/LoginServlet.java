package com.example.th02296_sd19309_final_sof3012.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("LoginServlet")){
            String u = request.getParameter("user");
            String p = request.getParameter("pass");
            if(u.equalsIgnoreCase("th02296") && p.equalsIgnoreCase("sd19309")){
                request.setAttribute("mess","Đăng nhập thành công!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
