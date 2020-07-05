package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.DonPhucKhao;
import com.hizinngo.hibernate.entity.DotPhucKhao;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DonPhucKhaoDAO {
    public static List<DonPhucKhao> layDanhSachDonPhucKhao(){
        List<DonPhucKhao> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "from DonPhucKhao";
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
/*        if (DonPhucKhaoDAO.layDonPhucKhao(record.getId())!=null) {
            return false;
        } */
        if(DonPhucKhaoDAO.layDonPhucKhao(record.getMSSV(), record.getMon(), record.getCotDiem()) != null){
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

    public static DonPhucKhao layDonPhucKhao(String MSSV, String Mon, int CotDiem){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DonPhucKhao>  ds = new ArrayList<>();
        try {
            String hql = "from DonPhucKhao dpk where dpk.MSSV = '"+ MSSV+"' and dpk.mon = '"+Mon+"' and dpk.cotDiem = "+CotDiem;
            Query query = session.createQuery(hql);
            ds = query.list();
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }

        if(ds.size() != 1){
            return null;
        } else {
            return ds.get(0);
        }
    }

    public static List<DonPhucKhao> layDanhSachDonPhucKhao(String MSSV){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<DonPhucKhao>  ds = new ArrayList<>();
        try {
            String hql = "from DonPhucKhao dpk where dpk.MSSV = '"+ MSSV +"'";
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

    public static boolean xoaMotDonPhucKhao(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        DonPhucKhao record = DonPhucKhaoDAO.layDonPhucKhao(id);

        if (record==null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(record);
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

    public static boolean capNhatMotDonPhucKhao(DonPhucKhao record){
        Session session = HibernateUtil.getSessionFactory().openSession();

        if (DonPhucKhaoDAO.layDonPhucKhao(record.getId()) == null) {
            return false;
        }

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(record);
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

    }
}
