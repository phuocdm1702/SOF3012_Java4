package com.example.sof3012_java4_btvn_buoi5.repository;

import com.example.sof3012_java4_btvn_buoi5.entity.MayTinh;
import com.example.sof3012_java4_btvn_buoi5.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class MayTinhRepository {

    private Session session;

    public MayTinhRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<MayTinh> getAll() {
        return session.createQuery("FROM MayTinh ").list();
    }

    public List<MayTinh> getHang() {
        String hql = "SELECT DISTINCT hang FROM MayTinh";
        Query query = session.createQuery(hql);
        return query.getResultList();
    }

    public MayTinh getOne(int ma) {
        return session.find(MayTinh.class, ma);
    }

    public void add(MayTinh mayTinh) {
        try {
            session.getTransaction().begin();
            session.persist(mayTinh);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void update(MayTinh mayTinh) {
        try {
            session.getTransaction().begin();
            session.merge(mayTinh);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(MayTinh mayTinh) {
        try {
            session.getTransaction().begin();
            session.delete(mayTinh);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }


    public static void main(String[] args) {
        System.out.println(new MayTinhRepository().getHang());
    }
}
