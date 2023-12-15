import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibroDAO libroDAO = new LibroDAOImpl();
        Libro libro = new Libro("HOL", "A", "A", "A");
        int r = libroDAO.insertarLibro(libro);
        System.out.println(r);
    }
}
