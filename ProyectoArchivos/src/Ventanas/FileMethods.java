/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.Component;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author jsala
 */
public class FileMethods {
    
    //Constructor
    public FileMethods()
    {
        crearFolderC();
        crearUsuarios();
    }
    public void crearFolderC(){
        File folderC = new File("C:\\MEIA");
        if (!folderC.exists()) {
            JOptionPane.showMessageDialog(null, "A folder will be creat on Disck C for program operation.", "Operation", WIDTH);
            folderC.mkdirs();
        }
    }
    public void crearUsuarios()
    {
        try
        {
         File Usuarios = new File("C:\\MEIA\\Usuarios.txt");
         if(Usuarios.createNewFile())
         {}
        }
        catch(IOException e)
        {
        }
    }
    public String fotoPerfil(Component a)
    {
        String ruta = "";
        JFileChooser dialog = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "png", "jpg");
        File ficheroImagen;
        dialog.setFileFilter(filtro);
        
        if(dialog.showOpenDialog(a) == JFileChooser.APPROVE_OPTION)
        {
            ficheroImagen = dialog.getSelectedFile();
            ruta = ficheroImagen.getPath();
        }
        return ruta;
    }
    
}
