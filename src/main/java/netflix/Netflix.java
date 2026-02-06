package netflix;

import Daos.FilmografiaDao;
import DbManager.DbManager;

public class Netflix {

    public static void main(String[] args) {
        DbManager db = new DbManager();
        db.conectar();

        FilmografiaDao flm = new FilmografiaDao(db.getConexion());

        //FilmografiaDAO.ListAll();
        flm.ListOne();

        db.desconectar();
    }
}
