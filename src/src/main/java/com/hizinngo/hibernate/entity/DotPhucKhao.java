package com.hizinngo.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dotphuckhao")
public class DotPhucKhao {
    private int id;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public DotPhucKhao(){};
    public DotPhucKhao(int id, Date ngayBatDau, Date ngayKetThuc) {
        this.id = id;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NgayBatDau")
    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    @Column(name = "NgayKetThuc")
    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
