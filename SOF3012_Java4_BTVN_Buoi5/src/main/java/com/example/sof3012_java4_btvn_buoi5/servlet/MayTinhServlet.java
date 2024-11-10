package com.example.sof3012_java4_btvn_buoi5.servlet;

import com.example.sof3012_java4_btvn_buoi5.entity.MayTinh;
import com.example.sof3012_java4_btvn_buoi5.repository.MayTinhRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "MayTinhServlet", value = {
        "/may-tinh/hien-thi",
        "/may-tinh/detail",
        "/may-tinh/view-update",
        "/may-tinh/update",
        "/may-tinh/delete",
        "/may-tinh/add",
})
public class MayTinhServlet extends HttpServlet {

    private MayTinhRepository mayTinhRepository = new MayTinhRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("hien-thi")){
            this.hienThiMayTinh(request, response);
        } else if (uri.contains("detail")) {
            this.detailMayTinh(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateMayTinh(request, response);
        } else {
            this.deleteMayTinh(request, response);
        }
    }

    private void deleteMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = (request.getParameter("maDelete"));
        MayTinh mayTinh = mayTinhRepository.getOne(Integer.parseInt(ma));
        mayTinhRepository.delete(mayTinh);
        response.sendRedirect("/may-tinh/hien-thi");
    }

    private void viewUpdateMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = (request.getParameter("maUpdate"));
        MayTinh mayTinh = mayTinhRepository.getOne(Integer.parseInt(ma));
        // gọi lại hãng
        List<MayTinh> listHang = mayTinhRepository.getHang();
        request.setAttribute("hienThiHang",listHang);

        request.setAttribute("detailUpdate",mayTinh);
        request.getRequestDispatcher("/view/update-maytinh.jsp").forward(request, response);
    }

    private void detailMayTinh(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = (request.getParameter("maDetail"));
        MayTinh mayTinh = mayTinhRepository.getOne(Integer.parseInt(ma));

        List<MayTinh> mayTinhList = mayTinhRepository.getAll();
        request.setAttribute("hienThi", mayTinhList);

        List<MayTinh> listHang = mayTinhRepository.getHang();
        request.setAttribute("hienThiHang",listHang);

        request.setAttribute("detail",mayTinh);
        request.getRequestDispatcher("/view/maytinhs.jsp").forward(request, response);
    }

    private void hienThiMayTinh(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // cbo hang may tinh
        List<MayTinh> listHang = mayTinhRepository.getHang();
        request.setAttribute("hienThiHang",listHang);
        // table
        List<MayTinh> lists = mayTinhRepository.getAll();
        request.setAttribute("hienThi", lists);
        request.getRequestDispatcher("/view/maytinhs.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("update")){
            this.updateMayTinh(request, response);
        }else {
            this.addMayTinh(request, response);
        }
    }
@SneakyThrows
    private void addMayTinh(HttpServletRequest request, HttpServletResponse response) {
    String ten = request.getParameter("ten");

    if (ten == null || ten.trim().isEmpty()) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script type='text/javascript'>");
        out.println("alert('Vui lòng nhập tên');");
        out.println("window.location.href='/may-tinh/hien-thi';");
        out.println("</script>");
        return;
    }

    MayTinh mayTinh = new MayTinh();
    try {
        BeanUtils.populate(mayTinh, request.getParameterMap());
        mayTinhRepository.add(mayTinh);
    } catch (Exception e) {
        e.printStackTrace();
    }
    response.sendRedirect("/may-tinh/hien-thi");


//        String ten = request.getParameter("ten");
//        if(ten.isEmpty()){
//            return JOptionPane.showMessageDialog(this,"Vui lòng nhập tên","ERROR", JOptionPane.WARNING_MESSAGE);
//        }else {
//            MayTinh mayTinh = new MayTinh();
//            BeanUtils.populate(mayTinh, request.getParameterMap());
//            mayTinhRepository.add(mayTinh);
//            response.sendRedirect("/may-tinh/hien-thi");
//        }
    }


    @SneakyThrows
    private void updateMayTinh(HttpServletRequest request, HttpServletResponse response) {
        String ma = (request.getParameter("idUpdate"));
        MayTinh mayTinh = mayTinhRepository.getOne(Integer.parseInt(ma));
        request.setAttribute("detail",mayTinh);
        BeanUtils.populate(mayTinh, request.getParameterMap());
        mayTinhRepository.update(mayTinh);
        response.sendRedirect("/may-tinh/hien-thi");
    }
}
