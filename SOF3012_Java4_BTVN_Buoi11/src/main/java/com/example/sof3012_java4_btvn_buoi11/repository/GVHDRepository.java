package com.example.sof3012_java4_btvn_buoi11.repository;

import com.example.sof3012_java4_btvn_buoi11.entity.GiangVienHD;
import com.example.sof3012_java4_btvn_buoi11.entity.NhomDATN;
import com.example.sof3012_java4_btvn_buoi11.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class GVHDRepository {
    private Session session;

    public GVHDRepository(){
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<GiangVienHD> getMaGVHD(){
        return session.createQuery("FROM GiangVienHD ").list();
    }
    public GiangVienHD getOne(int id){
        return session.find(GiangVienHD.class,id);
    }

    public static void main(String[] args) {
        System.out.println(new GVHDRepository().getMaGVHD());
    }
}
