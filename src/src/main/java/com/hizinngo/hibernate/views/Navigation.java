/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hizinngo.hibernate.views;

import com.hizinngo.hibernate.MainFrame;
import com.hizinngo.hibernate.entity.TaiKhoan;

import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author nghia
 */
public class Navigation extends javax.swing.JPanel {
    MainFrame frame;
    TaiKhoan userlogin;
    /**
     * Creates new form Navigation
     */
    public Navigation() {
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
        // seft
        setPreferredSize(new Dimension(300,768));
        frame = MainFrame.getInstance();
        userlogin = frame.getTaiKhoan();

        lblUser = new javax.swing.JLabel();
        btnNavi1 = new javax.swing.JButton();
        btnNavi2 = new javax.swing.JButton();
        btnNavi3 = new javax.swing.JButton();
        btnNavi4 = new javax.swing.JButton();
        btnNavi5 = new javax.swing.JButton();
        btnNavi6 = new javax.swing.JButton();

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Giao vu");

        btnNavi1.setText("Class");
        btnNavi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavi1ActionPerformed(evt);
            }
        });

        btnNavi2.setText("Schedule");
        btnNavi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavi2ActionPerformed(evt);
            }
        });

        btnNavi3.setText("Scores");
        btnNavi3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavi3ActionPerformed(evt);
            }
        });


        btnNavi4.setText("Re-examination");
        btnNavi4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavi4ActionPerformed(evt);
            }
        });

        btnNavi5.setText("Change password");
        btnNavi5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavi5ActionPerformed(evt);
            }
        });

        btnNavi6.setText("Log out");
        btnNavi6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavi6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNavi1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNavi2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNavi3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNavi4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNavi5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
            .addComponent(btnNavi6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNavi1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNavi2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNavi3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNavi4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNavi5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNavi6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        // set prio:
        lblUser.setText(userlogin.getTaikhoan());

        if(userlogin.getQuyen() == 2){
            btnNavi1.setEnabled(false);
            btnNavi2.setEnabled(false);
            btnNavi4.setEnabled(false);
        }

    }// </editor-fold>//GEN-END:initComponents

    private void btnNavi1ActionPerformed(java.awt.event.ActionEvent evt) {
        frame.updateTwoPanel(new Navigation(), new TraCuuDiemView());
        frame.setVisible(true);
    }

    private void btnNavi3ActionPerformed(java.awt.event.ActionEvent evt) {
        frame.updateTwoPanel(new Navigation(), new TraCuuDiemView());
        frame.setVisible(true);
    }

    private void btnNavi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavi2ActionPerformed
        // TODO add your handling code here:
        frame.updateTwoPanel(new Navigation(), new ThoiKhoaBieuView());
        frame.setVisible(true);
    }//GEN-LAST:event_btnNavi2ActionPerformed

    private void btnNavi5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavi5ActionPerformed
        // TODO add your handling code here:
        frame.updateTwoPanel(new Navigation(), new DoiMatKhauView());
        frame.setVisible(true);
    }//GEN-LAST:event_btnNavi5ActionPerformed

    private void btnNavi4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavi4ActionPerformed
        // TODO add your handling code here:
        frame.updateTwoPanel(new Navigation(), new QuanLyPhucKhaoView());
        frame.setVisible(true);
    }//GEN-LAST:event_btnNavi4ActionPerformed

    private void btnNavi6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavi6ActionPerformed
        // TODO add your handling code here:
        frame.setTaiKhoan(new TaiKhoan());
        frame.updateOnePanel(new MainLoginView());
        frame.setVisible(true);
    }//GEN-LAST:event_btnNavi6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNavi1;
    private javax.swing.JButton btnNavi2;
    private javax.swing.JButton btnNavi3;
    private javax.swing.JButton btnNavi4;
    private javax.swing.JButton btnNavi5;
    private javax.swing.JButton btnNavi6;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
