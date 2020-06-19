package com.hizinngo.hibernate.entity;

import com.hizinngo.hibernate.entity.subclass.LopToMonHocPK;

import javax.persistence.*;

@Entity
@Table(name = "lop_monhoc")
@IdClass(LopToMonHocPK.class)
public class LopToMonHoc {
    private String MaLop;
    private String MaMH;
    private String Phong;

    public LopToMonHoc(){};
    public LopToMonHoc(String maLop, String maMH, String phong) {
        MaLop = maLop;
        MaMH = maMH;
        Phong = phong;
    }

    @Id
    @Column(name = "MaLop")
    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    @Id
    @Column(name = "MaMH")
    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    @Column(name = "Phong")
    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
    }
}
