/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author User_Len
 */
public class MantenimientoGrupos extends javax.swing.JFrame {

    /**
     * Creates new form MantenimientoGrupos
     */
    String RutaU = "c:\\MEIA\\Usuarios.txt";
    String RutaBU = "c:\\MEIA\\BitácoraUsuarios.txt";
    String DescriptorU = "c:\\MEIA\\DescriptorU.txt";
    String DescriptorBU = "c:\\MEIA\\DescriptorBU.txt";
    String RutaA = "c:\\MEIA\\Lista_Amigos.txt";
    String RutaBA = "c:\\MEIA\\BitácoraAmigos.txt";
    String DescriptorA = "c:\\MEIA\\DescriptorA.txt";
    String DescriptorBA = "c:\\MEIA\\DescriptorBA.txt";
    String RutaG = "c:\\MEIA\\Grupos.txt";
    String RutaBG = "c:\\MEIA\\BitácoraGrupos.txt";
    String DescriptorG = "c:\\MEIA\\DescriptorG.txt";
    String DescriptorBG = "c:\\MEIA\\DescriptorBG.txt";
    Secuencial objSecuencial = new Secuencial(RutaBG);
    User Usuario;
    Boolean GNombre;
    Boolean Gintegrantes;
    Boolean GDescripcion;
    DefaultListModel listaGrupos = new DefaultListModel();
    //Constructores
    public MantenimientoGrupos() {
        initComponents();
    }
    
