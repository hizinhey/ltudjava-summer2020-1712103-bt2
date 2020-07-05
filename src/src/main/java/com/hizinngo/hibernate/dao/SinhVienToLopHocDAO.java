package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.MonHoc;
import com.hizinngo.hibernate.entity.SinhVien;
import com.hizinngo.hibernate.entity.SinhVienToLopHoc;
import com.hizinngo.hibernate.entity.subclass.PackSinhVien;
import com.hizinngo.hibernate.entity.subclass.SinhVienToLopHocPK;
import com.hizinngo.hibernate.entity.subclass.PackDiemMonHoc;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SinhVienToLopHocDAO {
    public static boolean themSinhVienToLopHoc(SinhVienToLopHoc record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienToLopHocDAO.laySinhVienToLopHoc(new SinhVienToLopHocPK(record.getMSSV(), record.getMaLop(), record.getMaMH()))!=null) {
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

    public static SinhVienToLopHoc laySinhVienToLopHoc(SinhVienToLopHocPK pk) {
        SinhVienToLopHoc sinhVienToLopHoc = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            sinhVienToLopHoc = (SinhVienToLopHoc) session.get(SinhVienToLopHoc.class, pk);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return sinhVienToLopHoc;
    }

    public static List<SinhVien> layDanhSachSinhVienTheoLopHoc(String MaLop, String MaMH){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhVien> ds = null;
        try{
            String hql = "select new SinhVien(sv.MSSV, sv.ten, sv.gioiTinh, sv.CMND, sv.tinhTrang, sv.maLop) from SinhVien sv, SinhVienToLopHoc svlh " +
                    "where sv.MSSV = svlh.MSSV and svlh.maLop = '" + MaLop + "' and svlh.maMH = '" + MaMH+"'";
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

    public static boolean capNhatDiemSinhVien(SinhVienToLopHoc record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(laySinhVienToLopHoc(new SinhVienToLopHocPK(record.getMSSV(), record.getMaLop(), record.getMaMH()))==null){
            return false;
        }
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            session.update(record);
            transaction.commit();
        } catch(HibernateException ex){
            transaction.rollback();
            System.err.println(ex);
        } finally {
            session.close();
        }
        return true;
    }

    public static List<PackSinhVien> layDanhSachDiemSinhVienTheoLop(String MaLop, String MaMH){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PackSinhVien> ds = null;
        try{
            String hql = "select new com.hizinngo.hibernate.entity.subclass.PackSinhVien( sv.ten, svlh.MSSV, svlh.diemGK, svlh.diemCK, svlh.diemKhac, svlh.diemTong) " +
                    "from  SinhVienToLopHoc svlh, SinhVien sv " +
                    "where svlh.maLop = '" + MaLop + "' and svlh.maMH = '" + MaMH+"' and sv.MSSV = svlh.MSSV";
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

    public static List<SinhVienToLopHoc> layDanhSachDiemSinhVienTheoLopTraVeSinhVienToLopHoc(String MaLop, String MaMH){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhVienToLopHoc> ds = null;
        try{
            String hql = "select new SinhVienToLopHoc( svlh.MSSV, svlh.maLop, svlh.maMH, svlh.diemGK, svlh.diemCK, svlh.diemKhac, svlh.diemTong) " +
                    "from  SinhVienToLopHoc svlh " +
                    "where svlh.maLop = '" + MaLop + "' and svlh.maMH = '" + MaMH+"'";
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

    public static boolean xoaSinhVienToLopHoc(SinhVienToLopHoc record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        SinhVienToLopHoc getData =SinhVienToLopHocDAO.laySinhVienToLopHoc(new SinhVienToLopHocPK(record.getMSSV(),record.getMaLop(), record.getMaMH()));
        if (getData==null) {
            return false;
        }
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.remove(getData);
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

    public static List<PackDiemMonHoc> layDiemSinhViem(String MSSV){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<PackDiemMonHoc> ds = null;
        try{
            String hql = "select new com.hizinngo.hibernate.entity.subclass.PackDiemMonHoc( mh.maMH, mh.tenMH, svlh.diemGK, svlh.diemCK, svlh.diemKhac, svlh.diemTong) " +
                    "from  SinhVienToLopHoc svlh, MonHoc mh " +
                    "where svlh.MSSV = '" + MSSV + "' and svlh.maMH = mh.maMH";
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

    public static List<SinhVienToLopHoc> layDanhSachSinhVienMonHoc(String MSSV, String monHoc){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhVienToLopHoc> ds = null;
        try{
            String hql = "select new com.hizinngo.hibernate.entity.SinhVienToLopHoc(" +
                    "svlh.MSSV, svlh.maLop, svlh.maMH, svlh.diemGK, svlh.diemCK, svlh.diemKhac, svlh.diemTong) " +
                    "from  SinhVienToLopHoc svlh " +
                    "where svlh.MSSV = '" + MSSV + "' and svlh.maMH = '"+ monHoc +"'";
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

    public static void main(String[] args) {
        System.out.println(layDanhSachSinhVienMonHoc("1742005", "CTT001").get(0).getMSSV());
    }
}
