import java.sql.SQLException;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private boolean alquilado;

    public Libro() {;
    }

    public Libro(String titulo, String autor, String genero, boolean alquilado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.alquilado = alquilado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isAlquilado() {
        return alquilado;
    }

    public void setAlquilado(boolean alquilado) {
        this.alquilado = alquilado;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", alquilado=" + alquilado +
                '}';
    }

    public static class Main {
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
}