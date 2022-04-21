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
public class InvoiceLineTModel extends AbstractTableModel {
private ArrayList<InvoiceLine> InvoiceLines;
private String[] columnsArr = {"Item Name", "Item Price", "Count", "Total"};


    public InvoiceLineTModel(ArrayList<InvoiceLine> InvoiceLines) {
        this.InvoiceLines = InvoiceLines;
    }

    @Override
    public int getRowCount() {
        return InvoiceLines.size();
        
    }

    @Override
    public int getColumnCount() {
       return columnsArr.length;
        
    }

    @Override
    public Object getValueAt(int rowInd, int columnInd) {
        InvoiceLine inv = InvoiceLines.get(rowInd);
         switch (columnInd) {
            case 0:
            return inv.getItem();
            case 1:
             return inv.getPrice();
            case 2: 
            return inv.getCount();
            case 3:
            return inv.getRowTotal();
        }
        return "Du bist dumm!";
     
    }

    @Override
    public String getColumnName(int columnName) {
      //  return columnsArr[columnName];
         switch(columnName){
            case 0:
                return "Item Name";
            case 1:
                return "Item Price";
            case 2:
                return "Count";
            case 3:
                return "Total";
        }
        return "Du bist dumm!";
    }
    
    
}
