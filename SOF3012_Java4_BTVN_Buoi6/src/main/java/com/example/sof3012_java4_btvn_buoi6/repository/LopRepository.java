package com.example.sof3012_java4_btvn_buoi6.repository;

import com.example.sof3012_java4_btvn_buoi6.entity.Lop;
import com.example.sof3012_java4_btvn_buoi6.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class LopRepository {

    private Session session;

    public LopRepository(){
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<Lop> getTenLop(){
        String hql = "FROM Lop";
        Query query = session.createQuery(hql);
        return query.getResultList();
    }
    public Lop getOne(int id){
        return session.find(Lop.class, id);
    }

    public static void main(String[] args) {
        System.out.println(new LopRepository().getTenLop());
    }
}
