package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.DonPhucKhao;
import com.hizinngo.hibernate.entity.DotPhucKhao;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class DotPhucKhaoDAO {
    public static List<DotPhucKhao> layDanhSachDotPhucKhao(){
        List<DotPhucKhao> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "from DotPhucKhao";
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

    public static boolean themDotPhucKhao(DotPhucKhao record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (DotPhucKhaoDAO.layDotPhucKhao(record.getId())!=null) {
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

    public static DotPhucKhao layDotPhucKhao(int id){
        DotPhucKhao dotPhucKhao = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            dotPhucKhao = (DotPhucKhao) session.get(DotPhucKhao.class, id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return dotPhucKhao;
    }

    public static void main(String[] args) {
        DotPhucKhao dotPhucKhao = new DotPhucKhao();
        dotPhucKhao.setId(2);
        dotPhucKhao.setNgayBatDau(new Date());
        dotPhucKhao.setNgayKetThuc(new Date());
        DotPhucKhaoDAO.themDotPhucKhao(dotPhucKhao);
    }
}
