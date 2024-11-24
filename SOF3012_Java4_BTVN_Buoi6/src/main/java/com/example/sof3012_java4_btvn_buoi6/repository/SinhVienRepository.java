package com.example.sof3012_java4_btvn_buoi6.repository;

import com.example.sof3012_java4_btvn_buoi6.entity.SinhVien;
import com.example.sof3012_java4_btvn_buoi6.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {

    private Session session;

    public SinhVienRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        return session.createQuery("FROM SinhVien ").list();
    }

    public SinhVien getOne(int id){
        return session.find(SinhVien.class, id);
    }

    public List<SinhVien> searchTenVaTuoi(String ten){
        String hql = "SELECT sinhVien FROM SinhVien sinhVien WHERE sinhVien.ten LIKE :search OR CAST(sinhVien.tuoi AS string) LIKE :search";
        Query query = session.createQuery(hql);
        query.setParameter("search", "%" + ten + "%");
        return query.getResultList();
    }


    public void add(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.persist(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void update(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.merge(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.delete(sinhVien);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new SinhVienRepository().getAll());
    }
}
