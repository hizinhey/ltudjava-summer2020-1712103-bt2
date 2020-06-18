package com.hizinngo.hibernate;

import com.hizinngo.hibernate.model.Lop;
import com.hizinngo.hibernate.utils.LopDAO;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Lop> ds = LopDAO.layDanhSachLop();
        System.out.println("So luong: " + ds.size());
        for(Lop i : ds){
            System.out.println(i.getMaLop());
        }
    }
}
