import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        crearTabla();
    }

    public static void crearTabla() {
        String sql = "CREATE TABLE libro ("
                + "titulo VARCHAR(255) PRIMARY KEY,"
                + "autor VARCHAR(255) NOT NULL,"
                + "genero VARCHAR(255) NOT NULL,"
                + "alquilado BOOLEAN NOT NULL"
                + ");";

        try (Connection connection = Database.getConexion()) {
             Statement statement = connection.createStatement();

            // Ejecutar la consulta
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
