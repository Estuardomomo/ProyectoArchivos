/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

/**
 *
 * @author User_Len
 */
public class Secuencial {
//Atributos
FileMethods Metodos = new FileMethods();
String RutaU = "c:\\MEIA\\Usuarios.txt";
String RutaBU = "c:\\MEIA\\BitácoraUsuarios.txt";
String DescriptorU = "c:\\MEIA\\DescriptorU.txt";
String DescriptorBU = "c:\\MEIA\\DescriptorBU.txt";
String RutaA = "c:\\MEIA\\Lista_Amigos.txt";
String RutaBA = "c:\\MEIA\\BitácoraAmigos.txt";
String DescriptorA = "c:\\MEIA\\DescriptorA.txt";
String DescriptorBA = "c:\\MEIA\\DescriptorBA.txt";

//Constructor
public Secuencial(String bitácora)
{
    Metodos.createFile(bitácora);
}
//Busqueda ===========================================================================================================================
//Busqueda - publica
    //Función que devuelve la ruta y el número de linea donde se econtró la cadena
    public String busqueda(Boolean acumulativa, String cadena, String rutaBitacora, String rutaMaestro)
    {
        //Primero buscamos en la bitácora
        String Salida = busquedaInterna(acumulativa, rutaBitacora,cadena);
        if( Salida != "|0")
        {
            return Salida;
        }
        //Luego buscamos en los archivos maestros
        Salida = busquedaInterna(acumulativa, rutaMaestro,cadena);
        if(Salida != "|0")
        {
            return Salida;
        }
        return Salida;
    }
//Busqueda - privada
//Busca una cadena en la ruta especificada
    private String busquedaInterna(Boolean acumulativa, String ruta, String cadena)
    {
        String Salida = "";
        try
        {
            //Si el archivo existe, lo leerá una linea a la vez
            File Archivo = new File(ruta);
            if(Archivo.exists())
            {
            int númLinea = 0;
            RandomAccessFile LeerArchivo = new RandomAccessFile(Archivo,"rw");
            String Linea = LeerArchivo.readLine();
            String[] values;
            while(Linea != null)  //Leemos linea por linea hasta el final.
            {
                if(!"".equals(Linea))
                {
                    //Si es una busqueda de usuario
                    if(ruta.equals(RutaU) || ruta.equals(RutaBU))
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
                        //Si es busqueda acumulativa o directa.
                        if(acumulativa)
                        {
                            //Si es acumulativa concatenar todos los resultados posibles.
                            if((cadena.equals(newUser.getUser()) || cadena.equals(newUser.getName()) || cadena.equals(newUser.getLastName())) & !(newUser.getStatus()==0))
                            {
                                Salida += newUser.getUser() + "," + newUser.getName() + "," + newUser.getLastName() + "|";
                            }
                        }
                        else
                        {
                            //Si es una busqueda directa, obtener la ubicación del resultado.
                            if(cadena.equals(newUser.getUser()) & !(newUser.getStatus()==0))
                            {
                                Salida = ruta+"|" + LeerArchivo.getFilePointer()+"|"+númLinea;   
                            }
                        }
                    }
                    //Si es una busqueda de solicitud de amistad.
                    else if(ruta.equals(RutaA) || ruta.equals(RutaBA))
                    {
                        
                    }
                }
                númLinea=(int)LeerArchivo.getFilePointer();
                Linea=LeerArchivo.readLine();
            }
            //Cerrar el lector utilizado
            LeerArchivo.close();
            }
        }
        catch(Exception ex){}
        //Si no se encontró nada, colocar el formato determinado.
        if(Salida.equals(""))
        {
            Salida = "|0";
        }
        return Salida;
    }    
    
    
    
    
    
    
    
    
    
    
//REORGANIZAR=====================================================================================================================    
    //Reorganiza los archivos para la inserción.
    private void reorganizar(int max, String rutaMaestro, String rutaBitacora )
    {
        File ArchivoMaestro = new File(rutaMaestro);
        File Bitácora = new File(rutaBitacora);
        //Si existe un maestro, traslada los datos y borralo
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
                Path ruta = FileSystems.getDefault().getPath(rutaMaestro);
                Files.delete(ruta);
                reorganizar(max, rutaMaestro, rutaBitacora);
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
            String[] Registros = Colección.split(Pattern.quote("|"));
            int[] Posición = new int[númLineas];
            for (int i = 0; i < númLineas; i++) {
                Posición[i] = i;
            }
            //Obtener el orden de los registros
            for (int j = 1; j <= Registros.length; j++) {
                for (int k = 0; k < Registros.length -j; k++) {
                    if(Registros[k].compareTo(Registros[k+1]) > 0)
                    {
                        String aux = Registros[k];
                        Registros[k] = Registros[k+1];
                        Registros[k+1] = aux;
                        int temp = Posición[k];
                        Posición[k] = Posición[k+1];
                        Posición[k+1] = temp;
                    }
                }
            }
            //Leer, escribir, leer, escribir, leer...
            Metodos.createFile(rutaMaestro);
            FileWriter escribir = new FileWriter(ArchivoMaestro);
            for (int i = 0; i < Posición.length; i++) {
                lector = new FileReader(Bitácora);
                leerArchivo = new BufferedReader(lector);
                for (int j = 0; j < Posición[i]; j++) {
                 leerArchivo.readLine();
                }
                escribir.write(leerArchivo.readLine()+"\r\n");
                ActualizarDescriptor(1,Registros[i]);
                lector.close();
                leerArchivo.close();
            }
            escribir.close();
            Path ruta = FileSystems.getDefault().getPath(rutaBitacora);
            Metodos.createFile(rutaBitacora);
            File Desc = new File("c:\\MEIA\\DescriptorB.txt");
            Desc.delete();
        }
        catch(IOException e){}
        }
    }
}
