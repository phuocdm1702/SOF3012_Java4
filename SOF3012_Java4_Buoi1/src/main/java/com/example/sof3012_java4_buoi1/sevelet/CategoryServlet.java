package com.example.sof3012_java4_buoi1.sevelet;

import com.example.sof3012_java4_buoi1.entity.Category;
import com.example.sof3012_java4_buoi1.repository.CategoryRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = {
        "/category/hien-thi", // G
        "/category/detail", // G
        "/category/delete", // G
        "/category/view-update", // G
        "/category/update", // P
        "/category/view-add", // G
        "/category/add", // P
        "/category/search" //G
})
/**
 * WebSevlet:
 * +Name: Khong bat buoc
 * +Value: Bat buoc
 * => chua duong dan (CHUA TAT CA CAC DUONG DAN CUA DE BAI)
 * Duong dan:
 *          + Duong dan bat dau /
 *          + Duong dan la duy nhat (Unique)
 */
public class CategoryServlet extends HttpServlet {

    private CategoryRepository categoryRepository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/**
 * BE & FE : Trao doi thong qua phuong thuc HTTP
 *          => GET, POST, PUT, DELETE
 *          => J3 & J4 & J5: GET & POST
 *
 *   +GET = Lay, Hien thi...
 *   +POST = xu ly FORM
 */

        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThiCate(request, response);
        } else if (uri.contains("detail")) {
            this.detailCate(request, response);
        } else if (uri.contains("delete")) {
            this.deleteCate(request, response);
        } else if (uri.contains("view-update")) {
            this.viewUpdateCate(request, response);
        } else if (uri.contains("view-add")) {
            this.viewAddCate(request, response);
        } else {
            this.searchCate(request, response);
        }
    }

    private void searchCate(HttpServletRequest request, HttpServletResponse response) {

    }

    private void viewAddCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add-category.jsp").forward(request, response);
    }

    private void viewUpdateCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idUpdate");
        Category cate = categoryRepository.getOne(Long.valueOf(id));
        request.setAttribute("detailCate", cate);
        request.getRequestDispatcher("/update-cate.jsp").forward(request, response);

    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("idDelete");
        Category cate = categoryRepository.getOne(Long.valueOf(id));
        categoryRepository.delete(cate);
        response.sendRedirect("/category/hien-thi");

    }

    private void detailCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idDetail");
        Category cate = categoryRepository.getOne(Long.valueOf(id));
        request.setAttribute("detailCate", cate);
        request.getRequestDispatcher("/detail-cate.jsp").forward(request, response);
    }

    private void hienThiCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> lists = categoryRepository.getAll(); //Lay ham getAll()
        request.setAttribute("Cate", lists); // Day list => jsp
        request.getRequestDispatcher("/categorys.jsp").forward(request, response); // Chuyen trang
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateCate(request, response);
        } else {
            this.addCate(request, response);
        }
    }

    @SneakyThrows
    private void addCate(HttpServletRequest request, HttpServletResponse response) {
        Category category = new Category();
        BeanUtils.populate(category, request.getParameterMap());
        categoryRepository.add(category);
        response.sendRedirect("/category/hien-thi");
    }

    @SneakyThrows
    private void updateCate(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("idUpdate");
        Category cate = categoryRepository.getOne(Long.valueOf(id));
        request.setAttribute("detailCate", cate);
        BeanUtils.populate(cate, request.getParameterMap());
        categoryRepository.update(cate);
        response.sendRedirect("/category/hien-thi");
    }
}
