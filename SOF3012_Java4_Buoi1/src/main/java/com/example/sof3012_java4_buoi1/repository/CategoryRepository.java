package com.example.sof3012_java4_buoi1.repository;

import com.example.sof3012_java4_buoi1.util.HibernateConfig;
import jakarta.persistence.Query;
import org.hibernate.Session;
import com.example.sof3012_java4_buoi1.entity.Category;
import java.util.List;

public class CategoryRepository {
    /**
     * CRUD : La tang trao doi truoc tien vs DB
     * Mo cong ket noi
     * J3: Connection
     * J4: Session
     * Mo 1 PHIEN DUY NHAT
     */

    private Session s;

    public CategoryRepository(){
        s = HibernateConfig.getFACTORY().openSession();
    }

    // Session => READ
    public List<Category> getAll(){
        return s.createQuery("FROM Category").list();
    }

    // Detail
    public Category getOne(Long id){
        return s.find(Category.class, id);
    }

    // getone2 = search
    public Category searchCate(Long id){
//        String hql = "SELECT cate FROM Category cate WHERE id = ?1";
        String hql = "SELECT cate FROM Category cate WHERE id = :a1";
        Query query = s.createQuery(hql);
        query.setParameter("a1",id);
        Category cate = (Category) query.getSingleResult();
        return cate;
    }

    public List<Category> sortCate(String name){
        String hql = "SELECT cate FROM Category cate WHERE categoryName LIKE :a1";
        Query query = s.createQuery(hql);
        query.setParameter("a1", "%" + name + "%");
        return query.getResultList();
    }
    // Them/ Sua/ Xoa
    //Transation

    public void add(Category cate){
        try {
            // B1: Lay transation hien tai
            s.getTransaction().begin();
            //B2: Them/Sua/Xoa
            //Them : save / saveOrUpdate / persit
            s.persist(cate);
            //B3: Day du lieu di
            s.getTransaction().commit();
        }catch (Exception e){
            //rollBack lai du lieu
            s.getTransaction().rollback();

        }
    }

    public void update(Category cate){
        try {
            // B1: Lay transation hien tai
            s.getTransaction().begin();
            //B2: Them/Sua/Xoa
            //Sua : saveOrUpdate / merge
            s.merge(cate);
            //B3: Day du lieu di
            s.getTransaction().commit();
        }catch (Exception e){
            //rollBack lai du lieu
            s.getTransaction().rollback();

        }
    }
    public void delete(Category cate){
        try {
            // B1: Lay transation hien tai
            s.getTransaction().begin();
            //B2: Them/Sua/Xoa
            //Xoa : delete
            s.delete(cate);
            //B3: Day du lieu di
            s.getTransaction().commit();
        }catch (Exception e){
            //rollBack lai du lieu
            s.getTransaction().rollback();

        }
    }

    public static void main(String[] args) {
        System.out.print(new CategoryRepository().searchCate(1L));
    }
}

