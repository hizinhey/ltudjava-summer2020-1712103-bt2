package com.hizinngo.hibernate;

import com.hizinngo.hibernate.entity.TaiKhoan;

import javax.swing.*;

public class MainFrame extends JFrame {
    // Singleton
    private static MainFrame instance = null;
    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

    private JPanel main;
    private JPanel nav;
    private TaiKhoan taiKhoan;

    public void addMainPanel(JPanel main){
        removeAll();
        this.main = main;
        add(main);
    }

    public  void addTwoPanel(JPanel nav, JPanel main){
        removeAll();
        this.main = main;
        this.nav = nav;
        add(nav);
        add(main);
    }

    // show and delete;
    public void showUI(){
        setTitle("Student Manager v1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setSize(1280, 768);
        setResizable(false);
        setVisible(true);
    }

    public void disShowUI(){
        //TODO:
        if(!isShowing()) {dispose();}
    }
}
