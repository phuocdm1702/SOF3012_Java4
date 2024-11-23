package com.example.sof3012_java4_btvn_buoi9.repository;

import com.example.sof3012_java4_btvn_buoi9.entity.DonViTinh;
import com.example.sof3012_java4_btvn_buoi9.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class DonViTinhRepository {
    private Session session;

    public DonViTinhRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<DonViTinh> getTenDVT() {
        return session.createQuery("FROM DonViTinh ").list();
    }
    public DonViTinh getOneDVT(int id){
        return session.find(DonViTinh.class,id);
    }

    public static void main(String[] args) {
        System.out.println(new DonViTinhRepository().getTenDVT());
    }
}
