package com.example.sof3012_java4_btvn_buoi4.repository;

import com.example.sof3012_java4_btvn_buoi4.entity.GiangVien;
import com.example.sof3012_java4_btvn_buoi4.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class GiangVienRepository {

    private Session session;

    public GiangVienRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<GiangVien> getAll() {
        return session.createQuery("FROM GiangVien ").list();
    }

    public GiangVien getOne(Long id) {
        return session.find(GiangVien.class, id);
    }

    public List<GiangVien> searchTen(String ten) {
        String hql = "SELECT giangVien FROM GiangVien giangVien WHERE giangVien.ten LIKE :ten";
        Query query = session.createQuery(hql);
        query.setParameter("ten", "%" + ten + "%");
        return query.getResultList(); // Trả về danh sách
    }

    public void add(GiangVien giangVien) {
        try {
            session.getTransaction().begin();
            session.persist(giangVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void update(GiangVien giangVien) {
        try {
            session.getTransaction().begin();
            session.merge(giangVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(GiangVien giangVien) {
        try {
            session.getTransaction().begin();
            session.delete(giangVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new GiangVienRepository().searchTen("Sầu riêng"));
    }
}
