import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        LibroDAO libroDAO = new LibroDAOImpl();
        Libro a = new Libro("A", "A", "A", false);
        Libro b = new Libro("B", "B", "B", false);

        System.out.println("CREATE");
        libroDAO.insertar(a);
        libroDAO.insertar(b);
        System.out.println();

        System.out.println("READ");
        System.out.println(libroDAO.listar());
        System.out.println();

        System.out.println("UPDATE");
        int u = libroDAO.alquilar(a);
        System.out.println(u);
        System.out.println();

        System.out.println("DELETE");
        int d = libroDAO.borrar(b);
        System.out.println(d);
        System.out.println();
    }
}
