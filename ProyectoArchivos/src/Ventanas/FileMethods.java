/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import java.awt.Component;
import java.awt.Desktop;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    {}
    //Cadena que hizo Jackie, creo que para verificar el formato del correo
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //Crear una nueva carpeta
    public void createFolder(String path){
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }
    //Crear un nuevo archivo
    public void createFile(String fileName){
        File userFile = new File(fileName); 
         try{
                userFile.createNewFile();
          }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.toString());
           }
    }
    //Booleano que verifica el formato del correo
    public boolean validateEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }
    //Revisa que el usuario y contraseña ingresadas sean válidas.
    public boolean loginMethod(String name, String password, String path, User newUser){
        File filee = new File(path);
        FileReader lecturaArchivo;
            try
            {
                lecturaArchivo = new FileReader(filee);
                BufferedReader readFile = new BufferedReader(lecturaArchivo);   
                String line = "";
                try
                {
                   line = readFile.readLine();
                   String[] values;
                   String contraseñaEncriptada = EncriptadoMD5(password);
                    while (line != null) {
                        if (line !="") {
                            values = line.split("\\|");
                            newUser.setUser(values[0]);
                                newUser.setName(values[1]);
                                newUser.setLastName(values[2]);
                                newUser.setPassword(contraseñaEncriptada);
                                newUser.setRol(values[4]);
                                newUser.setDate(values[5]);
                                newUser.setEmail(values[6]);
                                newUser.setCelNumber(Integer.parseInt(values[7]));
                                newUser.setPhotoPath(values[8]);
                                newUser.setDescription(values[9]);
                                newUser.setStatus(Integer.parseInt(values[10]));
                            if (CompareStrings(name, newUser.getUser()) && CompareStrings(contraseñaEncriptada, values[3])) { //son iguales, así que se crea el objeto user
                                
                                //Se asigna valores al objeto usuario actual para poder manejarlo en los siguientes forms
                               return true;
                            }
                            
                            
                        }
                        line = readFile.readLine();
                    }
                    lecturaArchivo.close();
                    readFile.close();
                    return false;
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
    //Revisa que existan datos en un archivo.
    public boolean fileSizeNotZero(String path){
        File b = new File(path);
        if (b.length() == 0) {
            return false;
        }
        else{
            return true;
        }
    }
    //Función que compara la contraseña ingresada con la guardada en el archivo.
    public boolean CompareStrings(String inputPassword, String correctPassword){
        String b = inputPassword.replaceAll(" ", "");
        int ib= b.length();
        String n = correctPassword.replaceAll(" ", "");
        int in= n.length();
        char[] a = n.toCharArray();
        if (b.length() != n.length()) {
            return false;
        }else{
            return inputPassword.equals(correctPassword);
        }
        
    }
    //Convierte una cadena a un arreglo de bytes
    //public char[] convertPassword(String filePassword){
      //  char[] password = filePassword.toCharArray();
      //  return password;
    //}
   //Función que escribe en el archivo de usuarios 
    public void inscribirUsuario(String user, String name, String lastName, String password, String rol, String birthday, String email, int celnumber, String photoPath, String description, int status){
        File archivo = new File("c:\\MEIA\\Bitácora.txt");
        try
            {
                User newUser=new User();
                newUser.setUser(user);
                newUser.setName(name);
                newUser.setLastName(lastName);
                newUser.setPassword(password);
                newUser.setRol(rol);
                newUser.setDate(birthday);
                newUser.setEmail(email);
                newUser.setCelNumber(celnumber);
                newUser.setPhotoPath(photoPath);
                newUser.setDescription(description);
                newUser.setStatus(status);
                int límite = maxRegistros();
                String[] Registros = conteoRegistros(0).split("|");
                int cantidadRegistros = Integer.parseInt(Registros[0]) + Integer.parseInt(Registros[2]);
                if(cantidadRegistros <= límite)
                {
                    FileWriter Escribir = new FileWriter(archivo, true);
                    Escribir.write(newUser.getRegistro());
                    Escribir.close();
                }
                else
                {
                    reorganizar();
                    FileWriter Escribir = new FileWriter(archivo, true);
                    Escribir.write(newUser.getRegistro());
                    Escribir.close();
                    
                }
            }
            catch(IOException e)
            {
            }
    }
    //Reorganiza los archivos para la inserción.
    private void reorganizar()
    {
        File Usuarios = new File("c:\\MEIA\\Usuarios.txt");
        if(Usuarios.exists())
        {
            //Traspaso información, borro usuarios y llamo organizar;
        }
        else
        {
            
            //Ordeno, creo usuario.txt y escribo.
        }
    }
      //Obtiene el límite de registros de la bitácora.
    private int maxRegistros()
    {
        int Salida = 0;
        try
        {
            File Descriptor = new File("c:\\MEIA\\DescriptorB.txt");
            FileReader lector = new FileReader(Descriptor);
            BufferedReader LeerArchivo = new BufferedReader(lector);
            for (int i = 0; i < 10; i++) {
                LeerArchivo.readLine();
            }
            String[] Linea = LeerArchivo.readLine().split(" ");
            Salida = Integer.parseInt(Linea[1]);
        }
        catch(IOException e){}
        return Salida;
    }
      //Obtener la cantidad de registros activos e inactivos de un archivo.
    private String conteoRegistros(int j)
    {
        int contadorActivo = 0;
        int contadorInactivo = 0;
        try
        {
            File Archivo;
        if(j == 0)
        {
            Archivo = new File("c:\\MEIA\\Bitácora.txt");
        }
        else
        {
            Archivo = new File("c:\\MEIA\\Usuarios.txt");
        }
        FileReader lector = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(lector);
        String Linea = leerArchivo.readLine();
        String[] Registro;
        while(Linea != null)
        {
            Registro = Linea.split(Pattern.quote("|"));
            if("1".equals(Registro[10]))
            {
                contadorActivo++;
            }
            else
            {
                contadorInactivo++;
            }
            Linea = leerArchivo.readLine();
        }
        lector.close();
        leerArchivo.close();
        }
        catch(IOException ex)
        {
        }
        contadorActivo++;
        return contadorActivo + "|" + contadorInactivo;
    }
    //Escribe en la bitácora de registros de copias de seguridad.
    public boolean writeOnBitacora(String path, String filePath,String user, String date){
        File file = new File(path);
        try
            {
                FileWriter write = new FileWriter(file, true);
                write.write( filePath +"|" + user +"|"+date+ System.getProperty("line.separator"));
                write.close();
                return true;
            }
            catch(IOException e)
            {
                return false;
            }
     
    }
    //Procedimiento que permite seleccionar una nueva fotografía de perfíl
    public String fotoPerfil(Component a)
    {
     String nuevaRuta = "";
     JFileChooser dialog = new JFileChooser();
     FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "png","jpg");
     File ficheroImagen;
     dialog.setFileFilter(filtro);
     if(dialog.showOpenDialog(a) == JFileChooser.APPROVE_OPTION)
     {
         ficheroImagen = dialog.getSelectedFile();
         nuevaRuta = ficheroImagen.getPath();
     }
     return nuevaRuta;
    }

    //Encriptar contraseña
    public String EncriptadoMD5(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(password.getBytes());
            StringBuffer encrypt = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
            encrypt.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }       
        return encrypt.toString();
        }catch (java.security.NoSuchAlgorithmException e) {
        }
               
        return null;         
    }
    //Método para abrir un archivo desde la aplicación de Java
    public void AbrirArchivo(String ruta){
        try{
            File file = new File(ruta);
            Desktop.getDesktop().open(file);
        }catch(IOException ex){
            //Se generó un error
        }
    }
