package com.example.sof3012_java4_btvn_buoi9.repository;

import com.example.sof3012_java4_btvn_buoi9.entity.ChiTietSanPham;
import com.example.sof3012_java4_btvn_buoi9.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class ChiTietSanPhamRepository {

    private Session session;

    public ChiTietSanPhamRepository(){
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<ChiTietSanPham> getAll(){
        return session.createQuery("FROM ChiTietSanPham").list();
    }

    public ChiTietSanPham getOne(int id){
        return session.find(ChiTietSanPham.class,id);
    }

    public void add(ChiTietSanPham chiTietSanPham){
        try {
            session.getTransaction().begin();
            session.persist(chiTietSanPham);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    public void delete(ChiTietSanPham chiTietSanPham){
        try {
            session.getTransaction().begin();
            session.delete(chiTietSanPham);
            session.getTransaction().commit();
        } catch (Exception e){
            session.getTransaction().rollback();
        }
    }

    public List<ChiTietSanPham> phanTrangHQL(int pageNo, int pageSize){
        int offsetPT = (pageNo-1) * pageSize;
        String hql = "SELECT chiTietSanPham FROM ChiTietSanPham chiTietSanPham ORDER BY chiTietSanPham.id";
        Query query = session.createQuery(hql);
            query.setFirstResult(offsetPT);
            query.setMaxResults(pageSize);
            return query.getResultList();
    }

    public static void main(String[] args) {
        System.out.println(new ChiTietSanPhamRepository().phanTrangHQL(0,5));
    }
}
