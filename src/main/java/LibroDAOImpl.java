import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public int insertar(Libro libro) throws SQLException {
        String sql = "INSERT INTO libro (titulo, autor, genero, alquilado) VALUES (?, ?, ?, ?)";

        try {
            Connection db = Database.getConexion();
            PreparedStatement ps = db.prepareStatement(sql);
            ps.setString(1, libro.getTitulo().toLowerCase());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setBoolean(4, libro.isAlquilado());
            int result = ps.executeUpdate();
            Database.closePreparedStatement(ps);
            Database.closeConnection(db);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Libro> listar() throws SQLException {
        String sql = "SELECT autor, titulo, genero, alquilado FROM libro";
        List<Libro> libros = new ArrayList<>();

        try {
            Connection db = Database.getConexion();
            Statement stmt = db.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                String genero = resultSet.getString("genero");
                boolean aquilado = resultSet.getBoolean("alquilado");

                Libro libro = new Libro(titulo, autor, genero, aquilado);
                libros.add(libro);
            }
            Database.closeConnection(db);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }

    @Override
    public int alquilar(Libro libro) throws SQLException {
        String sql = "UPDATE libro SET alquilado = ? WHERE titulo = ?";

        try {
            Connection db = Database.getConexion();
            PreparedStatement ps = db.prepareStatement(sql);
            libro.setAlquilado(true);
            ps.setBoolean(1, libro.isAlquilado());
            ps.setString(2, libro.getTitulo().toLowerCase());
            int result = ps.executeUpdate();
            Database.closePreparedStatement(ps);
            Database.closeConnection(db);
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    @Override
    public int borrar(Libro libro) throws SQLException {
        String sql = "DELETE FROM libro WHERE titulo = ?";

        try {
            Connection db = Database.getConexion();
            PreparedStatement ps = db.prepareStatement(sql);
            ps.setString(1, libro.getTitulo().toLowerCase());
            int result = ps.executeUpdate();
            Database.closePreparedStatement(ps);
            Database.closeConnection(db);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Libro getByTitulo(String titulo) throws SQLException {
        String sql = "SELECT autor, titulo, genero, alquilado FROM libro WHERE titulo = ?";
        Libro libro = null;

        Connection db = Database.getConexion();
        PreparedStatement ps = db.prepareStatement(sql);
        ps.setString(1, titulo);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String otitulo = rs.getString("titulo");
            String autor = rs.getString("autor");
            String genero = rs.getString("genero");
            boolean alquilado = rs.getBoolean("alquilado");

            libro = new Libro(otitulo, autor, genero, alquilado);
        }

        Database.closeResultSet(rs);
        Database.closePreparedStatement(ps);
        Database.closeConnection(db);

        return libro;
    }
}
