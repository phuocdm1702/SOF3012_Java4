package com.example.th02296_sd19309_final_sof3012.repository;

import com.example.th02296_sd19309_final_sof3012.entity.PhongBan;
import com.example.th02296_sd19309_final_sof3012.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class PhongBanRepository {
    private Session session;

    public PhongBanRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<PhongBan> getAll() {
        return session.createQuery("FROM PhongBan ").list();
    }

    public PhongBan getOne(int id) {
        return session.find(PhongBan.class, id);
    }

    public void update(PhongBan phongBan) {
        try {
            session.getTransaction().begin();
            session.merge(phongBan);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void main(String[] args) {
        System.out.println(new PhongBanRepository().getAll());
    }
}
