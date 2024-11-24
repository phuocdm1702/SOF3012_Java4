package com.example.sof3012_java4_btvn_buoi6.servlet;

import com.example.sof3012_java4_btvn_buoi6.entity.Lop;
import com.example.sof3012_java4_btvn_buoi6.entity.SinhVien;
import com.example.sof3012_java4_btvn_buoi6.repository.LopRepository;
import com.example.sof3012_java4_btvn_buoi6.repository.SinhVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SinhVienServlet", value = {
        "/sinh-vien/hien-thi", //G
        "/sinh-vien/add", //P
        "/sinh-vien/detail", //G
        "/sinh-vien/delete", //G
        "/sinh-vien/update",//P
        "/sinh-vien/view-update",//G
        "/sinh-vien/search", //G
        "/sinh-vien/top3", //G
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienRepository sinhVienRepository = new SinhVienRepository();
    private LopRepository lopRepository = new LopRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiSinhVien(request, response);
        } else if (uri.contains("detail")) {
            this.detailSinhVien(request, response);
        } else if (uri.contains("delete")) {
            this.deleteSinhVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateSinhVien(request, response);
        } else if (uri.contains("search")) {
            this.searchSinhVien(request, response);
        } else {
            this.top3SinhVien(request, response);
        }
    }

    private void top3SinhVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("Search");
        List<SinhVien> listSearch = sinhVienRepository.searchTenVaTuoi(search);
        request.setAttribute("hienThiTable", listSearch);
        request.getRequestDispatcher("/view/sinhviens.jsp").forward(request, response);
    }

    private void viewUpdateSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //CBO
        List<Lop> listCbo = lopRepository.getTenLop();
        request.setAttribute("hienThiMaLop", listCbo);

        String id = request.getParameter("idViewUpdate");
        SinhVien listViewUpdate = sinhVienRepository.getOne(Integer.parseInt(id));
        request.setAttribute("viewUpdate",listViewUpdate);
        request.getRequestDispatcher("/view/update-sinh-vien.jsp").forward(request, response);
    }

    private void deleteSinhVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("idDelete");
        SinhVien listDelete = sinhVienRepository.getOne(Integer.parseInt(id));
        sinhVienRepository.delete(listDelete);
        response.sendRedirect("/sinh-vien/hien-thi");

    }

    private void detailSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //CBO
        List<Lop> listCbo = lopRepository.getTenLop();
        request.setAttribute("hienThiMaLop", listCbo);
        //table
        List<SinhVien> listHienThi = sinhVienRepository.getAll();
        request.setAttribute("hienThiTable", listHienThi);
        // detail
        String id = request.getParameter("idDetail");
        SinhVien listDetail = sinhVienRepository.getOne(Integer.parseInt(id));
        request.setAttribute("hienThiDetail", listDetail);
        request.getRequestDispatcher("/view/sinhviens.jsp").forward(request, response);
    }

    private void hienThiSinhVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //CBO
        List<Lop> listCbo = lopRepository.getTenLop();
        request.setAttribute("hienThiMaLop", listCbo);
        //table
        List<SinhVien> listHienThi = sinhVienRepository.getAll();
        request.setAttribute("hienThiTable", listHienThi);
        request.getRequestDispatcher("/view/sinhviens.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addSinhVien(request, response);
        } else {
            this.updateSinhVien(request, response);
        }
    }
    @SneakyThrows
    private void updateSinhVien(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idUpdate");
        SinhVien listDetail = sinhVienRepository.getOne(Integer.parseInt(id));
        request.setAttribute("hienThiDetail", listDetail);
        String maSV = request.getParameter("ma");
        String tenSV = request.getParameter("ten");
        Long tuoiSV = Long.valueOf(request.getParameter("tuoi"));
        String diaChiSV = request.getParameter("diaChi");
        int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
        String lopHoc = request.getParameter("cboLop");
        Lop lop = lopRepository.getOne(Integer.parseInt(lopHoc));

        SinhVien sinhVien = new SinhVien(0, maSV,tenSV,tuoiSV,diaChiSV,gioiTinh,lop);
        sinhVienRepository.update(sinhVien);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    @SneakyThrows
    private void addSinhVien(HttpServletRequest request, HttpServletResponse response) {

        SinhVien sinhVien = new SinhVien();
        Lop lop = lopRepository.getOne(Integer.parseInt(request.getParameter("cboLop")));

        // Sử dụng BeanUtils để ánh xạ dữ liệu từ request vào object
        BeanUtils.populate(sinhVien, request.getParameterMap());
        sinhVien.setId(0); // Thiết lập ID mặc định nếu cần
        sinhVien.setLop(lop); // Gán đối tượng Lop vào SinhVien

        sinhVienRepository.add(sinhVien); // Thêm sinh viên vào repository
        response.sendRedirect("/sinh-vien/hien-thi");


//        String maSV = request.getParameter("ma");
//        String tenSV = request.getParameter("ten");
//        Long tuoiSV = Long.valueOf(request.getParameter("tuoi"));
//        String diaChiSV = request.getParameter("diaChi");
//        int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
//        String lopHoc = request.getParameter("cboLop");
//        Lop lop = lopRepository.getOne(Integer.parseInt(lopHoc));
//
//        SinhVien sinhVien = new SinhVien(0, maSV,tenSV,tuoiSV,diaChiSV,gioiTinh,lop);
//        sinhVienRepository.add(sinhVien);
//        response.sendRedirect("/sinh-vien/hien-thi");

    }
}
