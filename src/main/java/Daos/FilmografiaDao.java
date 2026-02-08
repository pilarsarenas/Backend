/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Daos;

import DbManager.DbManager;
import Models.Filmografia;
import java.sql.PreparedStatement;
import java.sql.Connection; // Guarda la conexion en un objeto
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException; // Nos indica el error SQL en caso de que falle la conexion

/**
 *
 * @author pilar
 */
public class FilmografiaDao {

    // Atributos CRUD
    private static final String INSERT = "INSERT INTO filmografia (titulo, fecha_estreno, sinopsis, pais_id, clasificacion_id) VALUES (?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM filmografia WHERE id=?";
    private static final String UPDATE = "UPDATE filmografia SET titulo=?, fecha_estreno=?, sinopsis=?, pais_id=?, clasificacion_id=? WHERE id=?";
    private static final String LISTALL = "SELECT * FROM filmografia";
    private static final String LISTONE = "SELECT * FROM filmografia WHERE id=?";
    private Connection conn;

    //Constructor
    public FilmografiaDao(Connection conn) {
        this.conn = conn;
    }

    // Metodo para listar todo 
    public void ListAll() throws SQLException {

        try {

            PreparedStatement stmt = conn.prepareStatement(LISTALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Filmografia filmo = new Filmografia();

                //RESULTSET obtiene el valor da cada columna
                filmo.setId(rs.getInt("id"));
                filmo.setTitulo(rs.getString("titulo"));
                filmo.setFecha_estreno(rs.getDate("fecha_estreno"));
                filmo.setSinopsis(rs.getString("sinopsis"));
                filmo.setPais_id(rs.getInt("pais_id"));
                filmo.setClasificacion_id(rs.getInt("clasificacion_id"));

                System.out.println(filmo.toString());

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

            Filmografia filmo = new Filmografia();

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
    // Metodo para insertar

    public void Insert(String titulo, Date fecha_estreno,
            String sinopsis, int pais_id, int clasificacion_id) {

        try {
            PreparedStatement stmt = conn.prepareStatement(INSERT);
            stmt.setString(1, titulo);
            stmt.setDate(2, fecha_estreno);
            stmt.setString(3, sinopsis);
            stmt.setInt(4, pais_id);
            stmt.setInt(5, clasificacion_id);
            stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en insertar" + e.getMessage());
        }
    }

    // Metodo para eliminar
    public void Delete(int id) {

        try {
            PreparedStatement stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, id);
            stmt.executeQuery();

        } catch (SQLException e) {
            System.out.println("Error en borrar" + e.getMessage());
        }
    }

    //Metodo para actualizar 
    public void Update(int id, String titulo, Date fecha_estreno,
            String sinopsis, int pais_id, int clasificacion_id) {

        try {

            PreparedStatement stmt = conn.prepareStatement(UPDATE);

            stmt.setString(1, titulo);
            stmt.setDate(2, fecha_estreno);
            stmt.setString(3, sinopsis);
            stmt.setInt(4, pais_id);
            stmt.setInt(5, clasificacion_id);
            stmt.setInt(6, id);

            stmt.executeUpdate();

            System.out.println("Filmografía actualizada correctamente");

        } catch (SQLException e) {
            System.out.println("Error en update: " + e.getMessage());
        }
    }

}
