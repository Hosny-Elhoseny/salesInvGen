
package com.SIG.Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
public class InvoiceHeader {
    private  SimpleDateFormat simpledateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private int invNum;
    private String custName;
    private Date invDate;
    private ArrayList<InvoiceLine> rows = new ArrayList<>();

    public InvoiceHeader() {
    }

    public InvoiceHeader(int invNum, String custName, Date invDate) {
        
        this.invNum = invNum;
        this.custName = custName;
        this.invDate = invDate;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
    public ArrayList<InvoiceLine> getRows() {
         if (rows == null) {
            rows = new ArrayList<>();
        }
        return rows;
    }

    public void setRows(ArrayList<InvoiceLine> rows) {
        this.rows = rows;
    }
    
    public double getInvTotal (){
        double total=0.0;
        for(int i=0;i<getRows().size();i++){
            total += getRows().get(i).getRowTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return  invNum + "," + simpledateFormat.format(invDate) +"," + custName;
    }
    
}
