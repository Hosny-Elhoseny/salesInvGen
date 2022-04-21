/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SIG.Model;

import com.SIG.View.InvoiceForm;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author DELL
 */
public class InvoiceHeaderTModel extends AbstractTableModel {
private ArrayList<InvoiceHeader>invArr;
private String[] columnsArr = {"Invoice Num", "Invoice Date", "Customer Name", "Invoice Total"};
    public InvoiceHeaderTModel(ArrayList<InvoiceHeader> invArr) {
        this.invArr = invArr;
    }

    
        @Override
    public int getRowCount() {
         return invArr.size();
     
    }

    @Override
    public int getColumnCount() {
       return columnsArr.length;
                

    }

    @Override
    public Object getValueAt(int rowInd, int columnInd) {
InvoiceHeader inv = invArr.get(rowInd);
        switch (columnInd) {
            case 0:
            return inv.getInvNum();
            case 1:
             return InvoiceForm.simpledateFormat.format(inv.getInvDate());
            //return inv.getInvDate();
            case 2: 
            return inv.getCustName();
            case 3: 
                return inv.getInvTotal();
        }
        return "Du bist dumm!";
    }

    @Override
    public String getColumnName(int columnName) {
        //return columnsArr[column];
        switch(columnName){
            case 0 :
                return "Invoice Number";
            case 1 :
                return "Invoice Date";
            case 2 :
                return "Customer Name";
            case 3 :
                return "Total";
        }
        return "Du bist dumm!";
    }
    
}
