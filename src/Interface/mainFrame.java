
package Interface;

import coddes.DBconnect;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;


public class mainFrame extends javax.swing.JFrame {

    Connection conn=null;
    PreparedStatement  pst ;
    ResultSet rs=null;
    
    public mainFrame() {
       
        this.pst = null;
        initComponents();
        conn=(Connection) DBconnect.connect();
        tableview();
    }

    
    
    
    public void tableview(){
    
        try {
            
            String sqlView = "SELECT  sno,sname,sage,sgrade FROM student ";
             pst=conn.prepareStatement(sqlView);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    
    }
    
    
    
        
    public void tabledata(){
        
        int raw = table1.getSelectedRow();
        String id= table1.getValueAt(raw,0).toString();
        String name=table1.getValueAt(raw,1).toString();
         String age=table1.getValueAt(raw,2).toString();
          String grade=table1.getValueAt(raw,3).toString();
          
          idBox.setText(id);
          nameBox.setText(name);
          ageBox.setText(age);
          gradeBox.setSelectedItem(grade);
          
        
        
        
    }
    
    public void srch(){
    
        
        
    String srch =searchBox.getText();
    
        try {
            String sqlSrch="SELECT * From student Where sname LIKE  '%"+srch+"%' OR sno LIKE '%"+srch+"%' ";
            
             pst=conn.prepareStatement(sqlSrch);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            
            
            JOptionPane.showMessageDialog(null,e);
            
        }
         
    
    
      
    
    
    
    
    
    
    
    }
    
    
    
    public void update(){
    
     String id=idBox.getText();
     String name = nameBox.getText();
     String age=ageBox.getText();
     String grade=gradeBox.getSelectedItem().toString();
     
        try {
            
            String sqlUpdate=" UPDATE student SET sname='"+name+"',sage='"+age+"',sgrade='"+grade+"' WHERE sno='"+id+"' ";
             pst=conn.prepareStatement(sqlUpdate);
             pst.execute();
             JOptionPane.showMessageDialog(null,"Updated");
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null," NOT Updated");
        }
    
    
    
    
    
    }
    
