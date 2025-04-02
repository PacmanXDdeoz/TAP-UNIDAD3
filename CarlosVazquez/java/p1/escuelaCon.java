import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
class escuelaCon {
    public static void main(String[] args){
        String URL = "jdbc:postgresql://localhost:5432/escuela";
        String USER = "admin";
        String PASS = "123456";
        Connection connection = null;
	    Statement statement = null;
	    ResultSet resultset = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS); /*Se crea la conexión */
            System.out.println("Exitosa"); 
            statement = connection.createStatement(); /* */
            String query = "select * from \"Alpha\".alumnos";
            resultset = statement.executeQuery(query); /*Mostra la consulta */
            System.out.println("resultset: " + resultset);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Primer consulta~~~~~~~~~~~~~~~~~~~~~~");
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]");
                System.out.println("[Nombre: " + resultset.getString("nombre") + "]");
                System.out.println("[CURP: " + resultset.getString("curp") + "]");
                System.out.println("[Genero: " + resultset.getString("genero") + "]");
                System.out.println("[Tutor: " + resultset.getString("tutor") + "]");
                System.out.println("[Telefono: " + resultset.getString("telefono") + "]");
                System.out.println("[Grupo: " + resultset.getString("id_grupo") + "]");
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Segunda consulta~~~~~~~~~~~~~~~~~~~~~");
            String query2 = "select * from \"Alpha\".docentes";
            resultset = statement.executeQuery(query2);
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]");
                System.out.println("[Nombre: " + resultset.getString("nombre_docente") + "]");
                System.out.println("[Edad: " + resultset.getString("edad") + "]");
                System.out.println("[RFC: " + resultset.getString("rfc") + "]");
                System.out.println("[Especialidad: " + resultset.getString("especialidad") + "]");
                System.out.println("[Telefono: " + resultset.getString("telefono") + "]");
                System.out.println("[Correo: " + resultset.getString("correo") + "]");
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Tercer consulta~~~~~~~~~~~~~~~~~~~~~");
            String query3 = "select * from \"Alpha\".horarios inner join \"Alpha\".alumnos on horarios.id=alumnos.id";
            resultset = statement.executeQuery(query3);
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]");
                System.out.println("[Nombre: " + resultset.getString("nombre") + "]");
                System.out.println("[CURP: " + resultset.getString("curp") + "]");
                System.out.println("[Genero: " + resultset.getString("genero") + "]");
                System.out.println("[Tutor: " + resultset.getString("tutor") + "]");
                System.out.println("[Telefono: " + resultset.getString("telefono") + "]");
                System.out.println("[Grupo: " + resultset.getString("id_grupo") + "]");
            }

        } catch (Exception e) {
            System.out.println("Conexion fallida"+e);
        }
    }
}