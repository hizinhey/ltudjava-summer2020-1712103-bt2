/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hizinngo.hibernate.views;

import com.hizinngo.hibernate.dao.*;
import com.hizinngo.hibernate.entity.*;
import com.hizinngo.hibernate.entity.subclass.ThoiKhoaBieu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author nghia
 */
public class ThoiKhoaBieuView extends javax.swing.JPanel {

    /**
     * Creates new form ThoiKhoaBieu
     */
    public ThoiKhoaBieuView() {
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
        txtFindClass = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblClass = new javax.swing.JLabel();

        btnImport.setText("Import CSV");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        txtFindClass.setText("Your class ID");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Subject ID", "Title", "Room"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(40);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(300);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        lblClass.setText("17CTT1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblClass, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 936, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnImport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFindClass, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFindClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearch))
                    .addComponent(btnImport))
                .addGap(18, 18, 18)
                .addComponent(lblClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File csv = fileChooser.getSelectedFile().getAbsoluteFile();
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(csv));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String lop, temp;
            List<MonHoc> listMH = new ArrayList<>();
            List<LopToMonHoc> listLopToMonHoc = new ArrayList<>();

            List<String> tempStr = new ArrayList<>();

            try {
                lop = br.readLine();
                while ((temp = br.readLine()) != null) {
                    tempStr = Arrays.asList(temp.split(","));
                    listMH.add(new MonHoc(tempStr.get(1), tempStr.get(2)));
                    listLopToMonHoc.add(new LopToMonHoc(lop, tempStr.get(1), tempStr.get(3)));
                }

                LopDAO.themLop(new Lop(lop));

                for (MonHoc e : listMH) {
                    MonHocDAO.themMonHoc(e);
                }

                for (LopToMonHoc e : listLopToMonHoc) {
                    LopToMonHocDAO.themLopToMonHoc(e);
                }

                List<SinhVien> listSV = SinhVienDAO.layDanhSachSinhVienTheoLop(lop);
                for (SinhVien eSV : listSV) {
                    for (MonHoc eMH : listMH) {
                        SinhVienToLopHocDAO.themSinhVienToLopHoc(new SinhVienToLopHoc(eSV.getMSSV(), lop, eMH.getMaMH(), 0f, 0f, 0f, 0f));
                    }
                }
                txtFindClass.setText(lop);
                btnSearch.doClick();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String classID = txtFindClass.getText();
        lblClass.setText(classID);

        if (classID.length() == 5) {
            List<ThoiKhoaBieu> list = new ArrayList<>();
            list = LopToMonHocDAO.layThoiKhoaBieuTheoLop(classID);
            if(list != null){
                Vector data = new Vector();

                for(int i = 1; i<= list.size(); i++){
                    ThoiKhoaBieu element = list.get(i - 1);
                    Vector row = new Vector();
                    row.add(i+"");
                    row.add(element.getMaMH());
                    row.add(element.getTenMH());
                    row.add(element.getPhong());

                    data.add(row);
                }

                Vector header = new Vector();
                header.add("No");
                header.add("Student ID");
                header.add("Title");
                header.add("Room");

                jTable1.setModel(new DefaultTableModel(data, header));
            } else {
                lblClass.setText("No data for " + classID);
            }
        } else {
            txtFindClass.setText("Wrong format!");
        }

    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField txtFindClass;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblClass;
    // End of variables declaration//GEN-END:variables
}
