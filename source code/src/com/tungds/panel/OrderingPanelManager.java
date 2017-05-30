/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungds.jframe;

import com.tungds.commons.ManagerMenu;
import com.tungds.jforms.OrderingFormEditor;
import com.tungds.models.Customer;
import com.tungds.models.Entity;
import com.tungds.models.Ordering;
import com.tungds.models.Product;
import javax.swing.JOptionPane;

/**
 *
 * @author anhle
 */
public class OrderingPanelManager extends javax.swing.JPanel {

    public Entity entities;
    
    private String[] columns = new String [] {
                "Product Code", "Customer Code", "Quantity"
            };
    /**
     * Creates new form OrderingPanelManager
     */
    public OrderingPanelManager(Entity entities) {
        initComponents();
        
        this.entities = entities;
        
        loadDataToTable();
    }
    
    public void loadDataToTable(){
        
        if(entities.orderings.size() == 0)
            return;
        
        Object[][] arrData = new Object[entities.orderings.size()][columns.length];
        
        for(int i = 0 ;i < entities.orderings.size();i++){

            Ordering order = entities.orderings.get(i);
            try {
                
//                Product product = ManagerMenu.getProductByCode(entities.products, order.pcode);
//                if(product != null)
                    arrData[i][0] = order.pcode;

//                Customer customer = ManagerMenu.getCustomerByCode(entities.customers, order.ccode);
//                if(customer != null) 
                    arrData[i][1] = order.ccode;

                arrData[i][2] = order.quantity;

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        
         jTable1.setModel(new javax.swing.table.DefaultTableModel(
            arrData,
            columns
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSortByCcode = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        btSortByCcode.setText("Sort by Customer Code and Product Code");
        btSortByCcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSortByCcodeActionPerformed(evt);
            }
        });

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btEdit.setText("Edit");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Product Code", "Customer Code", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSortByCcode, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEdit)
                    .addComponent(btAdd)
                    .addComponent(btSortByCcode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        OrderingFormEditor editor = new OrderingFormEditor(this);
        editor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editor.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void btSortByCcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSortByCcodeActionPerformed
        ManagerMenu.quicksort(entities.orderings);
        loadDataToTable();
        JOptionPane.showMessageDialog(this,"success");
    }//GEN-LAST:event_btSortByCcodeActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        OrderingFormEditor editor = new OrderingFormEditor(this, entities.orderings.get(index));
        editor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editor.setVisible(true);
    }//GEN-LAST:event_btEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btSortByCcode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
