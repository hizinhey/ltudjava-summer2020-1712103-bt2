package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.DonPhucKhao;
import com.hizinngo.hibernate.entity.SinhVien;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SinhVienDAO {
    public static List<SinhVien> layDanhSachSinhVien(){
        List<SinhVien> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "from sinhvien";
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

    public static List<SinhVien> layDanhSachSinhVienTheoLop(String MaLop){
        List<SinhVien> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select new com.hizinngo.hibernate.entity.SinhVien(sv.MSSV, sv.ten, sv.gioiTinh, sv.CMND, sv.tinhTrang, sv.maLop)" +
                    " from SinhVien sv where MaLop = '" + MaLop +"'";
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

    public static SinhVien laySinhVien(String MSSV){
        SinhVien sinhVien = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            sinhVien = (SinhVien) session.get(SinhVien.class, MSSV);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sinhVien;
    }

    public static boolean themSinhVien(SinhVien record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienDAO.laySinhVien(record.getMSSV())!=null) {
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
        SinhVien sv = SinhVienDAO.laySinhVien("testsv1");
        System.out.println(sv);
    }
}
