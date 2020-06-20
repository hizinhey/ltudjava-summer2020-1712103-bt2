package com.hizinngo.hibernate;

import com.hizinngo.hibernate.entity.TaiKhoan;
import com.hizinngo.hibernate.views.MainLoginView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MainFrame extends JFrame{
    // Singleton
    private static MainFrame instance;
    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.setPreShow();
        }
        return instance;
    }

    private TaiKhoan taiKhoan;

    // show and delete;
    public void setPreShow(){
        if(instance.getLayout().getClass() != FlowLayout.class){
            instance.setLayout(new FlowLayout());
        }
        instance.setTitle("Student Manager v1.0");
        instance.setDefaultCloseOperation(EXIT_ON_CLOSE);
        instance.setSize(1280, 800);
        instance.setResizable(false);
    }

    public void updateOnePanel(JPanel panel){
        instance.getContentPane().removeAll();
        instance.add(panel);
    }

    public void updateTwoPanel(JPanel nav, JPanel detail){
        instance.getContentPane().removeAll();
        instance.add(nav);
        instance.add(detail);
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
