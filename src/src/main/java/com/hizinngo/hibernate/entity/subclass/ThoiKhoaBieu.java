package com.hizinngo.hibernate.entity.subclass;

import java.io.Serializable;

public class ThoiKhoaBieu implements Serializable {
    private String MaLop;
    private String MaMH;
    private String TenMH;
    private String Phong;

    public ThoiKhoaBieu(String maLop, String maMH, String tenMH, String phong) {
        MaLop = maLop;
        MaMH = maMH;
        TenMH = tenMH;
        Phong = phong;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public String getPhong() {
        return Phong;
    }

    public void setPhong(String phong) {
        Phong = phong;
    }
}
