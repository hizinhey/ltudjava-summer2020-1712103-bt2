package com.hizinngo.hibernate;

import com.hizinngo.hibernate.views.DanhSachLopView;
import com.hizinngo.hibernate.views.DoiMatKhauView;
import com.hizinngo.hibernate.views.MainLoginView;
import com.hizinngo.hibernate.views.Navigation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = MainFrame.getInstance();
        frame.updateOnePanel(new MainLoginView());
        frame.setVisible(true);
    }
}
