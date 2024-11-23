package com.example.sof3012_java4_btvn_buoi11.servlet;

import com.example.sof3012_java4_btvn_buoi11.entity.GiangVienHD;
import com.example.sof3012_java4_btvn_buoi11.entity.NhomDATN;
import com.example.sof3012_java4_btvn_buoi11.repository.GVHDRepository;
import com.example.sof3012_java4_btvn_buoi11.repository.NhomDATNRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhomDATNServlet", value = {
        "/nhom-datn/hien-thi",
        "/nhom-datn/add",
        "/nhom-datn/detail",
        "/nhom-datn/delete",
        "/nhom-datn/view-update",
        "/nhom-datn/update",
})
public class NhomDATNServlet extends HttpServlet {
    private NhomDATNRepository nhomDATNRepository = new NhomDATNRepository();
    private GVHDRepository gvhdRepository = new GVHDRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiNhomDATN(request, response);
        } else if (uri.contains("detail")) {
            this.DetailNhomDATN(request, response);
        } else if (uri.contains("delete")) {
            this.deleteNhomDATN(request, response);
        } else {
            this.viewUpdateNhomDATN(request, response);
        }
    }

    private void viewUpdateNhomDATN(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cbb
        List<GiangVienHD> listCbb = gvhdRepository.getMaGVHD();
        request.setAttribute("hienThiCbb", listCbb);

        //ViewUpdate
        String id = request.getParameter("idViewUpdate");
        NhomDATN listViewUpdate = nhomDATNRepository.getOne(Integer.parseInt(id));
        request.setAttribute("viewUpdate",listViewUpdate);
        request.getRequestDispatcher("/update_nhom_datn.jsp").forward(request, response);

    }

    private void deleteNhomDATN(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("idDelete");
        NhomDATN listDelete = nhomDATNRepository.getOne(Integer.parseInt(id));
        nhomDATNRepository.delete(listDelete);
        response.sendRedirect("/nhom-datn/hien-thi");
    }

    private void DetailNhomDATN(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cbb
        List<GiangVienHD> listCbb = gvhdRepository.getMaGVHD();
        request.setAttribute("hienThiCbb", listCbb);
        //Table
        List<NhomDATN> listHienThi = nhomDATNRepository.getAll();
        request.setAttribute("hienThi", listHienThi);
        //Detail
        String id = request.getParameter("idDetail");
        NhomDATN listDetail = nhomDATNRepository.getOne(Integer.parseInt(id));
        request.setAttribute("detail", listDetail);
        request.getRequestDispatcher("/nhom_datns.jsp").forward(request, response);
    }

    private void hienThiNhomDATN(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //phanTrang
        int pageSize = 3;
        int tongtrang = (int) Math.ceil((double) nhomDATNRepository.getAll().size() / pageSize);

        int page = 1;
        String pagePara = request.getParameter("page");
        if(pagePara != null){
            page = Integer.parseInt(pagePara);
        }
        //Cbb
        List<GiangVienHD> listCbb = gvhdRepository.getMaGVHD();
        request.setAttribute("hienThiCbb", listCbb);
        //Table
        List<NhomDATN> listHienThi = nhomDATNRepository.phanTrangHql(page,pageSize);
        request.setAttribute("hienThi", listHienThi);
        request.setAttribute("tongTrang", tongtrang);
        request.setAttribute("hienThiTrang", page);
        request.getRequestDispatcher("/nhom_datns.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.addNhomDATN(request, response);
        } else {
            this.updateNhomDATN(request, response);
        }

    }
    @SneakyThrows
    private void updateNhomDATN(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("idUpdate");
        NhomDATN nhomDATN = nhomDATNRepository.getOne(Integer.parseInt(id));
        request.setAttribute("detail", nhomDATN);
        GiangVienHD giangVienHD = gvhdRepository.getOne(Integer.parseInt(request.getParameter("cbbGVHD")));
        BeanUtils.populate(nhomDATN, request.getParameterMap());
        nhomDATN.setGvhd(giangVienHD);
        nhomDATNRepository.update(nhomDATN);
        response.sendRedirect("/nhom-datn/hien-thi");
    }

    @SneakyThrows
    private void addNhomDATN(HttpServletRequest request, HttpServletResponse response) {
        NhomDATN nhomDATN = new NhomDATN();
        GiangVienHD giangVienHD = gvhdRepository.getOne(Integer.parseInt(request.getParameter("cbbGVHD")));
        BeanUtils.populate(nhomDATN, request.getParameterMap());
        nhomDATN.setGvhd(giangVienHD);
        nhomDATNRepository.add(nhomDATN);
        response.sendRedirect("/nhom-datn/hien-thi");
    }
}
