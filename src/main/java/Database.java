import java.sql.*;

// Patron SINGLETON para crear solo una connecion a la base de datos
public class Database {
    private static final String URL = "jdbc:mysql://localhost:33060/biblioteca";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "secret";

    private Database() {
    }

    public static Connection getConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        if (conexion != null) {
            System.out.println("Conexión exitosa");
        } else {
            System.out.println("Conexión fallida");
        }
        return conexion;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public static void closeStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }

}