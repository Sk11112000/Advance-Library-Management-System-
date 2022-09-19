/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import com.mysql.cj.xdevapi.Result;
import java.awt.Color;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

 /*
 * @author sunnykulshrestha
 */
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    public ManageStudent() throws SQLException {
        initComponents();
        getData();
    }
    String student_name,phone,branch;
    int student_id; 
    DefaultTableModel modle;
    public boolean update(){
        student_id=Integer.parseInt(txt_studentid.getText());
            student_name=txt_StudentName.getText();
            phone=txt_phone.getText();
            branch=txt_branch.getSelectedItem().toString();
               try{
                   Connection con=DBConnection.getConnection();
                  String sql="update student set student_name=?, contact=? ,branch=? where student_id=?";
                   
                   
                  
                  PreparedStatement pst=con.prepareStatement(sql);
                  pst.setString(1,student_name);
                  pst.setString(2,phone);
                  pst.setString(3,branch);
                  pst.setInt(4,student_id);
                  int rs=pst.executeUpdate();
                  if(rs>0) return true;
                  return false;
                     
                          }
               catch(Exception e)
               {     System.out.println(e);
                   
               }
        return false;
    }
    public boolean Delete(){
        student_id=Integer.parseInt(txt_studentid.getText());
                 try{
                     
                   Connection con=DBConnection.getConnection();
                   String sql="delete from student where student_id=?";
                  PreparedStatement pst=con.prepareStatement(sql);
                  pst.setInt(1,student_id);
                  int rs=pst.executeUpdate();
                  if(rs>0) return true;
                  return false;
                     
                          }
               catch(Exception e)
               {     System.out.println(e);
                   
               }
        return false;
    }

    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel)student_table.getModel();
           model.setRowCount(0);
    }
    public boolean addData(){
        Connection con=DBConnection.getConnection();
        String sql="insert into student values(?,?,?,?)";
         PreparedStatement pst;
        
            student_id=Integer.parseInt(txt_studentid.getText());
            student_name=txt_StudentName.getText();
            phone=txt_phone.getText();
            branch=txt_branch.getSelectedItem().toString();
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);
         pst.setString(2, student_name);
         pst.setString(3, phone);
         pst.setString(4, branch);
         int rowCount=pst.executeUpdate();
         if(rowCount>0){
         
         return true;
         }
         
        

        } catch (SQLException ex) {
            Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
         
    }
      public void getData() throws SQLException{
         
            Connection con=(Connection) DBConnection.getConnection();
            Statement  st = con.createStatement();
       
       ResultSet rs=st.executeQuery("select *from student");
       while(rs.next())
       {
           String student_id=rs.getString("student_id");
           String student_name=rs.getString("student_name");
           String contact=rs.getString("contact");
           String branch=rs.getString("branch");
           Object obj[]={student_id,student_name,contact,branch};
           modle=(DefaultTableModel) student_table.getModel();
           modle.addRow(obj);
           
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_studentid = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_StudentName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_phone = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        Add = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        txt_branch = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        student_table = new rojeru_san.complementos.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 204));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 50));

        jLabel8.setFont(new java.awt.Font("Kailasa", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Student Id");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 180, -1));

        jLabel7.setFont(new java.awt.Font("Kailasa", 2, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 60, 60));

        txt_studentid.setBackground(new java.awt.Color(102, 0, 204));
        txt_studentid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentid.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentid.setActionCommand("<Not Set>");
        txt_studentid.setPhColor(new java.awt.Color(255, 255, 255));
        txt_studentid.setPlaceholder("Enter Student Id");
        txt_studentid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentidFocusLost(evt);
            }
        });
        txt_studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 310, 30));

        jLabel9.setFont(new java.awt.Font("Kailasa", 2, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Student Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 170, -1));

        jLabel10.setFont(new java.awt.Font("Kailasa", 2, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 50, 40));

        txt_StudentName.setBackground(new java.awt.Color(102, 0, 204));
        txt_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_StudentName.setForeground(new java.awt.Color(255, 255, 255));
        txt_StudentName.setPhColor(new java.awt.Color(255, 255, 255));
        txt_StudentName.setPlaceholder("Enter Student Name");
        txt_StudentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_StudentNameFocusLost(evt);
            }
        });
        txt_StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_StudentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 310, 30));

        jLabel11.setFont(new java.awt.Font("Kailasa", 2, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contact No.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 110, -1));

        jLabel12.setFont(new java.awt.Font("Kailasa", 2, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 50, 40));

        txt_phone.setBackground(new java.awt.Color(102, 0, 204));
        txt_phone.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_phone.setForeground(new java.awt.Color(255, 255, 255));
        txt_phone.setPhColor(new java.awt.Color(255, 255, 255));
        txt_phone.setPlaceholder("Phone Number");
        txt_phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_phoneFocusLost(evt);
            }
        });
        txt_phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneActionPerformed(evt);
            }
        });
        jPanel1.add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 300, 30));

        jLabel13.setFont(new java.awt.Font("Kailasa", 2, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Branch");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 110, -1));

        jLabel14.setFont(new java.awt.Font("Kailasa", 2, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 50, 40));

        rSMaterialButtonCircle2.setText("Delete");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 660, 120, 60));

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });
        jPanel1.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 120, 60));

        rSMaterialButtonCircle4.setText("Update");
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 660, 120, 60));

        txt_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer science ", "Civil engineer", "Mechanical engineer", " ", " " }));
        txt_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_branchActionPerformed(evt);
            }
        });
        jPanel1.add(txt_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, 300, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Contact No.", "Branch"
            }
        ));
        student_table.setColorBackgoundHead(new java.awt.Color(102, 0, 204));
        student_table.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        student_table.setColorFilasForeground1(new java.awt.Color(102, 0, 204));
        student_table.setColorFilasForeground2(new java.awt.Color(102, 0, 204));
        student_table.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 13)); // NOI18N
        student_table.setFuenteFilas(new java.awt.Font("Apple Braille", 0, 14)); // NOI18N
        student_table.setFuenteFilasSelect(new java.awt.Font(".AppleSystemUIFont", 1, 18)); // NOI18N
        student_table.setRowHeight(40);
        student_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                student_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(student_table);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 810, 210));

        jPanel4.setBackground(new java.awt.Color(102, 0, 204));

        jLabel2.setBackground(new java.awt.Color(255, 153, 153));
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Students-icon (1).png"))); // NOI18N
        jLabel2.setText("Manage Student");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 350, 120));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 1160, 830));

        setSize(new java.awt.Dimension(1724, 856));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jPanel2.setBackground(Color.red);
        
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jPanel2.setBackground(new Color(102,0,204));
        
    }//GEN-LAST:event_jLabel1MouseExited

    private void txt_studentidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentidFocusLost
        
    }//GEN-LAST:event_txt_studentidFocusLost

    private void txt_studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentidActionPerformed

    private void txt_StudentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_StudentNameFocusLost
      
    }//GEN-LAST:event_txt_StudentNameFocusLost

    private void txt_StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_StudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_StudentNameActionPerformed

    private void txt_phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_phoneFocusLost
        
    }//GEN-LAST:event_txt_phoneFocusLost

    private void txt_phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        // TODO add your handling code here:
        if(update()){
            JOptionPane.showMessageDialog(this,"Update Done");
            clearTable();
            try {
                getData();
            } catch (SQLException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Update failed");
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
        if(addData())
        {                  
                JOptionPane.showMessageDialog(this,"Student add");
                    clearTable();
                           try {
                               getData();
                           } catch (SQLException ex) {
                               Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
                           }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Book add Fail");
        }
                  
    }//GEN-LAST:event_AddActionPerformed

    private void student_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_tableMouseClicked
        // TODO add your handling code here:
        int rowno =student_table.getSelectedRow();
        TableModel modle=student_table.getModel();
        
        txt_studentid.setText(modle.getValueAt(rowno,0).toString());
        txt_StudentName.setText((String) modle.getValueAt(rowno , 1));
        txt_phone.setText((String) modle.getValueAt(rowno , 2));
        txt_branch.setSelectedItem(modle.getValueAt(rowno, 3).toString());
    }//GEN-LAST:event_student_tableMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if(Delete())
        {
            JOptionPane.showMessageDialog(this,"Data Delete From database");
            clearTable();
            try {
                getData();
            } catch (SQLException ex) {
                Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
        } 
        else
            JOptionPane.showMessageDialog(this,"Delete Failed");
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_branchActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageStudent().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle Add;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojeru_san.complementos.RSTableMetro student_table;
    private app.bolivia.swing.JCTextField txt_StudentName;
    private javax.swing.JComboBox<String> txt_branch;
    private app.bolivia.swing.JCTextField txt_phone;
    private app.bolivia.swing.JCTextField txt_studentid;
    // End of variables declaration//GEN-END:variables
}