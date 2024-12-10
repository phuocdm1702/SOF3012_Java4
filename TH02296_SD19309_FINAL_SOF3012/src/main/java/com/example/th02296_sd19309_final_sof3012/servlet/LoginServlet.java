package com.example.th02296_sd19309_final_sof3012.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("u") != null) {
            // Nếu người dùng đã đăng nhập, chuyển hướng đến trang chính
            response.sendRedirect(request.getContextPath() + "/phong-ban/hien-thi");
        } else {
            // Hiển thị form đăng nhập
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String us = request.getParameter("user");
        String p = request.getParameter("pass");
        if (us.equalsIgnoreCase("th02296") && p.equalsIgnoreCase("sd19309")) {
            HttpSession session = request.getSession();
            session.setAttribute("us", us);
            response.sendRedirect("/phong-ban/hien-thi");
        } else {
            request.setAttribute("erro","Tài Khoản hoặc mật khâủ không đúng!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
