package com.hizinngo.hibernate.views;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.hizinngo.hibernate.dao.*;
import com.hizinngo.hibernate.entity.*;
import com.hizinngo.hibernate.entity.subclass.PackSinhVien;
import com.hizinngo.hibernate.entity.subclass.ThoiKhoaBieu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author nghia
 */
public class TraCuuDiemView extends javax.swing.JPanel {

    /**
     * Creates new form TraCuuDiemView
     */
    public TraCuuDiemView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setPreferredSize(new Dimension(940,768));

        btnImport = new javax.swing.JButton();
        txtClass = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblClass = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnManage = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        btnImport.setText("Import CSV");
        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                if (fileChooser.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
                    File csv = fileChooser.getSelectedFile().getAbsoluteFile();
                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(csv));
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                    String lop, temp;
                    List<SinhVienToLopHoc> list = new ArrayList<>();

                    try {
                        lop = br.readLine();
                        System.out.println(lop);
                        List<String> strLop = Arrays.asList(lop.split("-"));
                        System.out.println(strLop.size()+ " con heo con");
                        while ((temp = br.readLine()) != null) {
                            List<String> tempStr = Arrays.asList(temp.split(","));
                            System.out.println(tempStr.size()+ " con heo con");
                            list.add(new SinhVienToLopHoc(tempStr.get(1), strLop.get(0), strLop.get(1), Float.parseFloat(tempStr.get(3)),
                                    Float.parseFloat(tempStr.get(4)),Float.parseFloat(tempStr.get(5)),Float.parseFloat(tempStr.get(6))));
                        }

                        for (SinhVienToLopHoc element : list) {
                            SinhVienToLopHocDAO.capNhatDiemSinhVien(element);
                        }

                        txtClass.setText(lop);
                        btnSearch.doClick();

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        txtClass.setText("Your room");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO add your handling code here:
                String classID = txtClass.getText();
                lblClass.setText(classID);

                if (classID.contains("-") && classID.length() == 12) {
                    List<String> temp = Arrays.asList(classID.split("-"));

                    List<PackSinhVien> list = new ArrayList<>();
                    list = SinhVienToLopHocDAO.layDanhSachDiemSinhVienTheoLop(temp.get(0), temp.get(1));
                    if(list != null){
                        Vector data = new Vector();

                        for(int i = 1; i<= list.size(); i++){
                            PackSinhVien element = list.get(i - 1);
                            
                            Vector row = new Vector();
                            row.add(i+"");
                            row.add(element.getMSSV());
                            row.add(element.getName());
                            row.add(element.getDiemGK());
                            row.add(element.getDiemCK());
                            row.add(element.getDiemKhac());
                            row.add(element.getDiemTong());

                            data.add(row);
                        }

                        Vector header = new Vector();
                        header.add("No");
                        header.add("Student ID");
                        header.add("Name");
                        header.add("Middle scores");
                        header.add("Final scores");
                        header.add("Other Scores");
                        header.add("Conlusion");

                        jTable1.setModel(new DefaultTableModel(data, header));
                    } else {
                        lblClass.setText("No data for " + classID);
                    }
                } else {
                    txtClass.setText("Wrong format!");
                }

            }
        });

        lblClass.setText("17CTT1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Student ID", "Name", "Middel scores", "Final scores", "Other scores", "Conlusion"
            }
        ));
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        btnManage.setText("Manager");
        btnManage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(lblClass.getText().substring(0,5));
                JFrame frame = new CapNhatdiem(lblClass.getText().substring(0,5));
                frame.setSize(960,440);
                frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new UpdateDiem();
                frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                frame.setSize(756, 224);
                frame.setVisible(true);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnManage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnImport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblClass, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch))
                    .addComponent(btnImport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManage;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblClass;
    private javax.swing.JTextField txtClass;
    // End of variables declaration//GEN-END:variables
}
