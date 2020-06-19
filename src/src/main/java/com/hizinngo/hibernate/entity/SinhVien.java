package com.hizinngo.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
    private String MSSV;
    private String ten;
    private String GioiTinh;
    private String CMND;
    private int TinhTrang;
    private String MaLop; //Do lop chua thong tin malop, khong can quan tam many to one

    public SinhVien(String MSSV, String ten, String gioiTinh, String CMND, int tinhTrang, String maLop) {
        this.MSSV = MSSV;
        this.ten = ten;
        GioiTinh = gioiTinh;
        this.CMND = CMND;
        TinhTrang = tinhTrang;
        MaLop = maLop;
    }

    @Id
    @GeneratedValue
    @Column(name = "MSSV")
    public String getMSSV() {
        return MSSV;
    }


    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }


    @Column(name = "ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Column(name = "GioiTinh")
    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    @Column(name = "CMND")
    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    @Column(name = "TinhTrang")
    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        TinhTrang = tinhTrang;
    }

    @Column(name = "MaLop")
    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }
}
