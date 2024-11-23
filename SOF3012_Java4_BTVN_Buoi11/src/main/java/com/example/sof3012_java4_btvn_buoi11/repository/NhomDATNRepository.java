package com.example.sof3012_java4_btvn_buoi11.repository;

import com.example.sof3012_java4_btvn_buoi11.entity.NhomDATN;
import com.example.sof3012_java4_btvn_buoi11.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class NhomDATNRepository {
    private Session session;

    public NhomDATNRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<NhomDATN> getAll() {
        return session.createQuery("FROM NhomDATN").list();
    }

    public NhomDATN getOne(int id) {
        return session.find(NhomDATN.class, id);
    }

    public void add(NhomDATN nhomDATN) {
        try {
            session.getTransaction().begin();
            session.persist(nhomDATN);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void update(NhomDATN nhomDATN) {
        try {
            session.getTransaction().begin();
            session.merge(nhomDATN);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(NhomDATN nhomDATN) {
        try {
            session.getTransaction().begin();
            session.delete(nhomDATN);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public List<NhomDATN> phanTrangHql(int pageNo, int pageSize) {
        int offsetPage = (pageNo - 1) * pageSize;
        String hql = "SELECT nhomDATN FROM NhomDATN nhomDATN ORDER BY nhomDATN.id";
        Query query = session.createQuery(hql);
        query.setFirstResult(offsetPage);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    public static void main(String[] args) {

        System.out.println(new NhomDATNRepository().phanTrangHql(1,2));
    }
}
