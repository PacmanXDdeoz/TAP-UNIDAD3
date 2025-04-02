import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Proveedor {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/proveedoresdb";
        String user = "admin";
        String password = "123456";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            statement = connection.createStatement();

            String query1 = "SELECT * FROM inventariodb.proveedor";
            resultSet = statement.executeQuery(query1);

            System.out.println("Proveedor:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Contacto" + resultSet.getString("contacto"));
                System.out.println("Telefono" + resultSet.getString("telefono"));
            }
            resultSet.close();

            String query2 = "select p.id as producto_id, p.nombre as producto_nombre, p.descripcion, p.precio, pr.id as proveedor_id, pr.nombre as proveedor_nombre, pr.contacto, pr.telefono from inventariodb.producto p inner join inventariodb.proveedor pr on p.proveedor_id = pr.id;";
            resultSet = statement.executeQuery(query2);

            System.out.println("Producto");
            while (resultSet.next()) {
                System.out.println("-------------------------------------------");
                System.out.println("ID Producto: " + resultSet.getInt("producto_id"));
                System.out.println("Nombre Producto: " + resultSet.getString("producto_nombre"));
                System.out.println("Descripción: " + resultSet.getString("descripcion"));
                System.out.println("Precio: $" + resultSet.getDouble("precio"));
                System.out.println("ID Proveedor: " + resultSet.getInt("proveedor_id"));
                System.out.println("Nombre Proveedor: " + resultSet.getString("proveedor_nombre"));
                System.out.println("Contacto: " + resultSet.getString("contacto"));
                System.out.println("Teléfono: " + resultSet.getString("telefono"));
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
