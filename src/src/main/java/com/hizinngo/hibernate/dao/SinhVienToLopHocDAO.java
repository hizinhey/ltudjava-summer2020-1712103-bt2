package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.LopToMonHoc;
import com.hizinngo.hibernate.entity.SinhVien;
import com.hizinngo.hibernate.entity.SinhVienToLopHoc;
import com.hizinngo.hibernate.entity.subclass.LopToMonHocPK;
import com.hizinngo.hibernate.entity.subclass.SinhVienToLopHocPK;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SinhVienToLopHocDAO {
    public static boolean themSinhVienToLopHoc(SinhVienToLopHoc record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (SinhVienToLopHocDAO.laySinhVienToLopHoc(new SinhVienToLopHocPK(record.getMSSV(), record.getMaMH()))!=null) {
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
        if(laySinhVienToLopHoc(new SinhVienToLopHocPK(record.getMSSV(), record.getMaMH()))==null){
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

    public static List<SinhVienToLopHoc> layDanhSachDiemSinhVienTheoLop(String MaLop, String MaMH){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SinhVienToLopHoc> ds = null;
        try{
            String hql = "select new SinhVienToLopHoc(svlh.MSSV, svlh.maLop, svlh.maMH, svlh.diemGK, svlh.diemCK, svlh.diemKhac, svlh.diemTong) " +
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

    public static void main(String[] args) {
        System.out.println(layDanhSachDiemSinhVienTheoLop("TEST1", "TEST1").size());
    }
}
