import java.sql.*;

// Patron SINGLETON para crear solo una connecion a la base de datos
public class Database {

    // URL de la base de datos en MySQL en Railway (no se debe harcodear pero a fines del proyecto es util)
    private static final String URL = "jdbc:mysql://root:-dBebFg2af4F-aChCFCBe36a352c2Ebf@roundhouse.proxy.rlwy.net:40002/railway";

    private Database() {
    }

    public static Connection getConexion() throws SQLException {
        Connection conexion = DriverManager.getConnection(URL);
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