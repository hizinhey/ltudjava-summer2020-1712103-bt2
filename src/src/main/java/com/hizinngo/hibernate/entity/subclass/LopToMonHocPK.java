package com.hizinngo.hibernate.entity.subclass;

import java.io.Serializable;

public class LopToMonHocPK implements Serializable {
    protected String MaLop;
    protected String MaMH;

    public LopToMonHocPK(){};
    public LopToMonHocPK(String maLop, String maMH) {
        MaLop = maLop;
        MaMH = maMH;
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
