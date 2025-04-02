import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
class p20Con {
    public static void main(String[] args){
        String URL = "jdbc:postgresql://localhost:5432/p20";
        String USER = "admin";
        String PASS = "123456";
        Connection connection = null;
	    Statement statement = null;
	    ResultSet resultset = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS); /*Se crea la conexión */
            System.out.println("Exitosa"); 
            statement = connection.createStatement(); /* */
            String query = "select * from rh.materias_p20";
            resultset = statement.executeQuery(query); /*Mostra la consulta */
            System.out.println("resultset: " + resultset);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Primer consulta~~~~~~~~~~~~~~~~~~~~~~");
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]");
                System.out.println("[Nombre: " + resultset.getString("name_materias") + "]");
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Segunda consulta~~~~~~~~~~~~~~~~~~~~~");
            String query2 = "select * from rh.usuario_p20 ";
            resultset = statement.executeQuery(query2);
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]");
                System.out.println("[Nombre: " + resultset.getString("name") + "]");
                System.out.println("[Materia: " + resultset.getString("materias_20_id") + "]");
                System.out.println("[Edad: " + resultset.getString("edad") + "]");
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Tercer consulta~~~~~~~~~~~~~~~~~~~~~");
            String query3 = "select * from rh.usuario_p20 inner join rh.materias_p20 on usuario_p20.id=materias_p20.id";
            resultset = statement.executeQuery(query3);
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]"); 
                System.out.println("[Nombre: " + resultset.getString("name") + "]");
                System.out.println("[Edad: " + resultset.getString("edad") + "]");
                System.out.println("[Materia: " + resultset.getString("name_materias") + "]");
            }

        } catch (Exception e) {
            System.out.println("Conexion fallida"+e);
        }
    }
}