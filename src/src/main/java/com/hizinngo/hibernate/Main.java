package com.hizinngo.hibernate;

import com.hizinngo.hibernate.entity.Lop;
import com.hizinngo.hibernate.dao.LopDAO;
import com.hizinngo.hibernate.views.LoginView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args){
        JFrame a = new LoginView();

        a.setVisible(true);
    }
}
