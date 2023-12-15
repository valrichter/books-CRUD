import javax.swing.*;

public class Libro {
    private String titulo;
    private String autor;
    private String genero;
    private boolean alquilado;

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
}
