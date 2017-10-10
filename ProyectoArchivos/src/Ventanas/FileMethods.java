/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import static Ventanas.Backup.CPath;
import static Ventanas.Backup.LOGGER;
import java.awt.Component;
import java.awt.Desktop;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
    static final Logger LOGGER = Logger.getAnonymousLogger();
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
    public boolean loginMethod(String nombre, String contraseña, User newUser)
    {
        File ArchivoMaestro = new File("c:\\MEIA\\Usuarios.txt");
        if(ArchivoMaestro.exists())
        {
            if(loginMethodInterno(nombre,contraseña,"c:\\MEIA\\Bitácora.txt",newUser))
            {
                return true;
            }
            else
            {
                return loginMethodInterno(nombre,contraseña,"c:\\MEIA\\Usuarios.txt",newUser);
            }   
        }
        else
        {
            return loginMethodInterno(nombre,contraseña,"c:\\MEIA\\Bitácora.txt",newUser);
        }
    }
    //Revisa que el usuario y contraseña ingresadas sean válidas.
    private boolean loginMethodInterno(String name, String password, String path, User newUser){
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
                    reorganizar(límite);
                    ActualizarDescriptor(0,user);
                    ActualizarDescriptor(1,"");
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
    private void reorganizar(int max)
    {
        File ArchivoMaestro = new File("c:\\MEIA\\Usuarios.txt");
        File Bitácora = new File("c:\\MEIA\\Bitácora.txt");
        if(ArchivoMaestro.exists())
        {
            try
            {
                RandomAccessFile raf = new RandomAccessFile(Bitácora,"rw");
                for (int i = 0; i < max; i++) {
                    raf.readLine();
                }
                FileReader lector = new FileReader(ArchivoMaestro);
                BufferedReader leerArchivo = new BufferedReader(lector);
                String Linea = leerArchivo.readLine();
                while(Linea != null)
                {
                    raf.writeBytes(Linea+"\r\n");
                    Linea = leerArchivo.readLine();
                }
                lector.close();
                leerArchivo.close();
                raf.close();
                ArchivoMaestro.delete();
                reorganizar(max);
            }catch(IOException ex){}
        }
        else
        {
            try
        {
            //Obtener los nombres de usuario.
            FileReader lector = new FileReader(Bitácora);
            BufferedReader leerArchivo = new BufferedReader(lector);
            String linea = leerArchivo.readLine();
            String Colección = "";
            int númLineas = 0;
            while(linea != null)
            {
                númLineas++;
                String[] Datos = linea.split(Pattern.quote("|"));
                if("1".equals(Datos[10]))
                {
                    Colección += Datos[0] + "|";   
                }
                linea = leerArchivo.readLine();
            }
            lector.close();
            leerArchivo.close();
            String[] Usuarios = Colección.split(Pattern.quote("|"));
            int[] Posición = new int[númLineas];
            for (int i = 0; i < númLineas; i++) {
                Posición[i] = i;
            }
            //Obtener el orden de los registros
            for (int j = 1; j <= Usuarios.length; j++) {
                for (int k = 0; k < Usuarios.length -j; k++) {
                    if(Usuarios[k].compareTo(Usuarios[k+1]) > 0)
                    {
                        String aux = Usuarios[k];
                        Usuarios[k] = Usuarios[k+1];
                        Usuarios[k+1] = aux;
                        int temp = Posición[k];
                        Posición[k] = Posición[k+1];
                        Posición[k+1] = temp;
                    }
                }
            }
            //Leer, escribir, leer, escribir, leer...
            createFile("c:\\MEIA\\Usuarios.txt");
            FileWriter escribir = new FileWriter(ArchivoMaestro);
            for (int i = 0; i < Posición.length; i++) {
                lector = new FileReader(Bitácora);
                leerArchivo = new BufferedReader(lector);
                for (int j = 0; j < Posición[i]; j++) {
                 leerArchivo.readLine();
                }
                escribir.write(leerArchivo.readLine()+"\r\n");
                ActualizarDescriptor(1,Usuarios[i]);
                lector.close();
                leerArchivo.close();
            }
            escribir.close();
            Bitácora.delete();
            createFile("c:\\MEIA\\Bitácora.txt");
            File Desc = new File("c:\\MEIA\\DescriptorB.txt");
            Desc.delete();
        }
        catch(IOException e){}
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
            contadorActivo--;
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
    public User readUser(String busqueda){
        FileMethods metodos= new FileMethods();
        User newUser=new User();
        String[]numeros=busqueda.split(Pattern.quote("|")) ;
        File archivo = new File(numeros[0]);      
        RandomAccessFile raf;
        try {
            raf = new RandomAccessFile(archivo,"rw");
            raf.seek(Integer.parseInt(numeros[2]));
            String Linea=raf.readLine();
            raf.close();
            
            String[] values = Linea.split(Pattern.quote("|"));
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
            return newUser;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
            return newUser;
        } catch (IOException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
            return newUser;
        }
        
    }
    //Actualizar el respectivo descriptor tras una inserción
    public void ActualizarDescriptor(int i,String cadena)
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
                    raf.readLine();
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
    
     //Metodo para copiar todos los archivos a una nueva ruta
    private void CopiarArchivosCarpeta(String origin, String actual){
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
            
    }
    
    public void CopiarCarpeta(String rutaCarpeta, String rutaCopiaCarpeta){
        File origin = new File(rutaCarpeta);
        String[] paths = origin.list();
        for (int i = 0; i < paths.length; i++) {
            CopiarArchivosCarpeta(rutaCarpeta + paths[i] ,rutaCopiaCarpeta + paths[i]);
        }
    }
    public boolean CopiarUnArchivo(String rutaArchivo, String rutaCopiaArchivo){
        try{
           
           FileInputStream fis = new FileInputStream(rutaArchivo); //inFile -> Archivo a copiar OJO El archivo ya debe venir con los \\ finales 
           File archivoOriginal = new File(rutaArchivo);           //es decir c:\\user\\hackerman\\texto.txt\\
           FileOutputStream fos = new FileOutputStream(rutaCopiaArchivo+ archivoOriginal.getName()); //outFile -> Copia del archivo
           FileChannel inChannel = fis.getChannel(); 
           FileChannel outChannel = fos.getChannel();
           inChannel.transferTo(0, inChannel.size(), outChannel);
           fis.close(); 
           fos.close();
           return true;
           
       }catch (IOException ioe) {
           return false;
       }
    }
    
}
