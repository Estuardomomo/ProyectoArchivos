/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import Ventanas.User;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author jsala
 */
public class FileMethods {
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public void createFolderC(String path){
        
        File folderC = new File(path);
        if (!folderC.exists()) {
            JOptionPane.showMessageDialog(null, "A folder will be creat on Disck C for program operation.", "Operation", WIDTH);
            folderC.mkdirs();
        }
    }
    
    public void createBackUpFolder(String path){
        File folderC = new File(path);
        if (!folderC.exists()) {
            folderC.mkdirs();
        }
        
    }
    public void createFile(String fileName){
        File userFile = new File(fileName); 
        if (userFile.exists()) {
            //return false; //ya existe
        }else{
            try{
                userFile.createNewFile();
                //return true; //lo crea sin problemas
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.toString());
                //return false; //hubo un error al crear
            }
            
        }
            
        
    }
    
    public void creatPhotoFolder(){
        File photo = new File("C:\\MEIA\\fotografía");
        if (!photo.exists()) {
            photo.mkdirs();
        }
    }
    public static boolean validateEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
    public boolean loginMethod(String name, char[] password, String path, User newUser){
        File filee = new File(path);
        FileReader lecturaArchivo;
            try
            {
                lecturaArchivo = new FileReader(filee);
                BufferedReader readFile = new BufferedReader(lecturaArchivo);
                
                String line ="";
               
                try
                {
                    line = readFile.readLine();
                    String[] values;
                   
                    while (line != null) {
                        if (line !="") {
                            values = line.split(",");
                            if (values[0] == name && isPasswordCorrect(password, values[3])) { //son iguales, así que se crea el objeto user
                                newUser.setUser(values[0]);
                                newUser.setName(values[1]);
                                newUser.setLastName(values[2]);
                                newUser.setPassword(convertPassword(values[3]));
                                newUser.setRol(values[4]);
                                newUser.setDate(values[5]);
                                newUser.setEmail(values[6]);
                                newUser.setCelNumber(Integer.parseInt(values[7]));
                                newUser.setPhotoPath(values[8]);
                                newUser.setDescription(values[9]);
                                newUser.setStatus(Integer.parseInt(values[10]));
                                //Se asigna valores al objeto usuario actual para poder manejarlo en los siguientes forms
                               break;
                            }
                            
                            
                        }
                        line = readFile.readLine();
                    }
                    lecturaArchivo.close();
                    readFile.close();
                    return true;
                                    }
                catch(IOException ex){
                    
                    return false;
                }             
            }
            catch(FileNotFoundException e)
            {
               
                return false;            
            }         
       
    }
    
    public boolean fileSizeNotZero(String path){
        File b = new File(path);
        if (b.length() ==0) {
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean isPasswordCorrect(char[] inputPassword, String correctPassword){
        char[] password = correctPassword.toCharArray(); //creo que separa por caracteres el string
        
        if (inputPassword.length != password.length) {
            return false;
        }else{
            return Arrays.equals(inputPassword, password);
        }
        //leí que llena de ceros el correctPassword pero por el momento no sé porque
    }
    public char[] convertPassword(String filePassword){
        char[] password = filePassword.toCharArray();
        return password;
    }
    
    public boolean writeOnUserFile(String path, String user, String name, String lastName, char[] password, int rol, String birthday, String email, int celnumber, String photoPath, String description, int status){
        File file = new File(path);
        try
            {
                FileWriter write = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(write);
                String toWrite = content(user, name, lastName, password, Integer.toString(rol), birthday, email, Integer.toString(celnumber), photoPath, description, Integer.toString(status));
                bw.write( toWrite + System.getProperty("line.separator"));
                bw.close();
                write.close();
                return true;
            }
            catch(IOException e)
            {
                return false;
            }
    }
    
    public boolean writeOnBitacora(String path, String filePath,String user, String date){
        File file = new File(path);
        try
            {
                FileWriter write = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(write);
                
                bw.write( filePath +"," + user +","+date+ System.getProperty("line.separator"));
                bw.close();
                write.close();
                return true;
            }
            catch(IOException e)
            {
                return false;
            }
     
    }
    private String content(String user, String name, String lastName, char[] password, String rol, String birthday, String email, String celnumber, String photoPath, String description, String status){
        return user + "," +name + "," + lastName + "," + password.toString() + "," + rol +"," + birthday + "," + email + "," + celnumber +"," + photoPath + "," + description + "," + status;
        
    }

    
    
}
