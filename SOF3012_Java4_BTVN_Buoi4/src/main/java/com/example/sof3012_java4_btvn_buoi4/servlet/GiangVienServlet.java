package com.example.sof3012_java4_btvn_buoi4.servlet;

import com.example.sof3012_java4_btvn_buoi4.entity.GiangVien;
import com.example.sof3012_java4_btvn_buoi4.repository.GiangVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi", //G
        "/giang-vien/search", //G
        "/giang-vien/giang-vien-nu", //G
        "/giang-vien/remove", //G
        "/giang-vien/detai", //G
        "/giang-vien/view-update", //G
        "/giang-vien/update", //P
        "/giang-vien/view-add", //G
        "/giang-vien/add", //P
})
public class GiangVienServlet extends HttpServlet {

    private GiangVienRepository giangVienRepository = new GiangVienRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiGiangVien(request, response);
        } else if (uri.contains("search")) {
            this.searchGiangVien(request, response);
        } else if (uri.contains("giang-vien-nu")) {
            this.giangVienNu(request, response);
        } else if (uri.contains("remove")) {
            this.removeGiangVien(request, response);
        } else if (uri.contains("detai")) {
            this.detailGiangVien(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateGiangVien(request, response);
        } else {
            this.viewAddGiangVien(request, response);
        }
    }

    private void viewAddGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add-giang-vien.jsp").forward(request, response);

    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idViewUpdate");
        GiangVien gv = giangVienRepository.getOne(Long.valueOf(id));
        request.setAttribute("detail", gv);
        request.getRequestDispatcher("/update-giang-vien.jsp").forward(request, response);

    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idDetail");
        GiangVien gv = giangVienRepository.getOne(Long.valueOf(id));
        request.setAttribute("detail", gv);
        request.getRequestDispatcher("/detail-giang-vien.jsp").forward(request, response);
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("idRemove");
        GiangVien gv = giangVienRepository.getOne(Long.valueOf(id));
        giangVienRepository.delete(gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void giangVienNu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String ten = request.getParameter("tenSearch");
//        List<GiangVien> lists = giangVienRepository.searchTen(ten);
//        request.setAttribute("hienThi",lists);
//        request.getRequestDispatcher("/giang-vien/hien-thi").forward(request,response);

        String tenSearch = request.getParameter("tenSearch");
        List<GiangVien> lists = giangVienRepository.searchTen(tenSearch);
        request.setAttribute("hienThi", lists);
        request.getRequestDispatcher("/giangviens.jsp").forward(request, response);
    }

    private void hienThiGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GiangVien> gv = giangVienRepository.getAll();
        request.setAttribute("hienThi", gv);
        request.getRequestDispatcher("/giangviens.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateGiangVien(request, response);
        } else {
            this.addGiangVien(request, response);
        }
    }

    @SneakyThrows
    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) {
        GiangVien gv = new GiangVien();
        BeanUtils.populate(gv, request.getParameterMap());
        giangVienRepository.add(gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    @SneakyThrows
    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idUpdateDate");
        GiangVien gv = giangVienRepository.getOne(Long.valueOf(id));
        request.setAttribute("detail", gv);
        BeanUtils.populate(gv, request.getParameterMap());
        giangVienRepository.update(gv);
        response.sendRedirect("/giang-vien/hien-thi");
    }
}