//Busca una cadena en la ruta especificada
    private String busquedaInterna(String ruta, String cadena)
    {
        String Salida = "|0";
        try
        {
            //Si el archivo existe, lo leerá una linea a la vez
            File Archivo = new File(ruta);
            if(Archivo.exists())
            {
            int númLinea = 0;
            FileReader lector = new FileReader(Archivo);
            RandomAccessFile LeerArchivo = new RandomAccessFile(Archivo,"rw");
//          BufferedReader LeerArchivo = new BufferedReader(lector);
            String Linea = LeerArchivo.readLine();
            String[] values;
            while(Linea != null) //Leemos linea por linea hasta el final.
                    {
                        
                        if(!"".equals(Linea))
                        {
                            User newUser=new User();
                            values = Linea.split(Pattern.quote("|"));
                            newUser.setUser(values[0]);
                            newUser.setName(values[1]);
                            newUser.setLastName(values[2]);
                            newUser.setPassword(values[3]);
                            newUser.setRol(values[4]);
                            newUser.setDate(values[5]);
                            newUser.setEmail(values[6]);
                            newUser.setCelNumber(Integer.parseInt(values[7]));
                            newUser.setPhotoPath(values[8]);
                            newUser.setDescription(values[9]);
                            newUser.setStatus(Integer.parseInt(values[10]));
                            String k=newUser.getUser();
                            int s=newUser.getStatus();
                            
                            //Si el usuario es correcto y no se ha dado de baja
                            if(cadena.equals(k) & !(s==0))
                            {
                                //Lo encontró
                                Salida = ruta+"|" + LeerArchivo.getFilePointer()+"|"+númLinea;
                            }
                        }
                        númLinea=(int)LeerArchivo.getFilePointer();
                        Linea=LeerArchivo.readLine();
                        
                    }
                    //IMPORTANTE: cerrar los archivos después de utilizarlos
                    lector.close();
                    LeerArchivo.close();
            }
        }
        catch(Exception ex){}
        return Salida;
    }
    //Función que devuelve la ruta y el número de linea donde se econtró la cadena
    public String busqueda(String cadena)
    {
        //Primero buscamos en la bitácora
        String Salida = busquedaInterna("c:\\MEIA\\Bitácora.txt",cadena);
        if( Salida != "|0")
        {
            return Salida;
        }
        //Luego buscamos en los archivos maestros
        Salida = busquedaInterna("c:\\MEIA\\Usuarios.txt",cadena);
        if(Salida != "|0")
        {
            return Salida;
        }
        Salida = busquedaInterna("c:\\MEIA\\Maestro.txt",cadena);
        return Salida;
    }
    //Elimina un nombre de usuario especificado
    public void Eliminar(String cadena) throws IOException
    {
        FileMethods metodos= new FileMethods();
        
        String[]numeros=cadena.split(Pattern.quote("|")) ;
        File archivo = new File(numeros[0]);      
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile(archivo,"rw");
            raf.seek(Integer.parseInt(numeros[1])-3);
            raf.writeBytes("0");
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Actualizar(String usuario,String registroactualizado) throws IOException
    {
        FileMethods metodos= new FileMethods();
        
        String[]numeros=usuario.split(Pattern.quote("|")) ;
        File archivo = new File(numeros[0]);      
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile(archivo,"rw");
            raf.seek(Integer.parseInt(numeros[2]));
            raf.writeBytes(registroactualizado);
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Actualizar el respectivo descriptor tras una inserción
    public void actualizarDescriptor(int i,String cadena)
    {
        try
        {
          switch(i)
        {
            case 0:
            {
                File descriptor = new File("c:\\MEIA\\DescriptorB.txt");
                if(!descriptor.exists())
                {
                    createFile("c:\\MEIA\\DescriptorB.txt");
      
                    FileWriter escritor = new FileWriter(descriptor);
                    Date fecha = new Date();
                    escritor.write("Archivo: c:\\MEIA\\DescriptorB.txt\r\nDescripción: Bitácora_de_usuarios\r\nTipo: archivo_de_datos\r\nOrganización: Apilo\r\nAutor: "+cadena+ "\r\nCreado: "+ fecha+ "\r\nModificado: "+fecha+"\r\nSeparador_campos: |\r\nRegistros_activos: 1\r\nRegistros_inactivos: 0\r\nRegistros_máximo: 10");
                    escritor.close();
                }
                else
                {
                    String[] Registros = conteoRegistros(0).split("|");
                    Date Fecha = new Date();
                    RandomAccessFile raf = new RandomAccessFile(descriptor,"rw");
                    for (int j = 0; j < 6; j++) {
                       raf.readLine();
                    }
                    raf.writeBytes("Modificado: "+Fecha+"\r\n");
                    raf.readLine();
                    raf.writeBytes("Registros_activos: "+Registros[0]+"\r\n");
                    raf.writeBytes("Registros_inactivos: "+Registros[2] );
                    raf.close();
                }
                    break;
            }
            case 1:
            {
                File descriptor = new File("c:\\MEIA\\DescriptorA.txt");
                FileWriter escritor;
                if(!descriptor.exists())
                {
                    Date fecha = new Date();
                    escritor = new FileWriter(descriptor);
                    escritor.write("Archivo: C://MEIA/Usuario.txt\r\nDescripción: Usuarios_del_sistema.\r\nTipo: archivo_de_datos\r\nOrganización: Secuencial\r\nAutor: "+cadena+"\r\nCreado: "+fecha+"\r\nModificado: "+fecha+"\r\nSeparador_campos: |\r\nLlave: Usuario\r\nOrden: Ascendente\r\nRegistros_activos: 1\r\nRegistros_inactivos: 0");
                    escritor.close();   
                }
                else
                {
                    String[] Registros = conteoRegistros(1).split("|");
                    Date Fecha = new Date();
                    RandomAccessFile raf = new RandomAccessFile(descriptor,"rw");
                    for (int j = 0; j < 6; j++) {
                       raf.readLine();
                    }
                    raf.writeBytes("Modificado: "+Fecha+"\r\n");
                    raf.readLine();
                    raf.writeBytes("Registros_activos: "+Registros[0]+"\r\n");
                    raf.writeBytes("Registros_inactivos: "+Registros[2] );
                    raf.close();
                }
                break;
            }
        }
        }
        catch(IOException e)
        {
            
        }
    }
}
