import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Itiz {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/itiz";
        String user = "admin";
        String password = "123456";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa");

            statement = connection.createStatement();

            String query1 = "SELECT * FROM direccion.directivos";
            resultSet = statement.executeQuery(query1);

            System.out.println("Directivos:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Departamento" + resultSet.getString("departamento"));
                System.out.println("Correo" + resultSet.getString("correo"));
            }
            resultSet.close();

            String query2 = "select e.id as estudiante_id, e.no_control, e.nombre as nombre_estudiante, e.carrera, e.edad, e.semestre, e.correo as correo_estudiante, d.id AS directivo_id, d.nombre as nombre_directivo, d.departamento, d.correo as correo_directivo from gestion_escolar.estudiantes e full join direccion.directivos d on e.correo = d.correo;";
            resultSet = statement.executeQuery(query2);

            System.out.println("Producto");
            while (resultSet.next()) {
                System.out.println("-------------------------------------------");
                System.out.println("ID Estudiante: " + resultSet.getString("estudiante_id"));
                System.out.println("No. Control: " + resultSet.getString("no_control"));
                System.out.println("Nombre Estudiante: " + resultSet.getString("nombre_estudiante"));
                System.out.println("Carrera: " + resultSet.getString("carrera"));
                System.out.println("Edad: " + resultSet.getString("edad"));
                System.out.println("Semestre: " + resultSet.getString("semestre"));
                System.out.println("Correo Estudiante: " + resultSet.getString("correo_estudiante"));
                System.out.println("--------------------------------------");
                System.out.println("ID Directivo: " + resultSet.getString("directivo_id"));
                System.out.println("Nombre Directivo: " + resultSet.getString("nombre_directivo"));
                System.out.println("Departamento: " + resultSet.getString("departamento"));
                System.out.println("Correo Directivo: " + resultSet.getString("correo_directivo"));
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
