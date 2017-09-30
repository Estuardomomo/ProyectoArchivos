/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.Color;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JOptionPane;
/**
 *
 * @author User_Len
 */
public class Log_In extends javax.swing.JFrame {

    //ATRIBUTES
    User objUsuario = new User();
    FileMethods archivos = new FileMethods();
    String rutaUsuarios = "c:\\MEIA\\Usuarios.txt";
    String fotografía;
    String descripción = "Añade una breve descripción";
    Boolean usuario;
    Boolean contraseña;
    Boolean nuevoUsuario;
    Boolean nuevaContraseña;
    Boolean nombre;
    Boolean apellido;
    Boolean fecha;
    Boolean correo;
    Boolean teléfono;
    /**
     * Creates new form Log_In
     */
    public Log_In() {
        initComponents();
        archivos.createFolder("c:\\MEIA\\");
        archivos.createFile(rutaUsuarios);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUsuario = new javax.swing.JTextField();
        tfNUsuario = new javax.swing.JTextField();
        tfNContraseña = new javax.swing.JTextField();
        tfNNombre = new javax.swing.JTextField();
        tfNApellido = new javax.swing.JTextField();
        cbDía = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        cbAño = new javax.swing.JComboBox<>();
        tfNCorreo = new javax.swing.JTextField();
        tfNTeléfono = new javax.swing.JTextField();
        lbNUsuario = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbNContraseña = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        lbTeléfono = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        lbContraseña = new javax.swing.JLabel();
        lbEslogan = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();
        tfImagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });

        cbDía.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "ene", "feb", "mar", "abr", "may", "jun", "jul", "ago", "sep", "oct", "nov", "dic" }));

        cbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));

        lbNUsuario.setText("Usuario");

        lbNombre.setText("Nombre");

        lbApellido.setText("Apellido");

        lbNContraseña.setText("Contraseña");

        lbCorreo.setText("Correo electónico");

        lbTeléfono.setText("Teléfono");

        lbLogin.setText("Usuario:");

        btnRegistrar.setText("Registarse");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnLogin.setText("Iniciar Sesión");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lbContraseña.setText("Contraseña:");

        lbEslogan.setText("¿Eres nuevo? ¡Registrate!");

        tfImagen.setText("Foto Perfil");
        tfImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbApellido)
                            .addComponent(lbEslogan)
                            .addComponent(lbNUsuario)
                            .addComponent(lbNombre)
                            .addComponent(lbNContraseña)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbDía, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 138, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbLogin)
                                            .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbContraseña)
                                            .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(9, 9, 9)))
                                .addComponent(btnLogin))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                .addComponent(tfNApellido, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfNNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfNUsuario, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCorreo)
                                    .addComponent(lbTeléfono))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfNTeléfono, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(tfNCorreo))))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(tfImagen)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogin)
                    .addComponent(lbContraseña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogin)
                    .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEslogan)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNContraseña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbDía, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCorreo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNTeléfono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTeléfono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(tfImagen))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        tfUsuario.getAccessibleContext().setAccessibleName("");
        tfUsuario.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUsuarioActionPerformed

    //BOTON INICIAR SESION
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (archivos.fileSizeNotZero(rutaUsuarios)) { //quiere decir que ya hay usuarios en el documento Usuarios.txt
            
            String user = tfUsuario.getText();
            
            char[] pass = pfPassword.getPassword();
            if(!archivos.loginMethod(user, pass, rutaUsuarios, objUsuario)){ //el usuario si existe y pudo hacer login se abre la nueva ventana con este método asumo que ya hay usuarios en la base de datos
                  //Mandar mensaje que no se pudo logear porque la contraseña es incorrecta o porque no existe el usuario 
                  JOptionPane.showMessageDialog(null,"Comprueba el nombre de usuario y tu contraseña y vuelve a intentarlo.", "Usuario o contraseña incorrecta", WIDTH);
                  
            }else{
                //se manda al siguiente form que sería la parte de kevin
                //RECORDATORIO: el siguiente jFrame debe recibir por parámetros el objeto "actualUser" 
            }
            
        }else{//no hay ningun usuario en el documento
            
            JOptionPane.showMessageDialog(null,"¡Lo sentimos! Registrate para poder iniciar sesión", "Crear registro", WIDTH);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void tfImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfImagenActionPerformed
        
        //Seleccionar una foto de perfil.
        fotografía = archivos.fotoPerfil(this);
    }//GEN-LAST:event_tfImagenActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
    //Verificar nuevo Usuario
    if(tfNUsuario.getText().equals(""))
    {
        nuevoUsuario = false;
        tfNUsuario.setBackground(Color.pink);
    }
    else
    {
        nuevoUsuario = true;
        tfNUsuario.setBackground(Color.green);
    }
    //Verificar Nombre
    if(tfNNombre.getText().equals(""))
    {
        nombre = false;
        tfNNombre.setBackground(Color.pink);
    }
    else
    {
        nombre = true;
        tfNNombre.setBackground(Color.green);
    }
    //Verificar Apellido
    if(tfNApellido.getText().equals(""))
    {
        apellido = false;
        tfNApellido.setBackground(Color.pink);
    }
    else
    {
        apellido = true;
        tfNApellido.setBackground(Color.green);
    }
    //Verificar Contraseña
    if(tfNContraseña.getText().equals(""))
    {
        nuevaContraseña = false;
        tfNContraseña.setBackground(Color.pink);
    }
    else
    {
        contraseña = true;
        tfNContraseña.setBackground(Color.green);
    }
    //Verificar fecha de nacimiento
    if(cbDía.getSelectedItem() == " " || cbMes.getSelectedItem() == " " || cbAño.getSelectedItem() == " ")
    {
        fecha = false;
        cbDía.setBackground(Color.red);
        cbMes.setBackground(Color.red);
        cbAño.setBackground(Color.red);
    }
    else
    {
        fecha = true;
        cbDía.setBackground(Color.green);
        cbMes.setBackground(Color.green);
        cbAño.setBackground(Color.green);
    }
    //Verificar correo electónico
    if(tfNCorreo.getText().equals(""))
    {
        correo = false;
        tfNCorreo.setBackground(Color.pink);
    }
    else
    {
        correo = true;
        tfNCorreo.setBackground(Color.green);
    }
    //Verificar télefono
    try
    {
        Integer.parseInt(tfNTeléfono.getText());
        teléfono = true;
        tfNTeléfono.setBackground(Color.green);
    }
    catch(Exception ex)
    {
        teléfono = false;
        tfNTeléfono.setBackground(Color.pink);
    }
    //Si todo es correcto, ingresar el registro.
    if(nuevoUsuario && nombre && apellido && nuevaContraseña && fecha && correo && teléfono)
    {
        //Si es el primer registro, rol administrador
        if(archivos.fileSizeNotZero(rutaUsuarios))
        {
          archivos.writeOnUserFile(rutaUsuarios, tfNUsuario.getText(), tfNNombre.getText(),tfNApellido.getText(), tfNContraseña.getText().toCharArray(), 1, cbDía.getSelectedItem()+"/"+cbMes.getSelectedItem()+"/"+cbAño.getSelectedItem(),tfNCorreo.getText(), Integer.parseInt(tfNTeléfono.getText()), fotografía, descripción,1);
        }
        //Sino, rol de usuario común.
        else
        {
            archivos.writeOnUserFile(rutaUsuarios, tfNUsuario.getText(), tfNNombre.getText(),tfNApellido.getText(), tfNContraseña.getText().toCharArray(), 0, cbDía.getSelectedItem()+"/"+cbMes.getSelectedItem()+"/"+cbAño.getSelectedItem(),tfNCorreo.getText(), Integer.parseInt(tfNTeléfono.getText()), fotografía, descripción,1);  
        }
        
    }
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log_In.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_In().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbDía;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbEslogan;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNContraseña;
    private javax.swing.JLabel lbNUsuario;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTeléfono;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JButton tfImagen;
    private javax.swing.JTextField tfNApellido;
    private javax.swing.JTextField tfNContraseña;
    private javax.swing.JTextField tfNCorreo;
    private javax.swing.JTextField tfNNombre;
    private javax.swing.JTextField tfNTeléfono;
    private javax.swing.JTextField tfNUsuario;
    private javax.swing.JTextField tfUsuario;
    // End of variables declaration//GEN-END:variables
}
