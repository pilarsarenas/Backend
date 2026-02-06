/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import DbManager.DbManager;
import Models.Filmografia;
import java.sql.PreparedStatement;
import java.sql.Connection; // Guarda la conexion en un objeto
import java.sql.ResultSet;
import java.sql.SQLException; // Nos indica el error SQL en caso de que falle la conexion

/**
 *
 * @author pilar
 */
public class FilmografiaDao {

    // Atributos CRUD
    private static final String INSERT = "INSERT INTO filmografia(......) VALUES (?,?,?,?)";
    private static final String DELETE = "DELETE FROM filmografia WHERE id=?";
    private static final String UPDATE = "UPDATE filmografia SET columna1 = valor1, columna2 = valor2 WHERE ID = ?";
    private static final String LISTALL = "SELECT * FROM filmografia";
    private static final String LISTONE = "SELECT * FROM filmografia WHERE id=?";
    private Connection conn;

    //Constructor
    public FilmografiaDao(Connection conn) {
        this.conn = conn;
    }

    // Metodo para listar todo 
    public void ListAll() throws SQLException {

        Filmografia filmo = new Filmografia();

        PreparedStatement stmt = conn.prepareStatement(LISTALL);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            filmo.setId(rs.getInt("id"));
            filmo.setTitulo(rs.getString("titulo"));
            filmo.setFecha_estreno(rs.getDate("fecha_estreno"));
            filmo.setSinopsis(rs.getString("sinopsis"));
            filmo.setPais_id(rs.getInt("pais_id"));
            filmo.setClasificacion_id(rs.getInt("clasificacion_id"));
            System.out.println(filmo.toString());
        }

    }

    // Metodo para listar una fila 
    public void ListOne() {

        try {
            Filmografia filmo = new Filmografia();

            PreparedStatement stmt = conn.prepareStatement(LISTONE);
            stmt.setInt(1, 3);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            filmo.setId(rs.getInt("id"));
            filmo.setTitulo(rs.getString("titulo"));
            filmo.setFecha_estreno(rs.getDate("fecha_estreno"));
            filmo.setSinopsis(rs.getString("sinopsis"));
            filmo.setPais_id(rs.getInt("pais_id"));
            filmo.setClasificacion_id(rs.getInt("clasificacion_id"));
            System.out.println(filmo.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage() + e);
        }

    }

}
