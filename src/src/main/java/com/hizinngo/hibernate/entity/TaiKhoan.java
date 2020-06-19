package com.hizinngo.hibernate.entity;

import jdk.jfr.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "taikhoan")
public class TaiKhoan implements Serializable {
    private String Taikhoan;
    private String MatKhau;
    private int Quyen;

    public TaiKhoan(){};
    public TaiKhoan(String taikhoan, String matKhau, int quyen) {
        Taikhoan = taikhoan;
        MatKhau = matKhau;
        Quyen = quyen;
    }

    @Id
    @Column(name = "TaiKhoan")
    public String getTaikhoan() {
        return Taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        Taikhoan = taikhoan;
    }

    @Column(name = "MatKhau")
    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    @Column(name = "Quyen")
    public int getQuyen() {
        return Quyen;
    }

    public void setQuyen(int quyen) {
        Quyen = quyen;
    }
}
