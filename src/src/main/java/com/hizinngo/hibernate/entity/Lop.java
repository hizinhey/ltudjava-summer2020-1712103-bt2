package com.hizinngo.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "lop")
public class Lop{

    private String MaLop;

    Lop(){MaLop = "null";}

    public Lop(String MaLop){
        this.MaLop = MaLop;
    }

    @Id
    @Column(name = "MaLop")
    public String getMaLop() {
        return MaLop;
    }
    public void setMaLop(String maLop) {
        MaLop = maLop;
    }
}
