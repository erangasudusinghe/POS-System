/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class Sale extends javax.swing.JPanel {

    /**
     * Creates new form Invoice
     */
    String CusName =null;
    String CusID = null;
    String Status=null;
    public static String barcode;
    public String totalQuntity;
    public Sale() {
        initComponents();
        dataload();
        Color white = new Color(255,255,255);
        InvoiceTable.setBackground(white);
        InvoiceTable.setGridColor(white);
        InvoiceTable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,20));
        InvoiceTable.getTableHeader().setOpaque(false);
        InvoiceTable.getTableHeader().setReorderingAllowed(false);
        InvoiceTable.getTableHeader().setBackground(white);
        InvoiceTable.getTableHeader().setForeground(new Color(0,0,0));
        InvoiceTable.setRowHeight(40);
        InvoiceIDload();
        Discount.setText("0.0");
        
    }
   
    public void dataload() {
            try{
            Statement statment= (Statement)DBConnector.DBCon().createStatement();
            ResultSet results =statment.executeQuery("Select * from customer");
            Vector vector = new Vector();
            vector.add("Select");
            while(results.next()){
                vector.add(results.getString("CusName"));
                DefaultComboBoxModel combo = new DefaultComboBoxModel(vector);
                CusList.setModel(combo);
            }
            
            }
            catch(Exception e){
                System.out.println("Erro "+e);
            }
            
            try{
            Statement statment= (Statement)DBConnector.DBCon().createStatement();
            ResultSet results =statment.executeQuery("Select * from products");
            Vector vector = new Vector();
            vector.add("Select");
            while(results.next()){
                vector.add(results.getString("ProductName"));
                DefaultComboBoxModel combo = new DefaultComboBoxModel(vector);
                ProList.setModel(combo);
            }
            
            }
            catch(Exception e){
                System.out.println("Erro "+e);
            }
    }
    public void RemoveAll(){
        try{
            DefaultTableModel table =(DefaultTableModel) InvoiceTable.getModel();
            table.setRowCount(0);
            Netcount();
            PaidAmount.setText(null);
            Quntity.setText(null);
            Price.setText("000.00");
            Total.setText("000.00");
            Balance.setText(null);
        }
        catch(Exception e) {
             System.out.println("Erro "+e);
        }
    }
    public Double discount(){
        Double value=0.0;
        if(isNumeric(Discount.getText())){
            Double discount=Double.parseDouble(Discount.getText());
            Double total=Double.parseDouble(totalAmount.getText());
            value= discount*total/100; 
            return value;
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid Input");
            return value;
        }
    }
    public Double TotalPrice(){
            Double qun = Double.valueOf(Quntity.getText());
            Double price = Double.valueOf(Price.getText());
            Double Total=qun*price;
            return Total;
    }
    public void Netcount(){
        int countOfrow= InvoiceTable.getRowCount();
        double total = 0;
        for(int i=0;i<countOfrow;i++){
            double value= Double.valueOf(InvoiceTable.getValueAt(i, 5).toString());
            total+=value;
        } 
        totalAmount.setText(Double.toString(total));
        
        int numberOfrow= InvoiceTable.getRowCount();
        double totalQ = 0;
        for(int i=0;i<numberOfrow;i++){
            double value= Double.valueOf(InvoiceTable.getValueAt(i, 3).toString());
            totalQ+=value;
        } 
        totalQuntity =Double.toString(totalQ);
    }
    public void balance(){
        Double total=Double.parseDouble(totalAmount.getText());
        Double Paid=Double.parseDouble(PaidAmount.getText());
        Double balance=Paid-total;
        Double dis =discount();
        Balance.setText(Double.toString(balance+dis));
    }
    public void InvoiceIDload(){
        try{
            Statement statement = (Statement)DBConnector.DBCon().createStatement();
            ResultSet result =statement.executeQuery("Select * from cart");
            String InID = null;
            while(result.next()){
                InID=result.getString("InvoiceID");
            }
            int id=Integer.valueOf(InID);
            id=id+1;
            InvoiceID.setText(Integer.toString(id));
        }
        catch(Exception ex){
            System.out.println("Erro "+ex);
        }
    }
    public static boolean isNumeric(String Str){
        return Str.matches("-?\\d+(\\.\\d+)?");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        InvoiceID = new javax.swing.JLabel();
        CusList = new javax.swing.JComboBox<>();
        ProList = new javax.swing.JComboBox<>();
        Price = new javax.swing.JLabel();
        Quntity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        AddCart = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        RemoveAll = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        PaidAmount = new javax.swing.JTextField();
        totalAmount = new javax.swing.JTextField();
        Discount = new javax.swing.JTextField();
        Balance = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Invoice Number");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Customer");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Product");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quntity");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Unit Price");

        InvoiceID.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        InvoiceID.setForeground(new java.awt.Color(255, 255, 255));
        InvoiceID.setText("0000");

        CusList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CusList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        CusList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusListActionPerformed(evt);
            }
        });

        ProList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ProList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ProList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProListActionPerformed(evt);
            }
        });

        Price.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Price.setForeground(new java.awt.Color(255, 255, 255));
        Price.setText("000.00");

        Quntity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Quntity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuntityActionPerformed(evt);
            }
        });
        Quntity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                QuntityKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RS.");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total Price");

        Total.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Total.setForeground(new java.awt.Color(255, 255, 255));
        Total.setText("000.00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("RS.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(InvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CusList, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(ProList, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Quntity, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Price))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Price, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addComponent(Total, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addComponent(ProList)
                    .addComponent(CusList)
                    .addComponent(Quntity))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        InvoiceTable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        InvoiceTable.setForeground(new java.awt.Color(0, 153, 153));
        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Name", "BarCode", "Quntity", "Unit Price", "Total"
            }
        ));
        InvoiceTable.setFocusable(false);
        InvoiceTable.setGridColor(new java.awt.Color(255, 255, 255));
        InvoiceTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        InvoiceTable.setRowHeight(25);
        InvoiceTable.setShowVerticalLines(false);
        InvoiceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(InvoiceTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setFocusable(false);

        AddCart.setBackground(new java.awt.Color(0, 0, 0));
        AddCart.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        AddCart.setForeground(new java.awt.Color(255, 255, 255));
        AddCart.setText("Add To Cart");
        AddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCartActionPerformed(evt);
            }
        });

        Remove.setBackground(new java.awt.Color(0, 0, 0));
        Remove.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Remove.setForeground(new java.awt.Color(255, 255, 255));
        Remove.setText("Remove");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        RemoveAll.setBackground(new java.awt.Color(0, 0, 0));
        RemoveAll.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        RemoveAll.setForeground(new java.awt.Color(255, 255, 255));
        RemoveAll.setText("Remove All");
        RemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(RemoveAll, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(Remove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AddCart, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddCart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(RemoveAll, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Paid Amount");

        PaidAmount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        PaidAmount.setForeground(new java.awt.Color(0, 153, 153));
        PaidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PaidAmountKeyReleased(evt);
            }
        });

        totalAmount.setEditable(false);
        totalAmount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalAmount.setForeground(new java.awt.Color(0, 153, 153));

        Discount.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Discount.setForeground(new java.awt.Color(0, 153, 153));
        Discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DiscountKeyReleased(evt);
            }
        });

        Balance.setEditable(false);
        Balance.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Balance.setForeground(new java.awt.Color(0, 153, 153));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Balance :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Discount :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Amount :");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Pay & Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(PaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Discount))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Balance)))
                .addGap(88, 88, 88)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(totalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Discount)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Balance, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(PaidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCartActionPerformed
      if(!Quntity.getText().isEmpty()&&!(CusList.getSelectedItem().toString()).equals("Select")&&!(ProList.getSelectedItem().toString()).equals("Select")){
            if(isNumeric(Quntity.getText())){
                DefaultTableModel table =(DefaultTableModel) InvoiceTable.getModel();
                Vector v1 =new Vector();
                v1.add(InvoiceID.getText());
                v1.add(CusList.getSelectedItem());
                v1.add(barcode);
                v1.add(Quntity.getText());
                v1.add(Price.getText());
                v1.add(TotalPrice());
                table.addRow(v1);
                Netcount();
            }
            else{
            JOptionPane.showMessageDialog(null, "Invalid Input in Quntity Field");
            Quntity.setText(null);
            Total.setText("000.00");
        }
     }
     else{
            JOptionPane.showMessageDialog(null, "No Input in Some Field"); 
            Quntity.setText(null);
            Price.setText("000.00");
            Total.setText("000.00");
        }      
    }//GEN-LAST:event_AddCartActionPerformed

    private void QuntityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuntityActionPerformed
        
    }//GEN-LAST:event_QuntityActionPerformed

    private void ProListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProListActionPerformed
        String Proname= ProList.getSelectedItem().toString();
        try{
            Statement statment= (Statement)DBConnector.DBCon().createStatement();
            ResultSet results =statment.executeQuery("Select Price,BarCode from products where ProductName='"+Proname+"'");
            if(results.next()){
                Price.setText(results.getString("Price"));
                barcode=results.getString("BarCode");

            }
        }
        catch(Exception e){
            System.out.println("Erro "+e);
        }
    }//GEN-LAST:event_ProListActionPerformed

    private void CusListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusListActionPerformed
        String Cusname= CusList.getSelectedItem().toString();
        try{
            Statement statment= (Statement)DBConnector.DBCon().createStatement();
            ResultSet results =statment.executeQuery("Select * from customer where CusName='"+Cusname+"'");
            if(results.next()){
                CusName=results.getString("CusName");
                CusID=results.getString("CusID");
            }
        }
        catch(Exception e){
            System.out.println("Erro "+e);
        }
    }//GEN-LAST:event_CusListActionPerformed

    private void QuntityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QuntityKeyReleased
         if(!Quntity.getText().isEmpty()){
            if(isNumeric(Quntity.getText())){
               Total.setText(TotalPrice().toString());
            }
            else{
               Total.setText("000.00");
            }
            
        }
        else{
               Total.setText("000.00");
            }
    }//GEN-LAST:event_QuntityKeyReleased

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        try{
            DefaultTableModel table =(DefaultTableModel) InvoiceTable.getModel();
            int row= InvoiceTable.getSelectedRow();
            //String ID= table.getValueAt(row, 0).toString();
            table.removeRow(row);
            Netcount();
            balance();
        }
        catch(Exception e) {
             System.out.println("Erro "+e);
        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void RemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveAllActionPerformed
        RemoveAll();
    }//GEN-LAST:event_RemoveAllActionPerformed

    private void PaidAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PaidAmountKeyReleased
        if(PaidAmount.getText().isEmpty()){
            Balance.setText("Cancelled");
        }
        else{
             balance();
        }
    }//GEN-LAST:event_PaidAmountKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!PaidAmount.getText().isEmpty()&&isNumeric(PaidAmount.getText())&&!totalAmount.getText().isEmpty()){
        try {
            Statement statement = (Statement)DBConnector.DBCon().createStatement();
            DefaultTableModel table =(DefaultTableModel) InvoiceTable.getModel();
            int rows=table.getRowCount();
            for(int i=0;i<rows;i++){
                String invoiceID=table.getValueAt(i, 0).toString();
                String Name=table.getValueAt(i, 1).toString();
                String Barcode=table.getValueAt(i, 2).toString();
                String quntity=table.getValueAt(i, 3).toString();
                String price=table.getValueAt(i, 4).toString();
                String total=table.getValueAt(i, 5).toString();
                statement.executeUpdate("insert into cart (InvoiceID,Name,BarCode,Quntity,Price,TotalPrice) values('"+invoiceID+"','"+Name+"','"+Barcode+"','"+quntity+"','"+price+"','"+total+"')");
                JOptionPane.showMessageDialog(null, "Data saved");
                
               
            }
           
        } catch (Exception ex) {
            System.out.println("Erro "+ex);
        }
        int ID=0;
        ID=Integer.parseInt(InvoiceID.getText());
        ID+=1;
        InvoiceID.setText(""+ID+"");
        try{
           Double val=Double.valueOf(Balance.getText());
           Double tot=Double.valueOf(totalAmount.getText());
           if(val.equals(0.0)){
               Status="Paid";
           }
           else if(val>tot){
               Status="Paid";
           }
           else if(val>0.0){
               Status="Paid";
           }
           else{
               Status="Unpaid Paid";
           }
           Statement s1= (Statement) DBConnector.DBCon().createStatement();
           s1.executeUpdate("insert into sales (InvoiceID,CusID,CustomerName,TotalQuntity,TotalPrice,Status,Balance) values('"+InvoiceID.getText()+"','"+CusID+"','"+CusName+"','"+totalQuntity+"','"+totalAmount.getText()+"','"+Status+"','"+Balance.getText()+"')");
        }
        catch(Exception ex){
            System.out.println("Erro "+ex);
        }
        RemoveAll();
        
        }
        else{
            JOptionPane.showMessageDialog(null, "Payment Was not Succesed");
            RemoveAll();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DiscountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiscountKeyReleased
        Balance.setText("0.0");
        if(Discount.getText().isEmpty()){
            Netcount();  
        }
        else{
             balance();
        }
       
        
    }//GEN-LAST:event_DiscountKeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCart;
    private javax.swing.JTextField Balance;
    private javax.swing.JComboBox<String> CusList;
    private javax.swing.JTextField Discount;
    private javax.swing.JLabel InvoiceID;
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JTextField PaidAmount;
    private javax.swing.JLabel Price;
    private javax.swing.JComboBox<String> ProList;
    private javax.swing.JTextField Quntity;
    private javax.swing.JButton Remove;
    private javax.swing.JButton RemoveAll;
    private javax.swing.JLabel Total;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField totalAmount;
    // End of variables declaration//GEN-END:variables
}
