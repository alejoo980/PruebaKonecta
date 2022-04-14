/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alejandro
 */
public class Conectar {

    
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/cafeteria1";
    private Connection CN;

    public Conectar() {
        CN = null;
        
    }
    
    public Connection getConnection(){
        try {
            Class.forName(driver);
            CN = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos" +  e.getMessage());
            System.exit(0);
        }
        return CN;
    }
    
    
    public void close(){
        try {
            CN.close();
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cerrar la conexion a la base de datos" +  e.getMessage());
        }
        /*try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            
            if (conn != null) {
                System.out.println("Conexion establecida...");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar" + e);
        }
    }
    
    //Este metodo nos retorna la conexion
    public Connection getConnection(){
        return conn;
    }
    
    //Con este motodo nos desconectamos de la base de datos
    public void desconectar(){
        conn = null;
        
        if (conn == null) {
            System.out.println("Conexion terminada...");
        }
    }
    
}*/
    }
}