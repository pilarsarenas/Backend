/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import java.sql.Connection;

/**
 *
 * @author pilar
 */
public class Tipo_suscripcionDao {
    
        // Atributos CRUD
    private static final String INSERT = "INSERT INTO filmografia(......) VALUES (?,?,?,?)";
    private static final String DELETE = "DELETE FROM filmografia WHERE id=?";
    private static final String UPDATE = "UPDATE filmografia SET columna1 = valor1, columna2 = valor2 WHERE ID = ?";
    private static final String LISTALL = "SELECT * FROM filmografia";
    private static final String LISTONE = "SELECT * FROM filmografia WHERE id=?";
    private Connection conn;

    //Constructor
    public Tipo_suscripcionDao(Connection conn) {
        this.conn = conn;
    }
}
