package com.hizinngo.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "monhoc")
public class MonHoc {
    private String MaMH;
    private String TenMH;

    public MonHoc(){};
    public MonHoc(String maMH, String tenMH) {
        MaMH = maMH;
        TenMH = tenMH;
    }

    @Id
    @Column(name = "MaMH")
    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    @Column(name = "TenMH")
    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }
}
