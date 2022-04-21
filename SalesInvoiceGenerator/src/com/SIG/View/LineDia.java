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
public class LineDia extends JDialog{
     private JTextField itemNameTField;
    private JTextField itemCountTField;
    private JTextField itemPriceTField;
    private JLabel itemNameLb;
    private JLabel itemCountLb;
    private JLabel itemPriceLb;
    private JButton ok_butt;
    private JButton cancel_butt;
    
    public LineDia(InvoiceForm form) {
        itemNameTField = new JTextField(20);
        itemNameLb = new JLabel("Item Name");
        
        itemCountTField = new JTextField(20);
        itemCountLb = new JLabel("Item Count");
        
        itemPriceTField = new JTextField(20);
        itemPriceLb = new JLabel("Item Price");
        
        ok_butt = new JButton("OK");
        cancel_butt = new JButton("Cancel");
        
        ok_butt.setActionCommand("neuLineOK");
        cancel_butt.setActionCommand("neuLineCancel");
        
        ok_butt.addActionListener(form.getActionLis());
        cancel_butt.addActionListener(form.getActionLis());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLb);
        add(itemNameTField);
        add(itemCountLb);
        add(itemCountTField);
        add(itemPriceLb);
        add(itemPriceTField);
        add(ok_butt);
        add(cancel_butt);
        
        pack();
    }

    public JTextField getItemNameField() {
        return itemNameTField;
    }

    public JTextField getItemCountField() {
        return itemCountTField;
    }

    public JTextField getItemPriceField() {
        return itemPriceTField;
    }
}

