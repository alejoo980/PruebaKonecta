 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import Clases.Conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class Cls_Inventario {
    
    private final String SQL_INSERT = "INSERT INTO INVENTARIO (Referencia,Precio,Nombre_Producto,Peso,Categoria,Stock,Fecha_De_Creacion) VALUES(?,?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM inventario";
    private PreparedStatement PS;
    private DefaultTableModel DT;
    private ResultSet RS;
    private final Conectar CN;
    
    public Cls_Inventario(){
        PS = null;
        CN = new Conectar();
        
    }
    
    private DefaultTableModel setTitulos(){
        DT = new DefaultTableModel();
        DT.addColumn("ID");
        DT.addColumn("Referencia");
        DT.addColumn("Precio");
        DT.addColumn("Nombre Producto");
        DT.addColumn("Peso");
        DT.addColumn("Categoria");
        DT.addColumn("Stock");
        DT.addColumn("Fecha");
        return DT;
    }
    
    public int insertDatos(int ref, int pre, String nomb, int peso, String cate, int stoc, String fech ){
        int res =0;
        try {
            PS = CN.getConnection().prepareStatement(SQL_INSERT);
            PS.setInt(1, ref);
            PS.setInt(2, pre);
            PS.setString(3, nomb);
            PS.setInt(4, peso);
            PS.setString(5, cate);
            PS.setInt(6, stoc);
            PS.setString(7, fech);
            res = PS.executeUpdate();
            
            if (res>0) {
                JOptionPane.showMessageDialog(null, "Registro guardado...");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al guardar los datos en la bd: " + e.getMessage());
        } finally{
        PS = null;
        CN.close();
        }
        
        return res;
    }

    
    public DefaultTableModel getDatos(){
        
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            while (RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getInt(2);
                fila[2] = RS.getInt(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getInt(7);
                fila[7] = RS.getDate(8);
                
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los datos..." + e.getMessage());
        }finally{
        PS = null;
        CN.close();
        }
        return DT;
    }
    
    public DefaultTableModel getDato(int crt, String prm){
        
        String SQL;
        if (crt == 0 ) {
            SQL = "SELECT * FROM inventario WHERE id_Inventario = " + prm;
        }else {
            SQL = "SELECT * FROM inventario where Nombre_Producto like '" + prm + "%'";
            
          }
        
        try {
            setTitulos();
            PS = CN.getConnection().prepareStatement(SQL);
            RS = PS.executeQuery();
            Object[] fila = new Object[8];
            while (RS.next()){
                fila[0] = RS.getInt(1);
                fila[1] = RS.getInt(2);
                fila[2] = RS.getInt(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getInt(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getInt(7);
                fila[7] = RS.getDate(8);
                
                DT.addRow(fila);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar los datos..." + e.getMessage());
        }finally{
        PS = null;
        CN.close();
        }
        return DT;
    }
    
    public int updateDatos(int id, int ref, int pre, String nomb, int peso, String cate, int stoc, String fech ){
        
        String SQL = "UPDATE inventario SET Referencia='"+ ref +"', Precio='"+ pre +"', Nombre_Producto='"+ nomb +"', "
                + "Peso='"+ peso +"', Categoria='"+ cate +"', Stock='"+ stoc +"', Fecha_De_Creacion='"+ fech +"' WHERE id_Inventario=" + id;
        
        int res =0; 
        try {
            PS = CN.getConnection().prepareStatement(SQL);
            res = PS.executeUpdate();
            
            if (res>0) {
                JOptionPane.showMessageDialog(null, "Registro modificado...");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al modificar los datos en la bd: " + e.getMessage());
        } finally{
        PS = null;
        CN.close();
        }
        
        return res;
    }
    
}
