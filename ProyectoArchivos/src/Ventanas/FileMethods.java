/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;
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
    
    public void creatFolderC(){
        File folderC = new File("C:\\MEIA");
        if (!folderC.exists()) {
            JOptionPane.showMessageDialog(null, "A folder will be creat on Disck C for program operation.", "Operation", WIDTH);
            folderC.mkdirs();
        }
    }
    
    
}
