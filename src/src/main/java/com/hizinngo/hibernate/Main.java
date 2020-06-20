package com.hizinngo.hibernate;

import com.hizinngo.hibernate.views.LoginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        MainFrame frame = MainFrame.getInstance();
        frame.addMainPanel(new LoginView());
        frame.showUI();
    }
}
