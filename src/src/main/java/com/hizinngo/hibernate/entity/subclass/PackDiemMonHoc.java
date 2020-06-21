package com.hizinngo.hibernate.entity.subclass;

public class PackDiemMonHoc {
    private String MaMH;
    private String tenMH;
    private float diem1;
    private float diem2;
    private float diem3;
    private float diem4;

    public PackDiemMonHoc(String maMH, String tenMH, float diem1, float diem2, float diem3, float diem4) {
        MaMH = maMH;
        this.tenMH = tenMH;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.diem4 = diem4;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public float getDiem1() {
        return diem1;
    }

    public void setDiem1(float diem1) {
        this.diem1 = diem1;
    }

    public float getDiem2() {
        return diem2;
    }

    public void setDiem2(float diem2) {
        this.diem2 = diem2;
    }

    public float getDiem3() {
        return diem3;
    }

    public void setDiem3(float diem3) {
        this.diem3 = diem3;
    }

    public float getDiem4() {
        return diem4;
    }

    public void setDiem4(float diem4) {
        this.diem4 = diem4;
    }
}
