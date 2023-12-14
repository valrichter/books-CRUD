package Model.GestionUsuarios;

import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    /*
        2. Gestión de Usuarios:
           - Los usuarios pueden registrarse en el sistema.
           - Los usuarios pueden alquilar libros.
           - Los usuarios deben devolver los libros
    */
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        Libro libro1 = new Libro("1984", "George Orwell", "Distopia");
        Libro libro10 = new Libro("La Odisea", "Homero", "Epopeya");

        // Agregamos unos libros de prueba
        System.out.println("Agregar libro de prueba:");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro10);
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Registrar usuario
        System.out.println("Ingrese su DNI:");
        String dni = scanner.nextLine();

        System.out.println("Ingrese su Nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su Apellido:");
        String apellido = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(Integer.parseInt(dni), nombre, apellido);
        biblioteca.registrarUsuario(nuevoUsuario);
        System.out.println();

        // Alquilar libro
        boolean alquilarLibro = true;
        while (alquilarLibro){
            System.out.println("Desea alquilar un libro? SI o NO");
            String eleccion = scanner.nextLine();

            if (eleccion.toLowerCase().equals("si")) {
                System.out.println("TODOS LOS LIBROS QUE POSEE LA BIBLIOTECA:");
                biblioteca.getLibros().forEach(System.out::println);
                System.out.println();

                System.out.println("Ingrese el titulo del libro que desea alquilar:");
                String titulo = scanner.nextLine();
                Libro libroBuscado = nuevoUsuario.buscarPorTitulo(titulo, biblioteca);
                nuevoUsuario.alquilarLibro(libroBuscado, biblioteca);
                System.out.println();
            }

            if (eleccion.toLowerCase().equals("no")) {
                System.out.println("TODOS LOS LIBROS QUE POSEE LA BIBLIOTECA:");
                biblioteca.getLibros().forEach(System.out::println);
                System.out.println();
                alquilarLibro = false;
            }

            if (!eleccion.toLowerCase().equals("si") && !eleccion.toLowerCase().equals("no")) {
                System.out.println("INGRESE UNA OPCION VALIDA PORFAVOR");
            }
        }

        // Devolver libro
        boolean devolverLibro = true;
        while (devolverLibro){
            System.out.println("Desea devolver un libro? SI o NO");
            String eleccion = scanner.nextLine();

            if (eleccion.toLowerCase().equals("si")) {
                System.out.println("TODOS LOS ALQUILERES QUE USTED DEBE:");
                nuevoUsuario.getAlquileresDebidos().forEach(System.out::println);
                System.out.println();

                System.out.println("Ingrese el titulo del libro que desea devolver:");
                String titulo = scanner.nextLine();
                Libro libroBuscado = nuevoUsuario.buscarPorTitulo(titulo, biblioteca);

                // Este metodo pide q se ingrese la fechaDevolcion en la cual en libro es devuelto
                nuevoUsuario.devolverLibro(libroBuscado, biblioteca, LocalDate.now());
                System.out.println();
            }

            if (eleccion.toLowerCase().equals("no")) {
                System.out.println("TODOS LOS LIBROS QUE POSEE LA BIBLIOTECA:");
                biblioteca.getLibros().forEach(System.out::println);
                System.out.println();
                devolverLibro = false;
            }

            if (!eleccion.toLowerCase().equals("si") && !eleccion.toLowerCase().equals("no")) {
                System.out.println("INGRESE UNA OPCION VALIDA PORFAVOR");
            }
        }
    }

}
