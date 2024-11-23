package com.example.sof3012_java4_btvn_buoi9.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = {
        "/login",
        "/dang-xuat"
})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            this.loginUser(request, response);
        } else{
            this.dangXuat(request, response);
        }
    }

    private void dangXuat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Đăng xuất
        //xóa Session
        // C1: xóa lần lượt
        HttpSession session = request.getSession();
//        session.removeAttribute("uname");
//        session.removeAttribute("role");
        session.invalidate();
        response.sendRedirect("/login");
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("userName");
        String pass = request.getParameter("pass");
        if ((user.equalsIgnoreCase("HangNT169") &&
                pass.equalsIgnoreCase("123456"))
                ||
                (user.equalsIgnoreCase("Nguyenvv4") && pass.equalsIgnoreCase("1234567"))
        ) {
           HttpSession session = request.getSession();
           session.setAttribute("uname", user);
            if(user.equalsIgnoreCase("HangNT169")){
                session.setAttribute("role", "Admin");
            } else {
                session.setAttribute("role","NhanVien");
            }
            response.sendRedirect("/chi-tiet-san-pham/hien-thi");
//           request.getRequestDispatcher("/ket-qua.jsp").forward(request,response);
        } else {
            request.setAttribute("erro","Tài khoản hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