    void clear(){
    
    
    searchBox.setText("");
    idBox.setText("ID");
    nameBox.setText("");
    ageBox.setText("");
    gradeBox.getSelectedIndex();
    
    
    
    
    
    }
    
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameBox = new javax.swing.JTextField();
        ageBox = new javax.swing.JTextField();
        gradeBox = new javax.swing.JComboBox<>();
        insertBox = new javax.swing.JButton();
        upgradeBox = new javax.swing.JButton();
        deleteBox = new javax.swing.JButton();
        clearBox = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        idBox = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        searchBox = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 153));

        jPanel3.setBackground(new java.awt.Color(0, 51, 153));
        jPanel3.setForeground(new java.awt.Color(0, 0, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table1.setForeground(new java.awt.Color(51, 102, 255));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(table1);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 580));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 470, 580));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Name");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 60, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Age");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Grade");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 50, 20));

        nameBox.setToolTipText("Enter Name Here");
        nameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameBoxActionPerformed(evt);
            }
        });
        jPanel3.add(nameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 180, 30));

        ageBox.setToolTipText("Enter Age here");
        ageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageBoxActionPerformed(evt);
            }
        });
        jPanel3.add(ageBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 180, 30));

        gradeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grade_1", "Grade _2", "Grade _3", "Grade _4", "Grade _5", "Grade _6", "Grade _7 ", "Grade _8", "Grade _9", "Grade _10", "Grade _11" }));
        gradeBox.setToolTipText("Select");
        gradeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeBoxActionPerformed(evt);
            }
        });
        jPanel3.add(gradeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 180, -1));

        insertBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertBox.setForeground(new java.awt.Color(255, 51, 51));
        insertBox.setText("Insert");
        insertBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBoxActionPerformed(evt);
            }
        });
        jPanel3.add(insertBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 80, -1));

        upgradeBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upgradeBox.setForeground(new java.awt.Color(255, 51, 51));
        upgradeBox.setText("Upgrade");
        upgradeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upgradeBoxActionPerformed(evt);
            }
        });
        jPanel3.add(upgradeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 100, -1));

        deleteBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBox.setForeground(new java.awt.Color(255, 51, 51));
        deleteBox.setText("Delete");
        deleteBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBoxActionPerformed(evt);
            }
        });
        jPanel3.add(deleteBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 80, -1));

        clearBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearBox.setForeground(new java.awt.Color(255, 51, 51));
        clearBox.setText("Clear");
        clearBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBoxActionPerformed(evt);
            }
        });
        jPanel3.add(clearBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, 90, -1));

        exitButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 102, 102));
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        jPanel3.add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, -1, -1));

        jScrollPane4.setForeground(new java.awt.Color(0, 0, 255));

        idBox.setBackground(new java.awt.Color(0, 51, 153));
        idBox.setText("ID");
        jScrollPane4.setViewportView(idBox);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 140, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel5.setText("ID");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 40, 30));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search Here", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 51, 204));
        jPanel5.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchBox.setBackground(new java.awt.Color(204, 204, 255));
        searchBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchBox.setBorder(null);
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBoxKeyReleased(evt);
            }
        });
        jPanel5.add(searchBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 30));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 270, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(758, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameBoxActionPerformed

    private void gradeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeBoxActionPerformed

    private void ageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageBoxActionPerformed

    private void clearBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBoxActionPerformed
        clear();
    }//GEN-LAST:event_clearBoxActionPerformed

    private void insertBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBoxActionPerformed
        
        String name,grade;
        int age;
     
        name=nameBox.getText();
        age=Integer.parseInt(ageBox.getText());
        grade= (String) gradeBox.getSelectedItem();
        
        try {
            
            String  sql= "INSERT INTO student(sname,sage,sgrade) VALUES('"+name+"','"+age+"','"+grade+"')";
        
            pst=conn.prepareStatement(sql);
      
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"your data is inserted");
            
        }
        catch (SQLException e) 
        {
            
            JOptionPane.showMessageDialog(null,e);
            
            
        }
        
        tableview();
        
        
    }//GEN-LAST:event_insertBoxActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        
        
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
       
       tabledata();
        
    }//GEN-LAST:event_table1KeyReleased

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
    
    }//GEN-LAST:event_searchBoxActionPerformed

    private void searchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyReleased
    srch();
    }//GEN-LAST:event_searchBoxKeyReleased

    private void upgradeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upgradeBoxActionPerformed
    update();
    tableview();
        
    }//GEN-LAST:event_upgradeBoxActionPerformed

    private void deleteBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBoxActionPerformed
  
        int check = JOptionPane.showConfirmDialog(null,"Are you sure want to Delete this cell");
        if(check==0){
            
            String id=idBox.getText();
            
            try {
                String sqlDelete="DELETE From student Where sno='"+id+"'";
                pst=conn.prepareStatement(sqlDelete);
                pst.execute();
               JOptionPane.showMessageDialog(null,"Deleted");
                
            } catch (Exception e) {
                   JOptionPane.showMessageDialog(null,"not Deleted");
            }
       
        
        
        }
        
        
        tableview();
          clear();
        
    }//GEN-LAST:event_deleteBoxActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
       System.exit(0);
    }//GEN-LAST:event_exitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageBox;
    private javax.swing.JButton clearBox;
    private javax.swing.JButton deleteBox;
    private javax.swing.JButton exitButton;
    private javax.swing.JComboBox<String> gradeBox;
    private javax.swing.JTextPane idBox;
    private javax.swing.JButton insertBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField nameBox;
    private javax.swing.JTextField searchBox;
    private javax.swing.JTable table1;
    private javax.swing.JButton upgradeBox;
    // End of variables declaration//GEN-END:variables
}
