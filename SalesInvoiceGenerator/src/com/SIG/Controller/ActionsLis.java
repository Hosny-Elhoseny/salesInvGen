package com.SIG.Controller;

import com.SIG.Model.InvoiceHeader;
import com.SIG.Model.InvoiceHeaderTModel;
import com.SIG.View.InvoiceForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import com.SIG.Model.InvoiceLine;
import com.SIG.Model.InvoiceLineTModel;
import com.SIG.View.HeaderDia;
import com.SIG.View.LineDia;
import java.io.FileWriter;

public class ActionsLis implements ActionListener {
    private HeaderDia headerDialog;
    private InvoiceForm form;
    private LineDia lineDialog;
    public ActionsLis(InvoiceForm form){
        this.form = form;
    }

    public void actionPerformed(ActionEvent ae) {
       switch (ae.getActionCommand()){
           case "Load File":
               loadFile();
               break;
           case "Save File":
               saveFile();
               break;
           case "Creat New Invoice":
               creatNewInvoice();
               break;
           case "Delete Invoice"  :
                deleteInvoice();
               break;
            case "New Line":
                newLine();
                break;
            case "Delete Line":
                deleteLine();
                break;
            case "NewInvOk":
                okNewInvDia();
                break;
            case "NewInvCancel":
                cancelNewInvDia();
                break;
            case "neuLineOK":
                okNeuLine();
                break;
            case "neuLineCancel":
                cancelNeuLine();
                break;
       }
    }

