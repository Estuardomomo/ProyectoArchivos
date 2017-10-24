/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author keviu
 */
public class JButtonTableExample extends JFrame {

  public JTable table;
  public JButtonTableExample(String datos,int num) {
    super("JButtonTable Example");

    DefaultTableModel dm = new DefaultTableModel();
    Object[][] filas ;
    filas=Registro(datos,num);
    
    dm.setDataVector(filas, new Object[] { "Button", "String","" });

    table = new JTable(dm);
    table.getColumn("Button").setCellRenderer(new ButtonRenderer());
    table.getColumn("Button").setCellEditor(
        new ButtonEditor(new JCheckBox()));
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
    setSize(400, 100);
    setVisible(false);
    
  }
  public Object[][] Registro(String datos,int tabla)
  { 
    String[]nume=datos.split(Pattern.quote(","));
    FileMethods metodos= new FileMethods();
    Object[][] filas = null;
    if(tabla==1){
        filas =new Object[nume.length][4];
     for (int j = 0; j < nume.length; j++) {
         String busqueda=metodos.busqueda(nume[j]);
          User auxiliar=new User();
          auxiliar =metodos.readUser(busqueda);
         filas[j][0]="Enviar solicitud";
         filas[j][1]=auxiliar.getUser();
         filas[j][2]=auxiliar.getName();
         filas[j][3]=auxiliar.getLastName();
     
      }
     
    }
    else if(tabla==1){
        
    }
   
    return filas;
     
  }
  public JTable gettable() {
    return table;
  }
    class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}

/**
 * @version 1.0 11/09/98
 */

class ButtonEditor extends DefaultCellEditor {
  protected JButton button;

  private String label;
  private int row;
  private boolean isPushed;

  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      // 
      // 
        
        int filaseleccionada = table.getSelectedRow();
        String bastidor = (String)table.getValueAt(filaseleccionada, 0);
        String color = (String)table.getValueAt(filaseleccionada, 1);
        String matricula = (String)table.getValueAt(filaseleccionada, 2);
        String marca = (String)table.getValueAt(filaseleccionada, 3);
      JOptionPane.showMessageDialog(button, label + ": Ouch!");
      System.out.println(bastidor + ": Ouch!"+matricula);
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}
        
        
}
