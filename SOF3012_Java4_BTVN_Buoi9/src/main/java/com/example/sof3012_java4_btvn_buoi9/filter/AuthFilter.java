package com.example.sof3012_java4_btvn_buoi9.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", value = {
        // Liệt kê các đường dẫn bắt buộc phải đăng nhập thì mới dùng được
        //Cách 1:
//        "/chi-tiet-san-pham/hien-thi",
//        "/chi-tiet-san-pham/add",
//        "/chi-tiet-san-pham/delete",
//        "/chi-tiet-san-pham/",
        //Cách 2:
        "/chi-tiet-san-pham/*",

})
public class AuthFilter implements Filter {
    /**
     *
     * Filter: Bộ lọc => Lọc tất cả các Request xem có được truy cập không
     * Khi chạy Project vào class Implement từ Filter đầu tiên
     * AUTHENTICATION & AUTHORIZATION
     *      + AUTHEN : CHECK TÀI KHOẢN TỒN TẠU HAY KHÔNG TRONG CSDL => 401
     *      + AUTHOR: CHECK XEM TÀI KHOẢN ĐƯỢC TRUY CẬP ĐÚNG QUYỀN HAY KHÔNG => 403
     */
    public void init(FilterConfig config) throws ServletException {
        //Khởi tạo từ lúc ban đầu MỘT LẦN DUY NHẤT
        Filter.super.init(config);
        System.out.println("Chạy một lần duy nhất - init");
    }

    public void destroy() {
        //Phá hủy => Giải phóng tài nguyên => CHẠY MỘT LẦN DUY NHẤT
        Filter.super.destroy();
        System.out.println("Chạy 1 lần duy nhất - destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(request, response);
        //B1: ÉP KIỂU VỀ HttpServletRespone, HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        //B2: gọi session
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("uname");
        if(userName == null){
            //Chưa đăng nhập
            res.sendRedirect("/login");
        } else {
        //Đã đăng nhập thành công
            // ADMIN => ALL đường dẫn
            // Nhân Viên = Category & Product
            //B1: Lấy ra Role của tài khỏan hiện tại
            String roleA = (String) session.getAttribute("role");
            if(roleA.equalsIgnoreCase("Admin")){
                //Truy cập Full
                chain.doFilter(request, response);
            } else {
                String uri = req.getRequestURI();
                if(uri.startsWith("/chi-tiet-san-pham/")){
                    chain.doFilter(request, response);
                }else {
                    //403 => không được phép truy cập
                    res.sendRedirect("/403.jsp");
                }
            }
        }
    }
}