    private void loadFile() {
        JOptionPane.showMessageDialog(form, "Please, select a header file", "Attension", JOptionPane.WARNING_MESSAGE);
        JFileChooser filechooser = new JFileChooser();
        try {
       int returned = filechooser.showOpenDialog(form);
        if (returned == JFileChooser.APPROVE_OPTION ){
          File headerFile =  filechooser.getSelectedFile();
          Path headerPath = Paths.get(headerFile.getAbsolutePath());
          List<String> headerLines = Files.readAllLines(headerPath);
          ArrayList<InvoiceHeader> invoiceHeaders = new ArrayList<>();
          for(String hLine : headerLines){
             String [] cut = hLine.split(",");
             String lineCount = cut[0];
             String lineDate = cut[1];
             String lineName = cut[2];
             int intLineCount = Integer.parseInt(lineCount);
             Date InvoiceTime = InvoiceForm.simpledateFormat.parse(lineDate);
              InvoiceHeader header = new InvoiceHeader(intLineCount, lineName, InvoiceTime);
              invoiceHeaders.add(header);
            
          }
          form.setInvArr(invoiceHeaders);
          JOptionPane.showMessageDialog(form, "Please, select a line file", "Attension", JOptionPane.WARNING_MESSAGE);
          returned = filechooser.showOpenDialog(form);
        if (returned == JFileChooser.APPROVE_OPTION ){
          File lineFile =  filechooser.getSelectedFile();
          Path linePath = Paths.get(lineFile.getAbsolutePath());
          List<String> lineLines = Files.readAllLines(linePath);
          ArrayList<InvoiceLine> invoiceLines = new ArrayList<>();
          for(String lLine : lineLines){
             String [] cut = lLine.split(",");
               String lineCount = cut[0];
             String lineName = cut[1];
             String linePrice = cut[2];
             String lineQuantity = cut[3];
             int intLineCount = Integer.parseInt(lineCount);
             double itemPrice = Double.parseDouble(linePrice);
             int quantity =  Integer.parseInt(lineQuantity);
             InvoiceHeader inv = form.getInvObject(intLineCount);
             InvoiceLine line = new InvoiceLine(quantity, lineName, itemPrice, inv);
             inv.getRows().add(line);
        }
        }
             InvoiceHeaderTModel headerTModel = new InvoiceHeaderTModel(invoiceHeaders);
             form.setHeaderTModel(headerTModel);
             form.getInvHeaderTable().setModel(headerTModel);
        }
        }
         catch (IOException e){
            JOptionPane.showMessageDialog(form, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e){
             JOptionPane.showMessageDialog(form, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
    ArrayList<InvoiceHeader> saveArr = form.getInvArr();
    JOptionPane.showMessageDialog(form, "you are going to save a header file now ", "Attension", JOptionPane.WARNING_MESSAGE);
    JFileChooser file = new JFileChooser();
    try{
    int returned =file.showSaveDialog(form);
    if (returned==JFileChooser.APPROVE_OPTION){
        File Hf = file.getSelectedFile();
        FileWriter hFr = new FileWriter(Hf);
        String lFiles ="";
        String hFiles ="";
        for(InvoiceHeader hInv : saveArr){
            hFiles += hInv.toString();
            hFiles += "\n";
            for (InvoiceLine lInv : hInv.getRows()){
                lFiles += lInv.toString();
            lFiles += "\n";
            }
        }
        JOptionPane.showMessageDialog(form, "you are going to save a line file now ", "Attension", JOptionPane.WARNING_MESSAGE);
        returned =file.showSaveDialog(form);
        File Lf = file.getSelectedFile();
        FileWriter lFr = new FileWriter(Lf);
        hFr.write(hFiles);
        hFr.close();
        lFr.write(lFiles);
        lFr.close();
        
    }
    }catch(IOException e){
            JOptionPane.showMessageDialog(form, e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }
    JOptionPane.showMessageDialog(form, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void creatNewInvoice() {
      headerDialog = new HeaderDia(form);
        headerDialog.setVisible(true);

    }

    private void deleteInvoice() {
        int choosenInvInd = form.getInvHeaderTable().getSelectedRow();
       
        form.getInvArr().remove(choosenInvInd);
        form.getHeaderTModel().fireTableDataChanged();
        form.getInvLineTable().setModel( new InvoiceLineTModel( new ArrayList<InvoiceLine>())); // from a friend
        form.getInvNumLbl().setText("");
        form.getCustNameLbl().setText("");
        form.getInvDateLbl().setText("");
        form.getInvTotalLbl().setText("");
    }

    private void newLine() {
   lineDialog = new LineDia(form);
   lineDialog.setVisible(true);
    }

    private void deleteLine() {

        int choosenInv = form.getInvLineTable().getSelectedRow();
       if(choosenInv != -1){
        form.getInvoiceLines().remove(choosenInv);
        InvoiceLineTModel tModel = (InvoiceLineTModel) form.getInvLineTable().getModel();
            tModel.fireTableDataChanged();
            form.getInvTotalLbl().setText( "" + form.getInvArr().get(form.getInvHeaderTable().getSelectedRow()).getInvTotal());
     form.getHeaderTModel().fireTableDataChanged();
     
    
       form.getInvHeaderTable().setRowSelectionInterval(choosenInv, choosenInv);
    }}
    private void okNewInvDia() {
    headerDialog.setVisible(true);
    String custName = headerDialog.getCustNameField().getText();
        String strDate = headerDialog.getInvDateField().getText();
        Date intd = new Date();
        try {
    intd = InvoiceForm.simpledateFormat.parse(strDate);
    } catch (ParseException e) {
            JOptionPane.showMessageDialog(form,"صباح الفل! ! الفورمات غلط يا حج", "بتكتب ايه يا عم الله يباركلك!!", JOptionPane.ERROR_MESSAGE);
        }

        int invVar=0;
        for(InvoiceHeader header : form.getInvArr()){
        if(header.getInvNum()>invVar)
            invVar=header.getInvNum();
        }
        invVar++;
        InvoiceHeader newHeader = new InvoiceHeader(invVar, custName, intd);
        form.getInvArr().add(newHeader);
        form.getHeaderTModel().fireTableDataChanged();
    headerDialog.dispose();
    headerDialog = null;
}
    private void cancelNewInvDia() {
    headerDialog.setVisible(false);
    headerDialog.dispose();
    headerDialog = null;
}
    private void okNeuLine(){
        lineDialog.setVisible(true);
        String itemName = lineDialog.getItemNameField().getText();
        String itemCount = lineDialog.getItemCountField().getText();
        String itemPrice = lineDialog.getItemPriceField().getText();
         int count =0;
        try{
        count = Integer.parseInt(itemCount);
       } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(form, "دخل رقم صح يا صاحبى!", "بقولك....", JOptionPane.ERROR_MESSAGE);
        }
        double price=0 ;
        try {
       
        price = Double.parseDouble(itemPrice);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(form, "عملة جديدة دى ولا ايه!", "متهزرش بقى!!", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(form, "هحطهالك فى الجدول جدعنة منى", "عد الجمايل!!", JOptionPane.ERROR_MESSAGE);
        }
      int choosenInv = form.getInvHeaderTable().getSelectedRow();
       if (choosenInv != -1) {
      InvoiceHeader invH = form.getInvArr().get(choosenInv);
      InvoiceLine invL = new InvoiceLine(count, itemName, price, invH);
      InvoiceLineTModel tModel = (InvoiceLineTModel) form.getInvLineTable().getModel();
            tModel.fireTableDataChanged();
      form.getInvoiceLines().add(invL);
     form.getHeaderTModel().fireTableDataChanged();
       form.getInvHeaderTable().setRowSelectionInterval(choosenInv, choosenInv);
       }
        lineDialog.dispose();
         lineDialog = null;
    }
    private void cancelNeuLine(){
        lineDialog.setVisible(false);
    lineDialog.dispose();
    lineDialog = null;
    }
    
}