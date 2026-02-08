/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import Models.Acceso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pilar
 */
public class AccesoDao {
        // Atributos CRUD
    private static final String INSERT = "INSERT INTO filmografia(......) VALUES (?,?,?,?)";
    private static final String DELETE = "DELETE FROM filmografia WHERE id=?";
    private static final String UPDATE = "UPDATE filmografia SET columna1 = valor1, columna2 = valor2 WHERE ID = ?";
    private static final String LISTALL = "SELECT * FROM filmografia";
    private static final String LISTONE = "SELECT * FROM filmografia WHERE id=?";
    private Connection conn;

    //Constructor
    public AccesoDao(Connection conn) {
        this.conn = conn;
    }
    
    
    // Metodo para listar todo 
    
    public void ListAll() throws SQLException {

        try {
           
            PreparedStatement stmt = conn.prepareStatement(LISTALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
        Acceso ac = new Acceso();

                ac.setId_acceso(rs.getInt("id_acceso"));
                ac.setId_filmografia(rs.getInt("id_filmografia"));
                ac.setId_cuenta(rs.getInt("id_cuenta"));
                ac.setFecha_acceso(rs.getDate("fecha_acceso"));
                ac.setTipo_suscripcion_id(rs.getInt("tipo_suscripcion_id"));

                System.out.println(ac.toString());
            }


        } catch (SQLException e) {
            System.out.println("Error en list all" + e.getMessage() + e);
        }

    }

    // Metodo para listar una fila 
    
    public void ListOne(int id) {

        try {

            PreparedStatement stmt = conn.prepareStatement(LISTONE);
           // stmt.setInt(1, 4); // En la primera ?, el valor 4
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
           
                Acceso ac = new Acceso();

                ac.setId_acceso(rs.getInt("id_acceso"));
                ac.setId_filmografia(rs.getInt("id_filmografia"));
                ac.setId_cuenta(rs.getInt("id_cuenta"));
                ac.setFecha_acceso(rs.getDate("fecha_acceso"));
                ac.setTipo_suscripcion_id(rs.getInt("tipo_suscripcion_id"));

                System.out.println(ac.toString());    
            
        } catch (SQLException e) {
            System.out.println(e.getMessage() + e);
        }
    }
}
