import java.sql.SQLException;
import java.util.List;

public interface LibroDAO {
    int insertar(Libro libro) throws SQLException;

    List<Libro> listar()throws SQLException;

    int alquilar(Libro libro)throws SQLException;

    int borrar(Libro libro)throws SQLException;
}
