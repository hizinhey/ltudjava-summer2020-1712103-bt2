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

public class DonPhucKhaoDAO {
    public static List<DonPhucKhao> layDanhSachDonPhucKhao(){
        List<DonPhucKhao> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "from donphuckhao";
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

    public static DonPhucKhao layDonPhucKhao(int id){
        DonPhucKhao donPhucKhao = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            donPhucKhao = (DonPhucKhao) session.get(DonPhucKhao.class, id);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return donPhucKhao;
    }

    public static boolean themDonPhucKhao(DonPhucKhao record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (DonPhucKhaoDAO.layDonPhucKhao(record.getId())!=null) {
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
    public static void main(String[] args) {
        //TODO: Test DonPhucKhao
        DonPhucKhaoDAO.themDonPhucKhao(new DonPhucKhao(2, "testsv1", "test2", "TEST1",
                "DiemGK", 9.5f, "Em khong biet",
                1, DotPhucKhaoDAO.layDotPhucKhao(3)));
    }
}
