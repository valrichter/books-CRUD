package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Usuario implements Notificable {
    private Integer dni;
    private String nombre;
    private String apellido;
    private ArrayList<Alquiler> alquileres;

    public Usuario(Integer dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.alquileres = new ArrayList<>();
    }

    public void agregarLibro(Libro libro, Biblioteca biblioteca) throws Exception {

        biblioteca.agregarLibro(libro);
    }

    public void eliminarLibro(Libro libro, Biblioteca biblioteca) throws Exception {
        biblioteca.eliminarLibro(libro, this.dni);
    }

    public void alquilarLibro(Libro libro, Biblioteca biblioteca) {
        Libro libroAlquilado = biblioteca.alquilarLibroAUsuario(libro, this.dni);
        if (libroAlquilado == null) {
            throw new Error("Libro no existe");
        }
        Alquiler nuevoAlquiler = new Alquiler(libro, this);
        alquileres.add(nuevoAlquiler);
//        System.out.println("Libro alquilado -> " + nuevoAlquiler);
        notificarAlquiler(nuevoAlquiler);
    }

    public void devolverLibro(Libro libro, Biblioteca biblioteca, LocalDate fechaDevolucion) {
        biblioteca.devolverLibroDeUsuario(libro, this.dni);
        for (Alquiler alquiler : alquileres) {
            if (alquiler.getLibro().equals(libro)) {
                alquiler.getLibro().setAlquilado(false);
                alquiler.setFechaDevolucion(fechaDevolucion);
                System.out.println("Libro devuelto -> " + alquiler);
            }
        }
    }

    public ArrayList<Alquiler> getAlquileresDebidos() {
        return (ArrayList<Alquiler>) alquileres.stream()
                .filter(alquiler -> alquiler.getLibro().isAlquilado())
                .collect(Collectors.toList());
    }

    public Libro buscarPorTitulo(String titulo, Biblioteca biblioteca) throws Exception {
        Libro libroBuscado = biblioteca.buscarPorTitulo(titulo);
        if (libroBuscado == null) {
            throw new Exception("Libro: '" + titulo + "' no encontrado");
        }
        System.out.println("Libro por titulo -> " + libroBuscado);
        return libroBuscado;
    }

    public List<Libro> buscarPorAutor(String autor, Biblioteca biblioteca) throws Exception {
        List<Libro> librosDelAutor = biblioteca.buscarPorAutor(autor);
        if (librosDelAutor.isEmpty()) {
            throw new Exception("Autor: '" + autor + "' no encontrado");
        }
        return librosDelAutor;
    }

    public List<Libro> buscarPorGenero(String genero, Biblioteca biblioteca) throws Exception {
        List<Libro> librosPorGenero = biblioteca.buscarPorGenero(genero);
        if (librosPorGenero.isEmpty()) {
            throw new Exception("Genero: '" + genero + "' no encontrado");
        }
        return librosPorGenero;
    }

    public void generarInformeDeBiblioteca(Biblioteca biblioteca) {
        int totalLibros = biblioteca.totalLibros();
        int totalUsuarios = biblioteca.totalUsarios();
        int totalLibrosAlquilados = biblioteca.totalLibrosAlquilados();
        Map<String, Long> cantLibrosPorGenero = biblioteca.cantLibrosPorGenero();
        Map<String, Long> cantLibrosPorAutor = biblioteca.cantLibrosPorAutor();
        String autorMasAlquilado = biblioteca.autorMasAlquilado();

        System.out.println("Total de Libros: " + totalLibros);
        System.out.println("Total de Usuarios: " + totalUsuarios);
        System.out.println("Total de libros alquilados: " + totalLibrosAlquilados);
        System.out.println("Cantidad de libros por Genero: " + cantLibrosPorGenero);
        System.out.println("Cantidad de libros por Autor: " + cantLibrosPorAutor);
        System.out.println("Autor mas alquilado: " + autorMasAlquilado);
        System.out.println();
        biblioteca.getLibros().forEach(System.out::println);
    }

    @Override
    public void notificarAlquiler(Alquiler alquiler) {
        System.out.println("Notificación de alquiler para " + alquiler.getUsuario().getNombre() + ": Se ha alquilado el libro " + alquiler.getLibro().getTitulo() + "!");
    }

    public ArrayList<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

}
