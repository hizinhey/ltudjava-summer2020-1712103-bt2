package com.hizinngo.hibernate.dao;

import com.hizinngo.hibernate.entity.DotPhucKhao;
import com.hizinngo.hibernate.entity.LopToMonHoc;
import com.hizinngo.hibernate.entity.MonHoc;
import com.hizinngo.hibernate.entity.SinhVien;
import com.hizinngo.hibernate.entity.subclass.LopToMonHocPK;
import com.hizinngo.hibernate.entity.subclass.ThoiKhoaBieu;
import com.hizinngo.hibernate.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LopToMonHocDAO {
    public static boolean themLopToMonHoc(LopToMonHoc record){
        Session session = HibernateUtil.getSessionFactory().openSession();
        if (LopToMonHocDAO.layLopToMonHoc(new LopToMonHocPK(record.getMaLop(), record.getMaMH()))!=null) {
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

    public static LopToMonHoc layLopToMonHoc(LopToMonHocPK pk) {
        LopToMonHoc lop = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            lop = (LopToMonHoc) session.get(LopToMonHoc.class, pk);
        } catch (HibernateException ex) {
            //Log the exception
            System.err.println(ex);
        } finally {
            session.close();
        }
        return lop;
    }

    public static List<ThoiKhoaBieu> layThoiKhoaBieuTheoLop(String MaLop){
        List<ThoiKhoaBieu> ds = null;
        Session session = HibernateUtil.getSessionFactory()
                .openSession();
        try {
            String hql = "select new com.hizinngo.hibernate.entity.subclass.ThoiKhoaBieu(lm.maLop, mh.maMH, mh.tenMH, lm.phong)" +
                    " from LopToMonHoc lm, MonHoc mh where lm.maLop = '" + MaLop +"' AND lm.maMH = mh.maMH";
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
        System.out.println(layThoiKhoaBieuTheoLop("TEST3").get(1).getPhong());
    }
}
