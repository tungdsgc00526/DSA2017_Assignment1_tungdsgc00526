/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungds.jforms;

import com.tungds.commons.FileMenu;
import com.tungds.commons.ManagerMenu;
import com.tungds.models.Customer;
import com.tungds.models.Entity;
import com.tungds.models.Ordering;
import com.tungds.models.Product;
import com.tungds.jframe.CustomerPanelManager;
import com.tungds.jframe.OrderingPanelManager;
import com.tungds.jframe.ProductionPanelManager;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author TungDS
 */
public class MainMenu extends javax.swing.JFrame {

    private Entity entities;

    private JPanel lastPanelAdded;

    /**
     * Creates new form App
     */
    public MainMenu() {

        initComponents();

        entities = new Entity();
        entities.customers = new ArrayList<Customer>();
        entities.orderings = new ArrayList<Ordering>();
        entities.products = new ArrayList<Product>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        btnSaveData = new javax.swing.JMenuItem();
        btnLoadData = new javax.swing.JMenuItem();
        jMenuManager = new javax.swing.JMenu();
        btnProductions = new javax.swing.JMenuItem();
        btnCustomers = new javax.swing.JMenuItem();
        btnbtnOrderings = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("File");
        jMenuBar3.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar3.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuFile.setText("File");

        btnSaveData.setText("Save Data");
        btnSaveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataActionPerformed(evt);
            }
        });
        jMenuFile.add(btnSaveData);

        btnLoadData.setText("Load Data");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });
        jMenuFile.add(btnLoadData);

        jMenuBar1.add(jMenuFile);

        jMenuManager.setText("Manager");

        btnProductions.setText("Productions");
        btnProductions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductionsActionPerformed(evt);
            }
        });
        jMenuManager.add(btnProductions);

        btnCustomers.setText("Customer");
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        jMenuManager.add(btnCustomers);

        btnbtnOrderings.setText("Orderings");
        btnbtnOrderings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbtnOrderingsActionPerformed(evt);
            }
        });
        jMenuManager.add(btnbtnOrderings);

        jMenuBar1.add(jMenuManager);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSaveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                FileMenu.SaveData(fileToSave.getAbsolutePath(), entities);
            } catch (IOException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Success");
        }
    }//GEN-LAST:event_btnSaveDataActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                entities = FileMenu.LoadData(selectedFile.getAbsolutePath());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (entities.customers == null) {
                entities.customers = new ArrayList<Customer>();
            } else {
                ManagerMenu.shuffleArray(entities.customers);
            }

            if (entities.orderings == null) {
                entities.orderings = new ArrayList<Ordering>();
            } else {
                ManagerMenu.shuffleArray(entities.orderings);
            }

            if (entities.products == null) {
                entities.products = new ArrayList<Product>();

            } else {
                ManagerMenu.shuffleArray(entities.products);
//                  entities.products = new ArrayList<Product>(entities.products.subList(0, 2));
            }

            JOptionPane.showMessageDialog(this, "Success");
        }
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnProductionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductionsActionPerformed
        addNewPanel(new ProductionPanelManager(entities));
    }//GEN-LAST:event_btnProductionsActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        addNewPanel(new CustomerPanelManager(entities));
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnbtnOrderingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbtnOrderingsActionPerformed

        if (entities.customers.size() == 0 || entities.products.size() == 0) {
            JOptionPane.showMessageDialog(this, "product or customer is empty");
            return;
        }
        addNewPanel(new OrderingPanelManager(entities));
    }//GEN-LAST:event_btnbtnOrderingsActionPerformed

    private void addNewPanel(JPanel panelManager) {

        if (lastPanelAdded != null) {
            remove(lastPanelAdded);
        }

        setLayout(new BorderLayout());
        add(panelManager);
        pack();

        lastPanelAdded = panelManager;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCustomers;
    private javax.swing.JMenuItem btnLoadData;
    private javax.swing.JMenuItem btnProductions;
    private javax.swing.JMenuItem btnSaveData;
    private javax.swing.JMenuItem btnbtnOrderings;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuManager;
    // End of variables declaration//GEN-END:variables
}
