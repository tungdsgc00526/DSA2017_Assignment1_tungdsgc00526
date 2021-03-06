/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tungds.jframe;

import com.tungds.commons.ManagerMenu;
import com.tungds.jforms.ProductFormEditor;
import com.tungds.models.Entity;
import com.tungds.models.Product;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author anhle
 */
public class ProductionPanelManager extends javax.swing.JPanel {

    public Entity entities;
    
    private String[] columns = new String [] {
                "Code", "Name", "Quantity", "Saled", "Price"
            };
    
//    private String[] columns = new String[]{}
    /**
     * Creates new form ProductionPanelManager
     */
    public ProductionPanelManager(Entity entities) {
        initComponents();
        this.entities = entities;
        loadDataToTable();
    }
    
    public void loadDataToTable(){
        
        if(entities.products.size() == 0)
            return;
        
        Object[][] arrData = new Object[entities.products.size()][columns.length];
        
        for(int i = 0 ;i < entities.products.size();i++){
            Product product = entities.products.get(i);
            arrData[i][0] = product.pcode;
            arrData[i][1] = product.pname;
            arrData[i][2] = product.quantity;
            arrData[i][3] = product.saled;
            arrData[i][4] = product.price;
        }
        
        jTable1.setModel(new DefaultTableModel(
            arrData,columns
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btSreachByCcode = new javax.swing.JButton();
        btSreachByCcode1 = new javax.swing.JButton();
        txtSreachByCcode = new javax.swing.JTextField();
        btSort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
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

        btSreachByCcode.setText("Sreach by Code");
        btSreachByCcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSreachByCcodeActionPerformed(evt);
            }
        });

        btSreachByCcode1.setText("Delete by Code");
        btSreachByCcode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSreachByCcode1ActionPerformed(evt);
            }
        });

        txtSreachByCcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSreachByCcodeActionPerformed(evt);
            }
        });

        btSort.setText("Sort by Code");
        btSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSortActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Quantity", "Saled", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Code");
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Name");
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Quantity");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Saled");
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Price");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSort)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSreachByCcode, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSreachByCcode, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSreachByCcode1)))
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEdit)
                    .addComponent(btAdd)
                    .addComponent(btSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSreachByCcode)
                        .addComponent(btSreachByCcode1))
                    .addComponent(txtSreachByCcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        ProductFormEditor editor = new ProductFormEditor(this);
        editor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editor.setVisible(true);
    }//GEN-LAST:event_btAddActionPerformed

    private void txtSreachByCcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSreachByCcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSreachByCcodeActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
//        System.out.println("vao day nao ahihihihi");
    }//GEN-LAST:event_formFocusLost

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
//        System.out.println(jTable1.getSelectionModel().);;
//jTable1.setSelec
        int index = jTable1.getSelectedRow();
        ProductFormEditor editor = new ProductFormEditor(this, entities.products.get(index));
        editor.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editor.setVisible(true);
    }//GEN-LAST:event_btEditActionPerformed

    private void btSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSortActionPerformed
        // TODO add your handling code here:
        ManagerMenu.quicksort(entities.products);
        loadDataToTable();
        JOptionPane.showMessageDialog(this,"success");
    }//GEN-LAST:event_btSortActionPerformed

    private void btSreachByCcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSreachByCcodeActionPerformed
        String code = txtSreachByCcode.getText();
        int result = ManagerMenu.binarysreach(entities.products, new Product(code));
         if(result != -1){
            jTable1.getSelectionModel().setSelectionInterval(0, result);
            JOptionPane.showMessageDialog(this,"success");
        }else{
            JOptionPane.showMessageDialog(this,"can't find production");
        }
    }//GEN-LAST:event_btSreachByCcodeActionPerformed

    private void btSreachByCcode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSreachByCcode1ActionPerformed
        // TODO add your handling code here:
        
        String code = txtSreachByCcode.getText();
        int result = ManagerMenu.binarysreach(entities.products, new Product(code));
        if(result != -1){
            entities.products.remove(result);
            JOptionPane.showMessageDialog(this,"success");
        }else{
            JOptionPane.showMessageDialog(this,"can't find production");
        }
    }//GEN-LAST:event_btSreachByCcode1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btSort;
    private javax.swing.JButton btSreachByCcode;
    private javax.swing.JButton btSreachByCcode1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtSreachByCcode;
    // End of variables declaration//GEN-END:variables
}
