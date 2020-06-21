package com.hizinngo.hibernate.entity;

import com.hizinngo.hibernate.entity.subclass.SinhVienToLopHocPK;

import javax.persistence.*;

@Entity
@Table(name = "sinhvien_lophoc")
@IdClass(SinhVienToLopHocPK.class)
public class SinhVienToLopHoc {
    private String MSSV;
    private String MaLop;
    private String MaMH;
    private float DiemGK;
    private float DiemCK;
    private float DiemKhac;
    private float DiemTong;

    public SinhVienToLopHoc(){
    };
    public SinhVienToLopHoc(String MSSV, String maLop, String maMH, float diemGK, float diemCK, float diemKhac, float diemTong) {
        this.MSSV = MSSV;
        MaLop = maLop;
        MaMH = maMH;
        DiemGK = diemGK;
        DiemCK = diemCK;
        DiemKhac = diemKhac;
        DiemTong = diemTong;
    }

    @Id
    @Column(name = "MSSV")
    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
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

    @Column(name = "DiemGK")
    public float getDiemGK() {
        return DiemGK;
    }

    public void setDiemGK(float diemGK) {
        DiemGK = diemGK;
    }

    @Column(name = "DiemCK")
    public float getDiemCK() {
        return DiemCK;
    }

    public void setDiemCK(float diemCK) {
        DiemCK = diemCK;
    }

    @Column(name = "DiemKhac")
    public float getDiemKhac() {
        return DiemKhac;
    }

    public void setDiemKhac(float diemKhac) {
        DiemKhac = diemKhac;
    }

    @Column(name = "DiemTong")
    public float getDiemTong() {
        return DiemTong;
    }

    public void setDiemTong(float diemTong) {
        DiemTong = diemTong;
    }
}
