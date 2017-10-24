/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.util.Date;

/**
 *
 * @author jsala
 */
public class User {
    private String user;
    private String name;
    private String lastName;
    private String password;
    private String rol;
    private String date; //fecha actual
    private String email;
    private int celNumber;
    private String description;
    private String photoPath;
    private int status;
    private String registro;
    
        //Constructor
    User(){
        this.user = "";
        this.name = "";
        this.lastName = "";
        this.rol = "0";
        this.date = "";
        this.email ="";
        this.celNumber = 00000000;
        this.description = "";
        this.photoPath = "";
        this.status = 1; //está vigente  
    }

    //Métodos GET-SET
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user.replaceAll("#", "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.replaceAll("#", "");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.replaceAll("#", "");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email.replaceAll(" ", "");
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelNumber() {
        return celNumber;
    }

    public void setCelNumber(int celNumber) {
        this.celNumber = celNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description.replaceAll("#", "");;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath.replaceAll(" ", "");;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
     public String getRegistro() {
         registro="";
         rellenar(user,16,"#");
         rellenar(name,50,"#");
         rellenar(lastName,50,"#");
         registro+= password +"|";
         registro+=rol +"|";
         registro+=date +"|";
         rellenar(email,32," ");
         registro+=celNumber +"|";
         rellenar(photoPath,50," ");
         rellenar(description,50,"#");
         registro+=status + System.getProperty("line.separator");
         return registro;
    }

    public void setStatus(String registro) {
        this.registro = registro;
    }
    //Procedimiento que establece un tamaño fijo para un atributo.
    public void rellenar(String var,int cantidad,String relleno) {
        registro+=var;
        for (int i = var.length(); i < cantidad; i++) {
           registro+=relleno; 
        }
        registro+="|"; 
    }
}
