import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public int insertarLibro(Libro libro) throws SQLException {
        Connection db = Database.getConexion();
        String sql = "INSERT INTO libro (titulo, autor, genero, editorial) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = db.prepareStatement(sql);
        ps.setString(1, libro.getTitulo());
        ps.setString(2, libro.getAutor());
        ps.setString(3, libro.getGenero());
        ps.setString(4, libro.getEditorial());
        int result = ps.executeUpdate();
        Database.closePreparedStatement(ps);
        Database.closeConnection(db);
        return result;
    }

    @Override
    public Libro getByTitulo(String titulo) throws SQLException {
        return null;
    }

    @Override
    public List<Libro> getAll(Libro libro) throws SQLException {
        return null;
    }

    @Override
    public void actualizarLibro(Libro libro) throws SQLException {

    }

    @Override
    public void borrarLibro(Libro libro) throws SQLException {

    }
}
