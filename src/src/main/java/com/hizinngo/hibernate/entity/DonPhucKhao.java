package com.hizinngo.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "donphuckhao")
public class DonPhucKhao {
    private int id;
    private String MSSV;
    private String HoTen;
    private String Mon;
    private String CotDiem;
    private float DiemMongMuon;
    private String LiDo;
    private int TrangThai;
    private DotPhucKhao DotPhucKhao;


    public DonPhucKhao(){};
    public DonPhucKhao(int id, String MSSV, String hoTen, String mon, String cotDiem, float diemMongMuon, String liDo, int trangThai, DotPhucKhao dotPhucKhao) {
        this.id = id;
        this.MSSV = MSSV;
        HoTen = hoTen;
        Mon = mon;
        CotDiem = cotDiem;
        DiemMongMuon = diemMongMuon;
        LiDo = liDo;
        TrangThai = trangThai;
        DotPhucKhao = dotPhucKhao;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "MSSV")
    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    @Column(name = "HoTen")
    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    @Column(name = "Mon")
    public String getMon() {
        return Mon;
    }

    public void setMon(String mon) {
        Mon = mon;
    }

    @Column(name = "CotDiem")
    public String getCotDiem() {
        return CotDiem;
    }

    public void setCotDiem(String cotDiem) {
        CotDiem = cotDiem;
    }

    @Column(name = "DiemMongMuon")
    public float getDiemMongMuon() {
        return DiemMongMuon;
    }

    public void setDiemMongMuon(float diemMongMuon) {
        DiemMongMuon = diemMongMuon;
    }

    @Column(name = "LiDo")
    public String getLiDo() {
        return LiDo;
    }

    public void setLiDo(String liDo) {
        LiDo = liDo;
    }

    @Column(name = "TrangThai")
    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int trangThai) {
        TrangThai = trangThai;
    }

    @ManyToOne
    @JoinColumn(name = "DotPhucKhao")
    public DotPhucKhao getDotPhucKhao() {
        return DotPhucKhao;
    }

    public void setDotPhucKhao(DotPhucKhao dotPhucKhao) {
        DotPhucKhao = dotPhucKhao;
    }
}
