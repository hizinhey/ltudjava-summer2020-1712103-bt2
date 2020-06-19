package com.hizinngo.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lop_monhoc")
public class LopToMonHoc {
    private String MaLop;
    private String MaMH;
    private String Phong;
    private int TrangThai;

    public LopToMonHoc(String maLop, String maMH, String phong, int trangThai) {
        MaLop = maLop;
        MaMH = maMH;
        Phong = phong;
        TrangThai = trangThai;
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

    @Column(name = "TrangThai")
    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }
}
