package com.hizinngo.hibernate.entity.subclass;

import java.io.Serializable;

public class SinhVienToLopHocPK implements Serializable {
    private String MSSV;
    private String MaMH;

    public SinhVienToLopHocPK(){};
    public SinhVienToLopHocPK(String MSSV, String maMH) {
        this.MSSV = MSSV;
        MaMH = maMH;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }
}
