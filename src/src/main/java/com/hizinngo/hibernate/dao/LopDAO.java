package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.DonPhucKhao;
import com.hizinngo.hibernate.entity.Lop;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LopDAO {
    // Lay List danh sanh lop dang co
    public static List<Lop> layDanhSachLop(){
        List<Lop> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "from Lop";
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return ds;
    }

    // Add vao 1 lop moi
    public static boolean themLop(Lop record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (LopDAO.layLop(record.getMaLop())!= null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(record);
            transaction.commit();
        } catch (HibernateException ex) {
            //Log the exception
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static Lop layLop(String MaLop){
        Lop lop = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            lop = (Lop) session.get(Lop.class, MaLop);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return lop;
    }

    public static void main(String[] args) {
        System.out.println(LopDAO.themLop(new Lop("TEST3")));
    }
}
