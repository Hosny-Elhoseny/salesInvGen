package com.SIG.Model;


public class InvoiceLine {
    private int count;
    private String item;
    private double price;
    private InvoiceHeader header;

    public InvoiceLine() {
    }

    public InvoiceLine(int count, String item, double price, InvoiceHeader header) {
        this.count = count;
        this.item = item;
        this.price = price;
        this.header = header;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public double getRowTotal(){
        return price * count;
    }

    @Override
    public String toString() {
        return header.getInvNum()+","+ item +","+price+","+count;
    }
    
}

