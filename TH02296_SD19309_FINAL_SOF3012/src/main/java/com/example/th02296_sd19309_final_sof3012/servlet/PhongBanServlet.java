package com.example.th02296_sd19309_final_sof3012.servlet;

import com.example.th02296_sd19309_final_sof3012.entity.LoaiPhongBan;
import com.example.th02296_sd19309_final_sof3012.entity.PhongBan;
import com.example.th02296_sd19309_final_sof3012.repository.LoaiPhongBanRepository;
import com.example.th02296_sd19309_final_sof3012.repository.PhongBanRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhongBanServlet", value = {
        "/phong-ban/hien-thi",
        "/phong-ban/update",
        "/phong-ban/detail",
})
public class PhongBanServlet extends HttpServlet {
    private PhongBanRepository phongBanRepository = new PhongBanRepository();
    private LoaiPhongBanRepository loaiPhongBanRepository = new LoaiPhongBanRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiPhongBan(request, response);
        } else {
            this.detailPhongBan(request, response);
        }
    }

    private void detailPhongBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cbb
        List<LoaiPhongBan> listCbb = loaiPhongBanRepository.getAll();
        request.setAttribute("hienThiCbb", listCbb);
        //Table
        List<PhongBan> listHienThi = phongBanRepository.getAll();
        request.setAttribute("hienThi", listHienThi);
        //Detail
        String id = request.getParameter("idDetail");
        PhongBan detailPB = phongBanRepository.getOne(Integer.parseInt(id));
        request.setAttribute("detail", detailPB);
        request.getRequestDispatcher("/phong-bans.jsp").forward(request, response);
    }

    private void hienThiPhongBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cbb
        List<LoaiPhongBan> listCbb = loaiPhongBanRepository.getAll();
        request.setAttribute("hienThiCbb", listCbb);
        //Table
        List<PhongBan> listHienThi = phongBanRepository.getAll();
        request.setAttribute("hienThi", listHienThi);
        request.getRequestDispatcher("/phong-bans.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            PhongBan phongBan = phongBanRepository.getOne(Integer.parseInt(request.getParameter("idUpdate")));
            LoaiPhongBan loaiPhongBan = loaiPhongBanRepository.getOne(Integer.parseInt(request.getParameter("cbbMaLPB")));
            BeanUtils.populate(phongBan, request.getParameterMap());
            phongBan.setLpb(loaiPhongBan);
            phongBanRepository.update(phongBan);
            response.sendRedirect("/phong-ban/hien-thi");
        }
    }
}
