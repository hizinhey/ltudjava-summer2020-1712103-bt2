package com.hizinngo.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

public class Lop implements Serializable {
    private String MaLop;

    Lop(){MaLop = "null";}

    Lop(String MaLop){
        this.MaLop = MaLop;
    }

    public String getMaLop() {
        return MaLop;
    }
    public void setMaLop(String maLop) {
        MaLop = maLop;
    }
}
