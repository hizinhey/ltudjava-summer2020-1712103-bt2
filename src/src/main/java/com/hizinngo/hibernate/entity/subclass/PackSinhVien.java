package com.hizinngo.hibernate.entity.subclass;

import com.hizinngo.hibernate.entity.SinhVien;
import com.hizinngo.hibernate.entity.SinhVienToLopHoc;

import java.io.Serializable;

public class PackSinhVien implements Serializable {
    private String name;
    private String MSSV;
    private float DiemGK;
    private float DiemCK;
    private float DiemKhac;
    private float DiemTong;

    public PackSinhVien(String name, String MSSV, float diemGK, float diemCK, float diemKhac, float diemTong) {
        this.name = name;
        this.MSSV = MSSV;
        DiemGK = diemGK;
        DiemCK = diemCK;
        DiemKhac = diemKhac;
        DiemTong = diemTong;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public float getDiemGK() {
        return DiemGK;
    }

    public void setDiemGK(float diemGK) {
        DiemGK = diemGK;
    }

    public float getDiemCK() {
        return DiemCK;
    }

    public void setDiemCK(float diemCK) {
        DiemCK = diemCK;
    }

    public float getDiemKhac() {
        return DiemKhac;
    }

    public void setDiemKhac(float diemKhac) {
        DiemKhac = diemKhac;
    }

    public float getDiemTong() {
        return DiemTong;
    }

    public void setDiemTong(float diemTong) {
        DiemTong = diemTong;
    }
}
