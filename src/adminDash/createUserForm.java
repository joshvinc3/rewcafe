/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminDash;

import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author JOSH
 */
public class createUserForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public createUserForm() {
        initComponents();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    

    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}    
      public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
   }
    
    

    
    
    public static String ema, usname;
    
public boolean duplicateCheck(){
      dbConnector dbc = new dbConnector();
   try{
   String query = "SELECT * FROM tbl_members WHERE u_username = '"+user.getText()+"'OR u_email ='"+email.getText()+"'";
        ResultSet resultSet = dbc.getData(query);
           
   if(resultSet.next()){
            ema = resultSet.getString("u_email");
     if(ema.equals(email.getText())){
     JOptionPane.showMessageDialog(null,"Email exists");
     email.setText("");
     }
    
         usname = resultSet.getString("u_username");   
     if(usname.equals(user.getText())){
     JOptionPane.showMessageDialog(null,"Username exists");
     user.setText("");
     }
        return true;   
   }else{ 
      return false;
    }     
            
   }catch(SQLException ex){
   System.out.print(""+ex);
   return false;
   
      }          
    
    }
    public boolean updateCheck(){
      dbConnector dbc = new dbConnector();
   try{
   String query = "SELECT * FROM tbl_members WHERE (u_username = '"+user.getText()+"'OR u_email ='"+email.getText()+"') AND u_id!= '"+uid.getText()+"' ";
        ResultSet resultSet = dbc.getData(query);
           
   if(resultSet.next()){
            ema = resultSet.getString("u_email");
     if(ema.equals(email.getText())){
     JOptionPane.showMessageDialog(null,"Email exists");
     email.setText("");
     }
    
         usname = resultSet.getString("u_username");   
     if(usname.equals(user.getText())){
     JOptionPane.showMessageDialog(null,"Username exists");
     user.setText("");
     }
        return true;   
   }else{ 
      return false;
    }     
            
   }catch(SQLException ex){
   System.out.print(""+ex);
   return false;
   
      }          
    
    }
               
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        userstat = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        ut = new javax.swing.JComboBox<>();
        fname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(146, 120, 93));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("USER ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 100, 50, 15);

        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel1.add(uid);
        uid.setBounds(120, 90, 190, 27);
        jPanel1.add(lname);
        lname.setBounds(120, 170, 190, 27);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LAST NAME");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(40, 180, 70, 15);
        jPanel1.add(email);
        email.setBounds(120, 210, 190, 27);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("EMAIL");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 210, 39, 15);
        jPanel1.add(user);
        user.setBounds(120, 250, 190, 27);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("USERNAME");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 250, 67, 15);

        pass.setEnabled(false);
        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel1.add(pass);
        pass.setBounds(120, 290, 190, 27);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("PASSWORD");
        jLabel7.setEnabled(false);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 290, 72, 15);

        userstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending", " " }));
        userstat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userstatActionPerformed(evt);
            }
        });
        jPanel1.add(userstat);
        userstat.setBounds(120, 360, 190, 29);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ACCOUNT TYPE");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 330, 100, 15);

        add.setText("ADD");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(10, 40, 83, 23);

        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel1.add(ut);
        ut.setBounds(120, 320, 190, 29);

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel1.add(fname);
        fname.setBounds(120, 130, 190, 27);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("FIRST NAME");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 140, 74, 15);

        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(110, 40, 93, 23);

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(220, 40, 83, 23);

        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel1.add(clear);
        clear.setBounds(310, 40, 83, 23);

        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel);
        cancel.setBounds(530, 40, 83, 23);

        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel1.add(refresh);
        refresh.setBounds(420, 40, 93, 23);

        jPanel3.setLayout(null);
        jPanel3.add(image);
        image.setBounds(14, 10, 180, 240);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(370, 100, 210, 257);

        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel1.add(select);
        select.setBounds(370, 360, 69, 23);

        remove.setText("REMOVE");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel1.add(remove);
        remove.setBounds(510, 360, 73, 23);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/internetbax/internetbax.png"))); // NOI18N
        jLabel8.setText("jLabel8");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(-70, -70, 720, 590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        remove.setEnabled(false);
        select.setEnabled(true);
        image.setIcon(null);
        path = "";
    }//GEN-LAST:event_removeActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userimages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    image.setIcon(ResizeImage(path, null, image));
                    select.setEnabled(false);
                    remove.setEnabled(true);

                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        userForm usf = new userForm();
        usf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        if(fname.getText().isEmpty()||lname.getText().isEmpty()||email.getText().isEmpty()||user.getText().isEmpty()||pass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are needed!!!!!!");

        }else if(pass.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Password should atleast have 8 characters!");
            pass.setText("");
        }else if(updateCheck()){
            System.out.print("This already existed");
        }else{

            dbConnector dbc = new dbConnector();
            dbc.updateData("UPDATE tbl_members SET u_fname = '"+fname.getText()+"',u_lname = '"+lname.getText()+"',"
                + " u_email = '"+email.getText()+"',u_username = '"+user.getText()+"',"
                + "u_password = '"+pass.getText()+"',u_type ='"+ut.getSelectedItem()+"', u_status ='"+userstat.getSelectedItem()+"',u_image ='"+destination+"' WHERE u_id = '"+uid.getText()+"' ");

            if(destination.isEmpty()){
                File existingFile = new File(oldpath);
                if(existingFile.exists()){
                    existingFile.delete();
                }
            }else{
                if(!(oldpath.equals(path))){
                    imageUpdater(oldpath, path);
                }
            }
            userForm uf = new userForm ();
            uf.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_updateActionPerformed

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        if(fname.getText().isEmpty()||lname.getText().isEmpty()||email.getText().isEmpty()||user.getText().isEmpty()||pass.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields are needed!!!!!!");

        }else if(pass.getText().length()<8){
            JOptionPane.showMessageDialog(null,"Password should atleast have 8 characters!");
            pass.setText("");
        }else if(duplicateCheck()){
            System.out.print("This already existed");
        }else{
            dbConnector dbc = new dbConnector();

            if(dbc.insertData("INSERT INTO tbl_members (u_fname, u_lname, u_email, u_username, u_password, u_type, u_status, u_image)"
                +"VALUES ('"+fname.getText()+"','"+lname.getText()+"', '"+email.getText()+"', '"+user.getText()+"','"+pass.getText()+"','"+ut.getSelectedItem()+"','"+userstat.getSelectedItem()+"','"+destination+"')"))
        {
            try{
                Files.copy(selectedFile.toPath(),new File(destination).toPath(),StandardCopyOption.REPLACE_EXISTING );

                JOptionPane.showMessageDialog(null, "Registration Success!");
                userForm uf = new userForm ();
                uf.setVisible(true);
                this.dispose();
            }catch(IOException ex){
                System.out.println("Insert Image Error,"+ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Registration Error!");
        }
        }
    }//GEN-LAST:event_addActionPerformed

    private void userstatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userstatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userstatActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton add;
    private javax.swing.JButton cancel;
    private javax.swing.JButton clear;
    public javax.swing.JButton delete;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fname;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField lname;
    public javax.swing.JTextField pass;
    private javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JButton select;
    public javax.swing.JTextField uid;
    public javax.swing.JButton update;
    public javax.swing.JTextField user;
    public javax.swing.JComboBox<String> userstat;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
