/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;
import Conexion.Singleton;
import java.io.PrintWriter;
import java.sql.*;

import Conexion.Singleton;

/**
 *
 * @author User_Len
 */
public class ProyectoArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        Singleton.getInstancia().conexion();
    }
    
}
