package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.TaiKhoan;
import com.hizinngo.hibernate.log.LogUtil;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.w3c.dom.html.HTMLInputElement;

public class TaiKhoanDAO {
    public static boolean taoTaiKhoan(TaiKhoan record){
        if(layTaiKhoan(record.getTaikhoan())!=null){
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.save(record);
            transaction.commit();
        } catch (HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static TaiKhoan layTaiKhoan(String taiKhoan){
        TaiKhoan tk = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            tk = (TaiKhoan)session.get(TaiKhoan.class, taiKhoan);
        } catch (HibernateException ex){
            System.err.println(ex);
            LogUtil.printLog(ex.getMessage());
        } finally {
            session.close();
        }
        return tk;
    }

    // Dung de thay doi mat khau
    public static boolean chinhSuaTaiKhoan(TaiKhoan record) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(layTaiKhoan(record.getTaikhoan())==null){
            return false;
        }
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(record);
            transaction.commit();
        } catch (HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(layTaiKhoan("giaovu").getTaikhoan());;
    }
}
