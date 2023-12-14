package Model.InformesYEstadisticas;

import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        Usuario usuario1 = new Usuario(1, "Ricardo", "Fort");

        Libro libro1 = new Libro("1984", "George Orwell", "Distopia");
        Libro libro2 = new Libro("El señor de los anillos", "J.R.R. Tolkien", "Fantasia");
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel Garcia Marquez", "Realismo magico");
        Libro libro4 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", "Fantasia");
        Libro libro5 = new Libro("Animal Farm", "George Orwell", "Alegoria politica");
        Libro libro6 = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "Novela");
        Libro libro7 = new Libro("Los juegos del hambre", "Suzanne Collins", "Ciencia ficción");
        Libro libro8 = new Libro("Crónica de una muerte anunciada", "Gabriel Garcia Marquez", "Realismo magico");
        Libro libro9 = new Libro("El Código Da Vinci", "Dan Brown", "Misterio");
        Libro libro10 = new Libro("La Odisea", "Homero", "Epopeya");

        // Registro de usuarios
        System.out.println("Registrar usuario de prueba:");
        biblioteca.registrarUsuario(usuario1);
        // Agregamos unos libros de prueba
        System.out.println("Agregar libros de prueba");
        usuario1.agregarLibro(libro1, biblioteca);
        usuario1.agregarLibro(libro1, biblioteca);
        usuario1.agregarLibro(libro2, biblioteca);
        usuario1.agregarLibro(libro3, biblioteca);
        usuario1.agregarLibro(libro4, biblioteca);
        usuario1.agregarLibro(libro5, biblioteca);
        usuario1.agregarLibro(libro6, biblioteca);
        usuario1.agregarLibro(libro7, biblioteca);
        usuario1.agregarLibro(libro8, biblioteca);
        usuario1.agregarLibro(libro9, biblioteca);
        usuario1.agregarLibro(libro10, biblioteca);

        // Aluilamos libros de prueba
        usuario1.alquilarLibro(libro1, biblioteca);
        usuario1.alquilarLibro(libro5, biblioteca);
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Generar informe
        boolean busquedaDeLibros = true;
        while (busquedaDeLibros) {
            System.out.println("Desea generar un informe de la biblioteca? SI o NO");
            String eleccion = scanner.nextLine();

            if (eleccion.toLowerCase().equals("si")) {
                System.out.println("Informe:");
                usuario1.generarInformeDeBiblioteca(biblioteca);
                System.out.println();
            }

            if (eleccion.toLowerCase().equals("no")) {
                System.out.println("TODOS LOS LIBROS QUE POSEE LA BIBLIOTECA:");
                biblioteca.getLibros().forEach(System.out::println);
                System.out.println();
                busquedaDeLibros = false;
            }

            if (!eleccion.toLowerCase().equals("si") && !eleccion.toLowerCase().equals("no")) {
                System.out.println("INGRESE UNA OPCION VALIDA PORFAVOR");
            }
        }

    }
}
