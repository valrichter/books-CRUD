import java.sql.*;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:33060/prueba";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "secret";

    public static void main(String[] args) {
        try {
            // Registrar el controlador JDBC (asegúrate de haber agregado el JAR a tu proyecto)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            // Aquí puedes realizar operaciones en la base de datos...

            // Cerrar la conexión cuando hayas terminado
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}