    public MantenimientoGrupos(User uncliente) {
        Usuario = uncliente;
        ActualizarOpciones();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfGNombre = new javax.swing.JTextField();
        tfGMiembros = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfGDescripcion = new javax.swing.JTextArea();
        btnGCrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbGrupos2 = new javax.swing.JComboBox<>();
        btnGEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbGrupos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tfGNMiembro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfGNDescripcion = new javax.swing.JTextArea();
        btnGModificar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        AgregarAmigos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Crear un nuevo grupo");

        jLabel2.setText("Nombre del grupo");

        jLabel3.setText("Número de integrantes");

        tfGDescripcion.setColumns(20);
        tfGDescripcion.setRows(5);
        tfGDescripcion.setText("Anade una breve descripcion");
        jScrollPane1.setViewportView(tfGDescripcion);

        btnGCrear.setText("Crear");
        btnGCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGCrearActionPerformed(evt);
            }
        });

        jLabel4.setText("Eliminar grupo:");

        btnGEliminar.setText("Eliminar");
        btnGEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGEliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Modificar un grupo");

        cbGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGruposActionPerformed(evt);
            }
        });

        jLabel6.setText("Núm miembros:");

        tfGNDescripcion.setColumns(20);
        tfGNDescripcion.setRows(5);
        jScrollPane2.setViewportView(tfGNDescripcion);

        btnGModificar.setText("Modificar");
        btnGModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGModificarActionPerformed(evt);
            }
        });

        btnVolver.setText("Cerrar");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        AgregarAmigos.setText("Añadir integrantes");
        AgregarAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarAmigosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfGMiembros))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfGNombre))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnGCrear)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbGrupos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tfGNMiembro, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGModificar)
                                .addGap(39, 39, 39))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AgregarAmigos)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbGrupos2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGEliminar)))
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfGNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfGMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfGNMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGCrear)
                    .addComponent(btnGModificar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbGrupos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGEliminar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AgregarAmigos)
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolver)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGCrearActionPerformed
        //Verificar que todos los campos se llenaron.
        if(tfGNombre.getText().equals(""))
        {
            tfGNombre.setBackground(Color.pink);
            GNombre = false;
        }
        else
        {
            GNombre = true;
        }
        if(tfGMiembros.getText().equals(""))
        {
            tfGMiembros.setBackground(Color.pink);
            Gintegrantes = false;
        }
        else
        {
            Gintegrantes = true;
        }
        if(tfGDescripcion.getText().equals(""))
        {
            tfGDescripcion.setBackground(Color.pink);
            GDescripcion = false;
        }
        else
        {
            GDescripcion = true;
        }
        //Insertar en el archivo secuencial
        if(GNombre & Gintegrantes & GDescripcion & (objSecuencial.busqueda(false, Usuario.getUser()+"|"+tfGNombre.getText(), RutaBG, RutaG) == "|0" ))
        {
            objSecuencial.ActualizarDescriptor(DescriptorBG, Usuario.getUser());
            Grupo objGrupo = new Grupo();
            objGrupo.SetUsuario(Usuario.getUser());
            objGrupo.SetNombre(tfGNombre.getText());
            objGrupo.SetDescripcion(tfGDescripcion.getText());
            objGrupo.SetMiembros(Integer.parseInt(tfGMiembros.getText()));
            objGrupo.SetFecha((new Date()).toString());
            objSecuencial.Insertar(RutaBG, new User(), new Solicitud(), objGrupo);
        }
        //Actualizar los combobox.
        ActualizarOpciones();
    }//GEN-LAST:event_btnGCrearActionPerformed

    private void btnGEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGEliminarActionPerformed
        //Confirmar que se escogió un elemento
        if(cbGrupos2.getSelectedItem() != " ")
        {
            //Eliminación lógica.
            try {
                objSecuencial.Eliminar(objSecuencial.busqueda(false, Usuario.getUser() + "|" + cbGrupos2.getSelectedItem(), RutaBG, RutaG));
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoGrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Actualizar los combobox
            ActualizarOpciones();
        }
    }//GEN-LAST:event_btnGEliminarActionPerformed

    private void btnGModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGModificarActionPerformed
        //Verificar que se llenaron todos los campos.
        if((cbGrupos.getSelectedItem() != " ") & (tfGNMiembro.getText() != "") & (tfGNDescripcion.getText() != ""))
        {
            //Obtener el objeto guardado en el archivo
            Grupo objGrupo = objSecuencial.LeerGrupo(objSecuencial.busqueda(false, Usuario.getUser()+"|"+cbGrupos.getSelectedItem(), RutaBG, RutaG));
            //Reemplazar los campos seleccionados
            objGrupo.SetMiembros(Integer.parseInt(tfGNMiembro.getText()));
            objGrupo.SetDescripcion(tfGNDescripcion.getText());
            //Actualizar
            String busqueda = objSecuencial.busqueda(false, Usuario.getUser()+"|"+cbGrupos.getSelectedItem(), RutaBG, RutaG);
            try {
                objSecuencial.Actualizar(busqueda, objGrupo.GetRegistro());
                JOptionPane.showMessageDialog(null,"Datos Modificado", "Modificacion", WIDTH);
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoGrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGModificarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Regresar al form administracion
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void AgregarAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAmigosActionPerformed
        // TODO add your handling code here:
        GrupoAmigos a = new GrupoAmigos(listaGrupos,Usuario);
        a.setVisible(true);
                
    }//GEN-LAST:event_AgregarAmigosActionPerformed

    private void cbGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGruposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGruposActionPerformed

    private void ActualizarOpciones()
    {
        cbGrupos.removeAllItems();
        cbGrupos2.removeAllItems();
        String[] Datos = objSecuencial.busqueda(true, Usuario.getUser(), RutaBG, RutaG).split(Pattern.quote("|"));
        if(Datos[0] != "")
        {
            for (int i = 0; i < Datos.length -1; i++) {
                String[] Grupos = Datos[i].split(Pattern.quote(","));
                cbGrupos.addItem(Grupos[1]);
                cbGrupos2.addItem(Grupos[1]);
                listaGrupos.add(i,Grupos[1]);
            }
        }
    }
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
            java.util.logging.Logger.getLogger(MantenimientoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarAmigos;
    private javax.swing.JButton btnGCrear;
    private javax.swing.JButton btnGEliminar;
    private javax.swing.JButton btnGModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbGrupos;
    private javax.swing.JComboBox<String> cbGrupos2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tfGDescripcion;
    private javax.swing.JTextField tfGMiembros;
    private javax.swing.JTextArea tfGNDescripcion;
    private javax.swing.JTextField tfGNMiembro;
    private javax.swing.JTextField tfGNombre;
    // End of variables declaration//GEN-END:variables
}
