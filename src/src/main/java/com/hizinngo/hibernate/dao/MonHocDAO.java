package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.MonHoc;
import com.hizinngo.hibernate.entity.SinhVien;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MonHocDAO {
    public static List<MonHoc> layDanhSachSinhVien(){
        List<MonHoc> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "from monhoc";
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

    public static MonHoc layMonHoc(String MaMH){
        MonHoc monHoc = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            monHoc = (MonHoc) session.get(MonHoc.class, MaMH);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return monHoc;
    }

    public static boolean themMonHoc(MonHoc record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (MonHocDAO.layMonHoc(record.getMaMH())!=null) {
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
}
