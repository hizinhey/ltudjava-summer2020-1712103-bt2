package com.hizinngo.hibernate.entity.subclass;

import java.io.Serializable;

public class SinhVienToLopHocPK implements Serializable {
    private String MSSV;
    private String MaLop;
    private String MaMH;

    public SinhVienToLopHocPK(){};
    public SinhVienToLopHocPK(String MSSV, String maLop, String maMH) {
        this.MSSV = MSSV;
        this.MaLop = maLop;
        MaMH = maMH;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
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
}
