/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import javax.swing.JFileChooser;

import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JOptionPane;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 *
 * @author jsala
 */
public class Backup extends javax.swing.JFrame {

    FileMethods f = new FileMethods();
    static final Logger LOGGER = Logger.getAnonymousLogger();
    static String CPath = "C:\\MEIA\\";
    static String bitacoraPath = "C:\\MEIA\\bitacora_backup.txt";
    private User user; 
    /**
     * Creates new form Backup
     */
    public Backup() {
        initComponents();
    }
    
    public void setUser(User user){
        this.user = user;
        user.setRol("1");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        TF_backupPath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar ruta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TF_backupPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_backupPathActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SimSun-ExtB", 0, 24)); // NOI18N
        jLabel1.setText("Copia de seguridad");

        jButton2.setText("Ver bitácora");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Realizar Backup");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(TF_backupPath, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(TF_backupPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ValidateUserRol(){
        if (!(user.getRol() == "1")) {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            JOptionPane.showMessageDialog(null, "¡Lo sentimos! No puede realizar esta acción porque no es administrador", "Error de administrador", WIDTH);
        }
        else{
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TF_backupPath.setEnabled(false);
        JFileChooser dialog = new JFileChooser();
        
        dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        File newFile;
        String filePath;
        
        int value = dialog.showOpenDialog(this);
        if (value == JFileChooser.APPROVE_OPTION){
            newFile = dialog.getSelectedFile();
            filePath = newFile.getPath();
            TF_backupPath.setText(filePath + "\\MEIA_Backup\\");

            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TF_backupPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_backupPathActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TF_backupPathActionPerformed

    //Metodo para copiar todos los archivos a una nueva ruta
   /* private void copyFile(String origin, String actual){
        //static final Logger LOGGER = Logger.getAnonymousLogger();
        try{
            Path originPath = Paths.get(origin);
            Path actualPath = Paths.get(actual);
            Files.copy(originPath, actualPath, StandardCopyOption.REPLACE_EXISTING);
        }catch(FileNotFoundException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }catch(IOException ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }      
        NO CREO QUE ESTO SIRVA, ELIMINARLO SIN PROBLEMA    
    }*/ 
    //Método para escribir en bitácora
    private void writeBitacora(){
        f.createFile(bitacoraPath);
        Date date = new Date();
        DateFormat hourAndDate = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        f.writeOnBitacora(bitacoraPath, TF_backupPath.getText(), user.getUser(), hourAndDate.format(date));
        
    }
    //Botón para realizar la copia de seguridad
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ValidateUserRol();
        f.createFolder(TF_backupPath.getText());
        //copyFile(CPath ,TF_backupPath.getText()); no creo que sea necesaria esta línea del código solo la dejo por si algo pasa
        f.CopiarCarpeta(CPath, TF_backupPath.getText()+"\\");
        JOptionPane.showMessageDialog(null,"Se realizó la copia de seguridad con éxito", "Respaldo de información", WIDTH);
        writeBitacora();
    }//GEN-LAST:event_jButton3ActionPerformed

    //Botón salir
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    //Botón para ver la bitácora
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        f.AbrirArchivo(bitacoraPath);
    }//GEN-LAST:event_jButton2ActionPerformed

    //Abrir el archivo "bitácora_backup.txt"
   
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
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Backup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF_backupPath;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
