/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configBD;


import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author octaviano
 */
public class Conexion {
    boolean conectado = false;
    Connection conexion;
    Statement stm; //Lo mejor es utilizar PREPARED STATMENT
    ResultSet rs;
    
    
    public Connection getConexion(){
      return conexion; 
    }
    

    public boolean isConectado() {
        return conectado;
    }
    
    
    
    public boolean ejecutarInstruccionSQL(String sql){
        boolean res = true;
            
        try {
            stm = conexion.createStatement();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public ResultSet ejecutarConsulta(String sql){
        
        try {
            //stm = conexion.prepareStatement("INSERT INTO Alumnos VALUES(?,?,?,?,?,?,')");
            stm = conexion.createStatement();
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    
    public static void main(String[] args) {
        new Conexion();
    }
    
     public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Estetica";
            String user = "Octaviano";
            String password ="octaviano";
            conexion = DriverManager.getConnection(url, user, password);
            
            System.out.println("CONEXION ESTABLECIDA");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//CONSTRUCTOR
}
