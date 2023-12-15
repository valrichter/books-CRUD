import java.sql.SQLException;
import java.util.List;

public interface LibroDAO {
    int insertarLibro(Libro libro) throws SQLException;

    List<Libro> getAll(Libro libro)throws SQLException;
    Libro getByTitulo(String titulo)throws SQLException;

    void actualizarLibro(Libro libro)throws SQLException;

    void borrarLibro(Libro libro)throws SQLException;
}
