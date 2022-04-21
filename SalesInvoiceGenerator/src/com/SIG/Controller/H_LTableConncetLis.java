/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SIG.Controller;
import com.SIG.Model.InvoiceHeader;
import com.SIG.Model.InvoiceLine;
import com.SIG.Model.InvoiceLineTModel;
import com.SIG.View.InvoiceForm;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author DELL
 */
public class H_LTableConncetLis implements ListSelectionListener {
    private InvoiceForm form ;

    public H_LTableConncetLis(InvoiceForm form) {
        this.form = form;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        int selInvVar = form.getInvHeaderTable().getSelectedRow();
        System.out.println("com.SIG.Controller.H_LTableConncetLis.valueChanged()" + selInvVar );
        if (selInvVar != -1){ // 
        InvoiceHeader connectedInv = form.getInvArr().get(selInvVar);
        
        ArrayList<InvoiceLine> InvoiceLines = connectedInv.getRows();
        InvoiceLineTModel lineTModel = new InvoiceLineTModel(InvoiceLines);
        form.getInvLineTable().setModel(lineTModel);
        form.setInvoiceLines(InvoiceLines);/*may wronge*/
        form.getInvNumLbl().setText("" + connectedInv.getInvNum());
        form.getCustNameLbl().setText(connectedInv.getCustName());
        form.getInvDateLbl().setText(InvoiceForm.simpledateFormat.format(connectedInv.getInvDate()));
        form.getInvTotalLbl().setText("" + connectedInv.getInvTotal());
    }
    
}
}