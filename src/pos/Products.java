/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class Products extends javax.swing.JPanel {

    /**
     * Creates new form Products
     */
    public Products() {
        initComponents();
        tableload();
         Color white = new Color(255,255,255);
        ProTable.setBackground(white);
        ProTable.setGridColor(white);
        ProTable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
        ProTable.getTableHeader().setOpaque(false);
        ProTable.getTableHeader().setReorderingAllowed(false);
        ProTable.getTableHeader().setBackground(white);
        ProTable.getTableHeader().setForeground(new Color(0,0,0));
        ProTable.setRowHeight(40);
    }
     public void tableload(){
       
        try {
             DefaultTableModel table =(DefaultTableModel) ProTable.getModel();
             table.setRowCount(0);
             Statement statment=(Statement) DBConnector.DBCon().createStatement();
             ResultSet results=statment.executeQuery("select * from products");
             while(results.next())
             {
                 Vector v = new Vector();
                 v.add(results.getString("ProductsID"));
                 v.add(results.getString("ProductName"));
                 v.add(results.getString("SupplierID"));
                 v.add(results.getString("Quntity"));
                 v.add(results.getString("Price"));
                 table.addRow(v);
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
     public void SearchTable(){
        if(SearchProduct.getText().trim().isEmpty()) {
            tableload();
        }
        else{ try{
                Statement State=(Statement) DBConnector.DBCon().createStatement();
                ResultSet result=State.executeQuery("select * from products where ProductName='"+SearchProduct.getText()+"'");
                DefaultTableModel table =(DefaultTableModel) ProTable.getModel();
                table.setRowCount(0);
                  while(result.next())
                 {
                   
                    Vector v = new Vector();
                    v.add(result.getString("ProductsID"));
                    v.add(result.getString("ProductName"));
                    v.add(result.getString("SupplierID"));
                    v.add(result.getString("Quntity"));
                    v.add(result.getString("Price"));
                    table.addRow(v);
                 }
            }
            catch(Exception e){
                System.out.print("Erro while data fetching "+e);
            }
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Price = new javax.swing.JTextField();
        ProductAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BarCode = new javax.swing.JTextField();
        Quntity = new javax.swing.JTextField();
        ProductName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SupplierID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        SearchProduct = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        ProductID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setPreferredSize(new java.awt.Dimension(1660, 327));

        Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceActionPerformed(evt);
            }
        });

        ProductAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/images/icons8_add_64px_3.png"))); // NOI18N
        ProductAdd.setText("ADD");
        ProductAdd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ProductAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductAddActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Price");

        BarCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarCodeActionPerformed(evt);
            }
        });

        Quntity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuntityActionPerformed(evt);
            }
        });

        ProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bar Code");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Product Name");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quntity");

        SupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierIDActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Supplier ID");

        ProTable.setBackground(new java.awt.Color(153, 153, 153));
        ProTable.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ProTable.setForeground(new java.awt.Color(0, 153, 153));
        ProTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ProductID", "Product Name", "Supplier ID", "Quntity", "Price"
            }
        ));
        ProTable.setGridColor(new java.awt.Color(0, 204, 153));
        ProTable.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(ProTable);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/images/icons8_update_left_rotation_64px.png"))); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/images/icons8_remove_64px.png"))); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Employee");

        SearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchProductKeyReleased(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Find");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ProductID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Product ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(41, 41, 41)
                .addComponent(SearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(354, 354, 354))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(131, 131, 131)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(SupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Quntity, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(ProductName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(55, 55, 55)
                                                    .addComponent(BarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel5))))
                                    .addComponent(ProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProductAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SearchProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BarCode, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Quntity, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SupplierID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ProductAdd)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PriceActionPerformed

    private void BarCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarCodeActionPerformed

    private void QuntityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuntityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuntityActionPerformed

    private void ProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameActionPerformed

    private void SupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierIDActionPerformed

    private void ProductAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductAddActionPerformed
        String name=ProductName.getText();
        String productID=ProductID.getText();
        String supplierID=SupplierID.getText();
        String quntity=Quntity.getText();
        double price=Double.parseDouble(Price.getText());
        String barcode=BarCode.getText();
        try{
            Statement s = (Statement) DBConnector.DBCon().createStatement();
            s.executeUpdate("insert into products (ProductName,ProductsID,SupplierID,Quntity,Price,BarCode)values('"+name+"','"+productID+"','"+supplierID+"','"+quntity+"','"+price+"','"+barcode+"')");
            tableload();
            JOptionPane.showMessageDialog(null, "Product Added");
            System.out.println("Product Added");
            
        }
        catch(Exception e)
        {
            System.out.print("Erro while data fetching"+e);
        }
        ProductName.setText(null);
        ProductID.setText(null);
        SupplierID.setText(null);
        Quntity.setText(null);
        Price.setText(null);
        BarCode.setText(null);
    }//GEN-LAST:event_ProductAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String productID = ProductID.getText();
        String name = null;
        String supplierID = null;
        String quntity = null;
        double price = 0;
        String barcode = null;
        
        try{
            Statement statement = (Statement) DBConnector.DBCon().createStatement();
            ResultSet results=  statement.executeQuery("select * from products where ProductsID='"+productID+"'");
            results.next();
             name= results.getString("ProductName");
             supplierID=results.getString("SupplierID");
             quntity=results.getString("Quntity");
             price= Double.parseDouble(results.getString("Price"));
             barcode=results.getString("BarCode");
             System.out.println("Employee selected");
        }
        catch(Exception e)
        {
            System.out.print("Erro while data fetching"+e);
        }
        
        if(!ProductName.getText().isEmpty()){
            name=ProductName.getText();
        }
        if(!SupplierID.getText().isEmpty()){
            supplierID=SupplierID.getText();
        }
        if(!Quntity.getText().isEmpty()){
            quntity=Quntity.getText();
        }
        if(!Price.getText().isEmpty()){
            price=Double.parseDouble(Price.getText());
        }
        if(!BarCode.getText().isEmpty()){
             barcode=BarCode.getText();
        }
        try{
            Statement s = (Statement) DBConnector.DBCon().createStatement();
            s.executeUpdate("update products set ProductName ='"+name+"',SupplierID ='"+supplierID+"',Quntity='"+quntity+"',Price='"+price+"',BarCode='"+barcode+"' where ProductsID='"+productID+"' ");
            tableload();
            JOptionPane.showMessageDialog(null, "Update Success");
            System.out.println("Employee updated");
        }
        catch(Exception e)
        {
            System.out.print("Erro while data fetching"+e);
        }
        ProductName.setText(null);
        ProductID.setText(null);
        SupplierID.setText(null);
        Quntity.setText(null);
        Price.setText(null);
        BarCode.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ProductIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductIDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Statement statement=(Statement) DBConnector.DBCon().createStatement();
            statement.executeUpdate("delete from products where ProductsID='"+ProductID.getText().trim()+"'");
            tableload();
            JOptionPane.showMessageDialog(null, "Delete Success");
        }
        catch(Exception e){
            System.out.print("Erro while data fetching"+e);
        }
        ProductName.setText(null);
        ProductID.setText(null);
        SupplierID.setText(null);
        Quntity.setText(null);
        Price.setText(null);
        BarCode.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void SearchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchProductKeyReleased
        SearchTable();
    }//GEN-LAST:event_SearchProductKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        SearchTable();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarCode;
    private javax.swing.JTextField Price;
    private javax.swing.JTable ProTable;
    private javax.swing.JButton ProductAdd;
    private javax.swing.JTextField ProductID;
    private javax.swing.JTextField ProductName;
    private javax.swing.JTextField Quntity;
    private javax.swing.JTextField SearchProduct;
    private javax.swing.JTextField SupplierID;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
