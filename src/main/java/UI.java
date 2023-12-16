import javax.swing.*;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI extends javax.swing.JFrame {
    private JTextField tituloField;
    private JTextField alquiladoField;
    private JTextField generoField;
    private JTextField autorField;
    private JPanel panel;
    private JLabel Autor;
    private JLabel Genero;
    private JButton INGRESARButton;
    private JButton LISTARButton;
    private JButton ALQUILARButton;
    private JButton BORRARButton;
    private JLabel Alquilado;
    private JLabel Titulo;
    private JList list;
    private DefaultListModel listModel = new DefaultListModel();

    public UI() {

        INGRESARButton.addActionListener(e -> {
            try {
                if (isValidINGRESAR()) {
                    LibroDAO libroDAO = new LibroDAOImpl();
                    boolean alquilado = alquiladoField.getText().toLowerCase().equals("si");
                    Libro libro = new Libro(tituloField.getText(), autorField.getText(), generoField.getText(), alquilado);
                    int r = libroDAO.insertar(libro);
                    String lMSG = "Usted ha ingresado el " + libro + " correctamente";
                    String rMSG = "Usted ha ingresado " + r + " nuevo libro/s";
                    list.setModel(listModel);
                    listModel.removeAllElements();
                    listModel.addElement(lMSG);
                    listModel.addElement(rMSG);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        LISTARButton.addActionListener(e -> {
            try {
                LibroDAO libroDAO = new LibroDAOImpl();
                List<Libro> libros = libroDAO.listar();
                list.setModel(listModel);
                listModel.removeAllElements();
                for (Libro libro : libros) {
                    listModel.addElement(libro);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        ALQUILARButton.addActionListener(e -> {
            try {
                if (isValidALQUILAR()) {
                    LibroDAO libroDAO = new LibroDAOImpl();
                    boolean alquilado = alquiladoField.getText().toLowerCase().equals("si");
                    Libro libro = new Libro(tituloField.getText(), autorField.getText(), generoField.getText(), alquilado);
                    int r = libroDAO.alquilar(libro);
                    String lMSG = "Usted ha alquilado el libro '" + tituloField.getText() + "' correctamente";
                    String rMSG = "Usted ha alquilado " + r + " libro/s";
                    list.setModel(listModel);
                    listModel.removeAllElements();
                    listModel.addElement(lMSG);
                    listModel.addElement(rMSG);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        BORRARButton.addActionListener(e -> {
            try {
                if (isValidBORRAR()) {
                    LibroDAO libroDAO = new LibroDAOImpl();
                    Libro libro = new Libro(tituloField.getText(), autorField.getText(), generoField.getText(), false);
                    int r = libroDAO.borrar(libro);
                    String lMSG = "Usted ha eliminado el libro '" + tituloField.getText() + "' correctamente";
                    String rMSG = "Usted ha eliminado " + r + " libro/s";
                    list.setModel(listModel);
                    listModel.removeAllElements();
                    listModel.addElement(lMSG);
                    listModel.addElement(rMSG);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    private boolean isValidINGRESAR() throws SQLException {
        if (tituloField.getText().isEmpty()) {
            String msg = "El TITULO no puede ser vacio";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (autorField.getText().isEmpty()) {
            String msg = "El AUTOR no puede ser vacio";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (generoField.getText().isEmpty()) {
            String msg = "El GENERO no puede ser vacio";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (!alquiladoField.getText().toLowerCase().equals("si") && !alquiladoField.getText().toLowerCase().equals("no")) {
            String msg = "Indique 'SI' o 'NO' en el campo ALQUILADO";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        // Define el patrón para buscar números
        Pattern tieneNumeros = Pattern.compile("\\d+");

        // Crea un objeto Matcher para buscar coincidencias en el texto
        Matcher matcher = tieneNumeros.matcher(tituloField.getText());

        // Verifica si se encontró al menos una coincidencia
        if (matcher.find()) {
            String msg = "El GENERO no puede tener numeros";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        LibroDAO libroDAO = new LibroDAOImpl();
        Libro libroExist = libroDAO.getByTitulo(tituloField.getText());
        if (libroExist != null && libroDAO.getByTitulo(tituloField.getText()).getTitulo().equals(tituloField.getText().toLowerCase())) {
            String msg = "El TITULO ya fue ingresado";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        return true;
    }

    private boolean isValidALQUILAR() throws SQLException {
        if (tituloField.getText().isEmpty()) {
            String msg = "El TITULO no puede ser vacio";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        LibroDAO libroDAO = new LibroDAOImpl();
        Libro l = libroDAO.getByTitulo(tituloField.getText());
        if (l == null) {
            String msg = "El TITULO no existe";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (l.isAlquilado()) {
            String msg = "El libro ya esta alquilado";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (!alquiladoField.getText().toLowerCase().equals("si") && !alquiladoField.getText().toLowerCase().equals("no")) {
            String msg = "Indique 'SI' o 'NO' en el campo ALQUILADO";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        return true;
    }

    private boolean isValidBORRAR() throws SQLException {
        if (tituloField.getText().isEmpty()) {
            String msg = "El TITULO no puede ser vacio";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (autorField.getText().isEmpty()) {
            String msg = "El AUTOR no puede ser vacio";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (generoField.getText().isEmpty()) {
            String msg = "El GENERO no puede ser vacio";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        LibroDAO libroDAO = new LibroDAOImpl();
        Libro l = libroDAO.getByTitulo(tituloField.getText());
        if (l == null) {
            String msg = "El TITULO no existe";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        if (l.isAlquilado()) {
            String msg = "No puede borrar un libro alquilado";
            list.setModel(listModel);
            listModel.removeAllElements();
            listModel.addElement(msg);
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.setContentPane(ui.panel);
        ui.setTitle("CRUD de Libros");
        ui.setSize(400, 300);
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
        ui.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
