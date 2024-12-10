package com.example.th02296_sd19309_final_sof3012.repository;

import com.example.th02296_sd19309_final_sof3012.entity.LoaiPhongBan;
import com.example.th02296_sd19309_final_sof3012.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class LoaiPhongBanRepository {
    private Session session;

    public LoaiPhongBanRepository() {
        session = HibernateUtil.getFACTORY().openSession();
    }

    public List<LoaiPhongBan> getAll(){
        return session.createQuery("FROM LoaiPhongBan ").list();
    }

    public LoaiPhongBan getOne(int id){
        return session.find(LoaiPhongBan.class,id);
    }

}
