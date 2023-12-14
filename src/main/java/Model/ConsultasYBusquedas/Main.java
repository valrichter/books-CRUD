package Model.ConsultasYBusquedas;

import Model.Biblioteca;
import Model.Libro;
import Model.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    /*
        4. Consultas y Búsquedas:
            - Los usuarios pueden buscar libros en la biblioteca por título, autor o género.
    */
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
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        boolean busquedaDeLibros = true;
        while (busquedaDeLibros) {
            System.out.println("Desea buscar un libro? SI o NO");
            String eleccion = scanner.nextLine();

            if (eleccion.toLowerCase().equals("si")) {

                System.out.println("Desea buscar por: Titulo, Autor o Genero");
                String busqueda = scanner.nextLine();

                // Buscar por título
                if (busqueda.toLowerCase().equals("titulo")) {
                    System.out.println("Buscar por titulo:");
                    String titulo = scanner.nextLine();
                    usuario1.buscarPorTitulo(titulo, biblioteca);
                    System.out.println();
                }

                // Buscar por autor
                if (busqueda.toLowerCase().equals("autor")) {
                    System.out.println("Buscar por autor:");
                    String autor = scanner.nextLine();
                    usuario1.buscarPorAutor(autor, biblioteca);
                    List<Libro> librosDelAutor = usuario1.buscarPorAutor(autor, biblioteca);
                    librosDelAutor.forEach(System.out::println);
                    System.out.println();
                }

                // Buscar por genero
                if (busqueda.toLowerCase().equals("genero")) {
                    System.out.println("Buscar por genero:");
                    String genero = scanner.nextLine();
                    usuario1.buscarPorGenero(genero, biblioteca);
                    List<Libro> librosPorGenero = usuario1.buscarPorGenero(genero, biblioteca);
                    librosPorGenero.forEach(System.out::println);
                    System.out.println();
                }

                if (!busqueda.toLowerCase().equals("titulo") && !busqueda.toLowerCase().equals("autor") && !busqueda.toLowerCase().equals("genero")) {
                    System.out.println("INGRESE UNA OPCION VALIDA PORFAVOR");
                }
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
