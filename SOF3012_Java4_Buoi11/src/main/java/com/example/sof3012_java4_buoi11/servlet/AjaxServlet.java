package com.example.sof3012_java4_buoi11.servlet;

import com.example.sof3012_java4_buoi11.entity.SinhVien;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxServlet", value = "/api/ajax/demo")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //B1: Fake Data
        SinhVien sinhVien = new SinhVien("MS001","Nguyen Van A", 10);
        //B2: Convert Object/Array/.. => Json
        Gson gson = new Gson();
        String dt = gson.toJson(sinhVien);
        //B3: Đặt kiểu trả về là json
        response.sendRedirect("/api/ajax/demo");
        //B4: Có thể có => hiển thị giao diện

        PrintWriter out = response.getWriter();
        out.println(dt);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
