/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SIG.View;

import javax.swing.JDialog;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *
 * @author DELL
 */
public class HeaderDia extends JDialog {
    private JTextField custNameTField;
    private JTextField invDateTField;
    private JLabel custNameLb;
    private JLabel invDateLb;
    private JButton ok_butt;
    private JButton cancel_butt;

    public HeaderDia(InvoiceForm form) {
        custNameLb = new JLabel("Customer Name:");
        custNameTField = new JTextField(20);
        invDateLb = new JLabel("Invoice Date:");
        invDateTField = new JTextField(20);
        ok_butt = new JButton("OK");
        cancel_butt = new JButton("Cancel");
        
        ok_butt.setActionCommand("NewInvOk");
        cancel_butt.setActionCommand("NewInvCancel");
        
        ok_butt.addActionListener(form.getActionLis());
        cancel_butt.addActionListener(form.getActionLis());
        setLayout(new GridLayout(3, 2));
        
        add(custNameLb);
        add(custNameTField);
        
        add(invDateLb);
        add(invDateTField);
        
        add(ok_butt);
        add(cancel_butt);
        
        pack();
        
    }

    public JTextField getInvDateField() {
        return invDateTField;
    }
      public JTextField getCustNameField() {
        return custNameTField;
    }
    
}

    

