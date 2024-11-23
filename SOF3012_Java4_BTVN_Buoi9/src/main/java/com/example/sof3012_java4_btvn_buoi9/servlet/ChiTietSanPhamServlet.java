package com.example.sof3012_java4_btvn_buoi9.servlet;

import com.example.sof3012_java4_btvn_buoi9.entity.ChiTietSanPham;
import com.example.sof3012_java4_btvn_buoi9.entity.DonViTinh;
import com.example.sof3012_java4_btvn_buoi9.repository.ChiTietSanPhamRepository;
import com.example.sof3012_java4_btvn_buoi9.repository.DonViTinhRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChiTietSanPhamServlet", value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/delete",
        "/chi-tiet-san-pham/",
})
public class ChiTietSanPhamServlet extends HttpServlet {

    private ChiTietSanPhamRepository ctspRepository = new ChiTietSanPhamRepository();
    private DonViTinhRepository dvtRepository = new DonViTinhRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiCTSP(request, response);
        } else {
            this.deleteCTSP(request, response);
        }
    }

    private void deleteCTSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("idDelete");
        ChiTietSanPham chiTietSanPham = ctspRepository.getOne(Integer.parseInt(id));
        ctspRepository.delete(chiTietSanPham);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void hienThiCTSP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //PhanTrang
        int pageSize = 5;
        int totalPages = (int) Math.ceil((double) ctspRepository.getAll().size() / pageSize);

        int page = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null) {
            page = Integer.parseInt(pageParam);
        }

        List<ChiTietSanPham> listHienThi = ctspRepository.phanTrangHQL(page, pageSize);
        request.setAttribute("hienThi", listHienThi);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);

        //CBB
        List<DonViTinh> listCBB = dvtRepository.getTenDVT();
        request.setAttribute("hienThiCBB", listCBB);
        request.getRequestDispatcher("/chi-tiet-san-phams.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addCTSP(request, response);
        }
    }

    @SneakyThrows
    private void addCTSP(HttpServletRequest request, HttpServletResponse response) {
        int soLuong = Integer.parseInt(request.getParameter("soLuongTon"));
        Float donGia = Float.valueOf(request.getParameter("donGia"));
        String GhiChu = request.getParameter("ghiChu");
        String tenDVT = request.getParameter("cbbTenDVT");

        DonViTinh donViTinh = dvtRepository.getOneDVT(Integer.parseInt(tenDVT));

        ChiTietSanPham chiTietSanPham = new ChiTietSanPham(0,soLuong, donGia,0L, GhiChu, donViTinh);
        ctspRepository.add(chiTietSanPham);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");

        if(request.getParameter("soLuongTon").trim().isEmpty()){
            request.setAttribute("mesSoLuong","Vui Lòng Nhập vào ô Sô lượng tồn!");
        }
    }


}
