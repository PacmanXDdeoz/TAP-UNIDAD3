import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practica {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/practica_danielan";
        String user = "admin";
        String password = "123456";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");
        
            statement = connection.createStatement();
        
            // Primera consulta: Departamentos
            String query1 = "SELECT id, nombre FROM catalogos.departamentos"; 
            resultSet = statement.executeQuery(query1);
        
            System.out.println("Departamentos:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre Departamento: " + resultSet.getString("nombre"));
            }
            resultSet.close();
        
            // Segunda consulta: CROSS JOIN de colores y departamentos
            String query2 = "SELECT c.nombre_color, d.id AS departamento_id, d.nombre AS nombre_departamento FROM catalogos.colores c CROSS JOIN catalogos.departamentos d";
            resultSet = statement.executeQuery(query2);
        
            System.out.println("Producto:");
            while (resultSet.next()) {
                System.out.println("Nombre Color: " + resultSet.getString("nombre_color"));
                System.out.println("ID Departamento: " + resultSet.getInt("departamento_id"));
                System.out.println("Nombre Departamento: " + resultSet.getString("nombre_departamento"));
                System.out.println("--------------------------------------------------");
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}