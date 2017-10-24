/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
//Insertar=================================================================================================================================
public void Insertar(String rutaBitacora, User usuario, Solicitud amistad)
{
    try
    {
        if(rutaBitacora == RutaBU)
        {
            int límite = maxRegistros(DescriptorBU);
            String[] Registros = conteoRegistros(RutaBU).split(Pattern.quote("|"));
            int cantidadRegistros = Integer.parseInt(Registros[0]) + Integer.parseInt(Registros[1]);
            if(cantidadRegistros < límite)
            {
                File archivo = new File(RutaBU);
                FileWriter Escribir = new FileWriter(archivo, true);
                Escribir.write(usuario.getRegistro());
                Escribir.close();
            }
            else
            {
                reorganizar(límite, RutaU, RutaBU);
                Metodos.createFile(RutaBU);
                File archivo = new File(RutaBU);
                FileWriter Escribir = new FileWriter(archivo, true);
                Escribir.write(usuario.getRegistro());
                Escribir.close();
            }
            ActualizarDescriptor(DescriptorBU, usuario.getUser());
            ActualizarDescriptor(DescriptorU, "");
        }
        else if(rutaBitacora == RutaBA)
        {
            int límite = maxRegistros(DescriptorBA);
            String[] Registros = conteoRegistros(RutaBA).split(Pattern.quote("|"));
            int cantidadRegistros = Integer.parseInt(Registros[0]) + Integer.parseInt(Registros[1]);
            if(cantidadRegistros < límite)
            {
                File archivo = new File(RutaBA);
                FileWriter Escribir = new FileWriter(archivo, true);
                Escribir.write(usuario.getRegistro());
                Escribir.close();
            }
            else
            {
                reorganizar(límite, RutaA, RutaBA);
                Metodos.createFile(RutaBA);
                File archivo = new File(RutaBA);
                FileWriter Escribir = new FileWriter(archivo, true);
                Escribir.write(amistad.GetRegistro());
                Escribir.close();
            }
            ActualizarDescriptor(DescriptorBA, amistad.GetEmisor());
            ActualizarDescriptor(DescriptorA, "");
        }
    }catch(IOException e){}
}
  //Obtiene el límite de registros de la bitácora.
    private int maxRegistros(String direccion)
    {
        int Salida = 0;
        try
        {
            File Descriptor = new File(direccion);
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
    private String conteoRegistros(String Direccion)
    {
        int contadorActivo = 0;
        int contadorInactivo = 0;
        try
        {
            File Archivo = new File(Direccion);
        FileReader lector = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(lector);
        String Linea = leerArchivo.readLine();
        String[] Registro;
        while(Linea != null)
        {
            Registro = Linea.split(Pattern.quote("|"));
            if("1".equals(Registro[Registro.length -1]))
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
        return contadorActivo + "|" + contadorInactivo;
    }
        //Actualizar el respectivo descriptor tras una inserción
    public void ActualizarDescriptor(String direccion,String cadena)
    {
        try
        {
            File descriptor = new File(direccion);
            if(!descriptor.exists())
            {
                Metodos.createFile(direccion);
                FileWriter escritor = new FileWriter(descriptor);
                Date fecha = new Date();
                if(direccion.equals(DescriptorBU))
                {
                    escritor.write("Archivo: c:\\MEIA\\BitácoraUsuarios.txt\r\nDescripción: Bitácora_de_usuarios\r\nTipo: archivo_de_datos\r\nOrganización: Apilo\r\nAutor: "+cadena+ "\r\nCreado: "+ fecha+ "\r\nModificado: "+fecha+"\r\nSeparador_campos: |\r\nRegistros_activos: 1\r\nRegistros_inactivos: 0\r\nRegistros_máximo: 3");
                }
                else if(direccion.equals(DescriptorU))
                {
                    escritor.write("Archivo: C://MEIA/Usuarios.txt\r\nDescripción: Usuarios_del_sistema.\r\nTipo: archivo_de_datos\r\nOrganización: Secuencial\r\nAutor: "+cadena+"\r\nCreado: "+fecha+"\r\nModificado: "+fecha+"\r\nSeparador_campos: |\r\nLlave: Usuario\r\nOrden: Ascendente\r\nRegistros_activos: 1\r\nRegistros_inactivos: 0");
                }
                else if(direccion.equals(DescriptorBA))
                {
                    escritor.write("Archivo: c:\\MEIA\\BitácoraAmigos.txt\r\nDescripción: Bitácora_de_solicitudes_de_amistad\r\nTipo: archivo_de_datos\r\nOrganización: Apilo\r\nAutor: "+cadena+ "\r\nCreado: "+ fecha+ "\r\nModificado: "+fecha+"\r\nSeparador_campos: |\r\nRegistros_activos: 1\r\nRegistros_inactivos: 0\r\nRegistros_máximo: 3");
                }
                else if(direccion.equals(DescriptorA))
                {
                    escritor.write("Archivo: C://MEIA/Lista_Amigos.txt\r\nDescripción: Solicitudes_de_amistad.\r\nTipo: archivo_de_datos\r\nOrganización: Secuencial\r\nAutor: "+cadena+"\r\nCreado: "+fecha+"\r\nModificado: "+fecha+"\r\nSeparador_campos: |\r\nLlave: Usuario_y_Usuarioamigo\r\nOrden: Ascendente\r\nRegistros_activos: 1\r\nRegistros_inactivos: 0");
                }
                escritor.close();
            }
            else
            {
                if(direccion.equals(DescriptorBU) || direccion.equals(DescriptorBA))
                {
                    String[] Registros = conteoRegistros(direccion).split(Pattern.quote("|"));
                    Date Fecha = new Date();
                    RandomAccessFile raf = new RandomAccessFile(descriptor,"rw");
                    for (int j = 0; j < 6; j++) {
                        raf.readLine();
                    }
                    raf.writeBytes("Modificado: "+Fecha+"\r\n");
                    raf.readLine();
                    raf.writeBytes("Registros_activos: "+Registros[0]+"\r\n");
                    raf.writeBytes("Registros_inactivos: "+Registros[1] );
                    raf.close();
                }
                else
                {
                    String[] Registros = conteoRegistros(direccion).split(Pattern.quote("|"));
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
                    raf.writeBytes("Registros_inactivos: "+Registros[1] );
                    raf.close();
                }
                
            }
        }
        catch(IOException e)
        {
            
        }
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
                        Solicitud Amistad = new Solicitud();
                        values = Linea.split(Pattern.quote("|"));
                        Amistad.SetEmisor(values[0]);
                        Amistad.SetReceptor(values[1]);
                        Amistad.SetAceptado(Integer.parseInt(values[2]));
                        Amistad.SetUser(values[3]);
                        Amistad.SetStatus(Integer.parseInt(values[4]));
                        if(acumulativa)
                        {
                            if((cadena.equals(Amistad.GetEmisor()) || cadena.equals(Amistad.GetReceptor())) & !(Amistad.GetStatus()==0))
                            {
                                Salida += Amistad.GetEmisor() + "," + Amistad.GetReceptor() + "|";
                            }
                        }
                        else
                        {
                            String[] Llave = cadena.split(Pattern.quote("|"));
                            if(Llave[0].equals(Amistad.GetEmisor()) & Llave[1].equals(Amistad.GetReceptor()) & !(Amistad.GetStatus()==0))
                            {
                                Salida = ruta+"|" + LeerArchivo.getFilePointer()+"|"+númLinea;
                            }
                        }
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
//ELIMINAR ==============================================================================================================================
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
//ACTUALIZAR======================================================================================================================
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
            //Obtener los nombres de la(s) llave(s).
            FileReader lector = new FileReader(Bitácora);
            BufferedReader leerArchivo = new BufferedReader(lector);
            String linea = leerArchivo.readLine();
            String Colección = "";
            String Colecciónnum = "";
            int númLineas = -1;
            while(linea != null)
            {
                númLineas++;
                String[] Datos = linea.split(Pattern.quote("|"));
                if("1".equals(Datos[Datos.length - 1]))
                {
                    if(rutaMaestro.equals(RutaU))
                    {
                        Colección += Datos[0] + "|";
                    }
                    else if(rutaMaestro.equals(RutaA))
                    {
                        Colección += Datos[0]+Datos[1] + "|";
                    }
                    Colecciónnum += númLineas + "|";
                }
                linea = leerArchivo.readLine();
            }
            lector.close();
            leerArchivo.close();
            String[] Registros = Colección.split(Pattern.quote("|"));
            String[] Posición = Colecciónnum.split(Pattern.quote("|"));
            //Obtener el orden de los registros
            for (int j = 1; j <= Registros.length; j++) {
                for (int k = 0; k < Registros.length -j; k++) {
                    if(Registros[k].compareTo(Registros[k+1]) > 0)
                    {
                        String aux = Registros[k];
                        Registros[k] = Registros[k+1];
                        Registros[k+1] = aux;
                        aux = Posición[k];
                        Posición[k] = Posición[k+1];
                        Posición[k+1] = aux;
                    }
                }
            }
            //Leer, escribir, leer, escribir, leer...
            Metodos.createFile(rutaMaestro);
            FileWriter escribir = new FileWriter(ArchivoMaestro);
            for (int i = 0; i < Posición.length; i++) {
                lector = new FileReader(Bitácora);
                leerArchivo = new BufferedReader(lector);
                for (int j = 0; j < Integer.parseInt(Posición[i]); j++) {
                 leerArchivo.readLine();
                }
                escribir.write(leerArchivo.readLine()+"\r\n");
                if(rutaMaestro.equals(RutaU))
                {
                    ActualizarDescriptor(DescriptorU,Registros[i]);
                }
                else if(rutaMaestro.equals(RutaA))
                {
                    ActualizarDescriptor(DescriptorA,Registros[i]);
                }
                lector.close();
                leerArchivo.close();
            }
            escribir.close();
            Path ruta = FileSystems.getDefault().getPath(rutaBitacora);
            Files.delete(ruta);
            if(rutaBitacora.equals(RutaBU))
            {
            ruta = FileSystems.getDefault().getPath(DescriptorBU);
            Files.delete(ruta);                
            }
            else if(rutaBitacora.equals(RutaBA))
            {
                ruta = FileSystems.getDefault().getPath(DescriptorBA);
                Files.delete(ruta);
            }
        }
        catch(IOException e){}
        }
    }
}
