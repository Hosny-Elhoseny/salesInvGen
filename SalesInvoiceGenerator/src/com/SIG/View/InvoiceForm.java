/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SIG.View;

import com.SIG.Controller.ActionsLis;
import com.SIG.Controller.H_LTableConncetLis;
import com.SIG.Model.InvoiceHeader;
import com.SIG.Model.InvoiceHeaderTModel;
import com.SIG.Model.InvoiceLine;
import com.SIG.Model.InvoiceLineTModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author DELL
 */
public class InvoiceForm extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceForm
     */
    public InvoiceForm() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        invHeaderTable = new javax.swing.JTable();
        createInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        invNumButton = new javax.swing.JLabel();
        invDateButton = new javax.swing.JLabel();
        cusNameButton = new javax.swing.JLabel();
        invTotalButton = new javax.swing.JLabel();
        invNumLbl = new javax.swing.JLabel();
        invDateLbl = new javax.swing.JLabel();
        custNameLbl = new javax.swing.JLabel();
        invTotalLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        invLineTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        newLineButton = new javax.swing.JButton();
        deleteLineButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileBar = new javax.swing.JMenu();
        loadFileBar = new javax.swing.JMenuItem();
        saveFileBar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        invHeaderTable.getSelectionModel().addListSelectionListener(connectListener);
        jScrollPane1.setViewportView(invHeaderTable);

        createInvoiceButton.setText("Creat New Invoice");
        createInvoiceButton.setToolTipText("");
        createInvoiceButton.addActionListener(actionLis);

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.setToolTipText("");
        deleteInvoiceButton.addActionListener(actionLis);
        deleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoices Table");
        jLabel1.setToolTipText("");

        invNumButton.setText("Invoice Number");
        invNumButton.setToolTipText("");

        invDateButton.setText("Invoice Date");

        cusNameButton.setText("Customer Name");

        invTotalButton.setText("Invoice Total");

        invLineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(invLineTable);

        jLabel10.setText("Invoice Items");

        newLineButton.setText("New Line");
        newLineButton.addActionListener(actionLis);
        newLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newLineButtonActionPerformed(evt);
            }
        });

        deleteLineButton.setText("Delete Line");
        deleteLineButton.addActionListener(actionLis);
        deleteLineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineButtonActionPerformed(evt);
            }
        });

        fileBar.setText("File");

        loadFileBar.setText("Load File");
        loadFileBar.setToolTipText("");
        loadFileBar.addActionListener(actionLis);
        loadFileBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileBarActionPerformed(evt);
            }
        });
        fileBar.add(loadFileBar);

        saveFileBar.setText("Save File");
        saveFileBar.addActionListener(actionLis);
        fileBar.add(saveFileBar);

        jMenuBar1.add(fileBar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(createInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(deleteInvoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
                        .addComponent(newLineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(deleteLineButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invNumButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cusNameButton)
                                    .addComponent(invTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(invDateLbl)
                                    .addComponent(invNumLbl)
                                    .addComponent(custNameLbl)
                                    .addComponent(invTotalLbl)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))))
                .addContainerGap(163, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invNumButton)
                            .addComponent(invNumLbl))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(invDateLbl)
                            .addComponent(invDateButton))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cusNameButton)
                            .addComponent(custNameLbl))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invTotalButton)
                            .addComponent(invTotalLbl))
                        .addGap(37, 37, 37)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(newLineButton)
                    .addComponent(deleteLineButton))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInvoiceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteInvoiceButtonActionPerformed

    private void deleteLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteLineButtonActionPerformed

    private void loadFileBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loadFileBarActionPerformed

    private void newLineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newLineButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newLineButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoiceForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JLabel cusNameButton;
    private javax.swing.JLabel custNameLbl;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JMenu fileBar;
    private javax.swing.JLabel invDateButton;
    private javax.swing.JLabel invDateLbl;
    private javax.swing.JTable invHeaderTable;
    private javax.swing.JTable invLineTable;
    private javax.swing.JLabel invNumButton;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotalButton;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadFileBar;
    private javax.swing.JButton newLineButton;
    private javax.swing.JMenuItem saveFileBar;
    // End of variables declaration//GEN-END:variables
     public static SimpleDateFormat simpledateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private ActionsLis actionLis = new ActionsLis(this) ;
    private H_LTableConncetLis connectListener = new H_LTableConncetLis(this);
    
     private ArrayList<InvoiceHeader> invArr;
     private ArrayList<InvoiceLine> invoiceLines;
     private InvoiceHeaderTModel headerTModel;

    public ArrayList<InvoiceHeader> getInvArr() {
        return invArr;
    }
    
     private InvoiceLineTModel LineTModel;
    public void setInvArr(ArrayList<InvoiceHeader> invArr) {
        this.invArr = invArr;
    }

    public void setInvoiceLines(ArrayList<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }
    
    
     public InvoiceHeader getInvObject (int intLineCount){
         for (InvoiceHeader inv : invArr) { /**/
            if (inv.getInvNum()== intLineCount) {
                return inv;
            }
     } return null;
     }
     public InvoiceLine  getInvoiceLine(int i){
         for (InvoiceLine inv : invoiceLines) {/**/
            if (inv.getCount()== i) {
                return inv;
            }
     } return null;
}

    public JTable getInvHeaderTable() {
        return invHeaderTable;
    }

    public JTable getInvLineTable() {
        return invLineTable;
    }

    public JLabel getCustNameLbl() {
        return custNameLbl;
    }

    public ActionsLis getActionLis() {
        return actionLis;
    }
    

    public JLabel getInvDateLbl() {
        return invDateLbl;
    }

    public JLabel getInvNumLbl() {
        return invNumLbl;
    }

    public JLabel getInvTotalLbl() {
        return invTotalLbl;
    }
     

    public InvoiceHeaderTModel getHeaderTModel() {
        return headerTModel;
    }

    public void setHeaderTModel(InvoiceHeaderTModel headerTModel) {
        this.headerTModel = headerTModel;
    }

    public InvoiceLineTModel getLineTModel() {
        return LineTModel;
    }

    public void setLineTModel(InvoiceLineTModel LineTModel) {
        this.LineTModel = LineTModel;
    }
    
     
}
   

