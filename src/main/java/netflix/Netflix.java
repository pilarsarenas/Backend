package netflix;

import Daos.AccesoDao;
import Daos.FilmografiaDao;
import DbManager.DbManager;
import Models.Acceso;
import java.sql.Date;

public class Netflix {

    public static void main(String[] args) {

        // Crear objeto DbManager
        DbManager db = new DbManager();
        db.conectar();

        // Crear DAOs pasando la conexión
        FilmografiaDao filmo = new FilmografiaDao(db.getConexion());
        AccesoDao ac = new AccesoDao(db.getConexion());

        System.out.println("// -------------------------FILMOGRAFIA------------------------- //");

        // -------------------------
        // LISTAR TODOS
        // -------------------------
        System.out.println("----- LIST ALL -----");
        // filmo.ListAll();

        // -------------------------
        // LISTAR UNO
        // -------------------------
        System.out.println("----- LIST ONE -----");
        filmo.ListOne(3);

        // -------------------------
        // INSERTAR
        // -------------------------
        System.out.println("----- INSERT -----");
        Date fecha = Date.valueOf("2024-01-01"); // cada vez que llamo a Insert tengo que darle un Date válido (java.sql.Date)
        filmo.Insert("Nueva Pelicula", fecha,
                "Película de prueba", 1, 2);

        // -------------------------
        // UPDATE
        // -------------------------
        System.out.println("----- UPDATE -----");
        filmo.Update(3, "Titulo Actualizado", fecha,
                "Sinopsis actualizada", 1, 2);

        // -------------------------
        // DELETE
        // -------------------------
        System.out.println("----- DELETE -----");
        filmo.Delete(5);

        System.out.println("// -------------------------ACCESO------------------------- //");

        //ac.ListAll();
        ac.ListOne(4);

        // Cerrar conexión (si tienes método cerrar)
        db.desconectar();

    }
}
