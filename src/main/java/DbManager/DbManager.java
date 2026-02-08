/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DbManager;

import java.sql.DriverManager; // Maneja las credenciales
import java.sql.Connection; // Guarda la conexion en un objeto
import java.sql.SQLException; // Nos indica el error SQL en caso de que falle la conexion
import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author pilar
 */
public class DbManager {

    //Atributos de la clase
    private static final Dotenv dotenv = Dotenv.load(); // Para ocultar las credenciales de la BBDD
    private static final String USER = dotenv.get("DB_USER"); // Accede a las variables del .env
    private static final String PASS = dotenv.get("DB_PASS");
    private static final String URL = dotenv.get("DB_URL");
    private Connection conexion = null;

    //Static porque pertenecen a la clase y no al objeto
    //Final porque no se van a modificar
    
    //Get y Set
    public static Dotenv getDotenv() {
        return dotenv;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASS() {
        return PASS;
    }

    public static String getURL() {
        return URL;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    // Constructor por defecto
    public DbManager() {
    }

    // Métodos para conectar y desconectar con la BBDD
    public void conectar() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (this.conexion != null && !this.conexion.isClosed()) {
                this.conexion.close(); // Cerrar siempre para evitar fuga de memoria
                System.out.println("Desconexion exitosa");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + " ERROR AL CONECTAR ");
        }
    }

}
