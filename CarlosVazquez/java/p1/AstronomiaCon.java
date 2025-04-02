import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
class AstronomiaCon {
    public static void main(String[] args){
        String URL = "jdbc:postgresql://localhost:5432/Astronomia_Estudio";
        String USER = "admin";
        String PASS = "123456";
        Connection connection = null;
	    Statement statement = null;
	    ResultSet resultset = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS); /*Se crea la conexión */
            System.out.println("Exitosa"); 
            statement = connection.createStatement(); /* */
            String query = "select * from sistema_solar.estrellas";
            resultset = statement.executeQuery(query); /*Mostra la consulta */
            System.out.println("resultset: " + resultset);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Primer consulta~~~~~~~~~~~~~~~~~~~~~~");
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]");
                System.out.println("[Nombre: " + resultset.getString("namestar") + "]");
                System.out.println("[Masa: " + resultset.getString("masssolar") + "]");
                System.out.println("[Distancia de la tierra: " + resultset.getString("distanceearth") + "]");
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Segunda consulta~~~~~~~~~~~~~~~~~~~~~");
            String query2 = "select * from sistema_solar.planetas";
            resultset = statement.executeQuery(query2);
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]");
                System.out.println("[Nombre: " + resultset.getString("nameplanet") + "]");
                System.out.println("[Masa: " + resultset.getString("massplanet") + "]");
                System.out.println("[Tipo: " + resultset.getString("type_planet") + "]");
                System.out.println("[Estrella: " + resultset.getString("id_star") + "]");
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~Tercer consulta~~~~~~~~~~~~~~~~~~~~~");
            String query3 = "select * from sistema_solar.planetas inner join sistema_solar.estrellas on planetas.id=estrellas.id";
            resultset = statement.executeQuery(query3);
            while (resultset.next()) {
                System.out.println("[id: " + resultset.getInt("id") + "]"); 
                System.out.println("[Nombre: " + resultset.getString("nameplanet") + "]");
                System.out.println("[Masa: " + resultset.getString("massplanet") + "]");
                System.out.println("[Tipo: " + resultset.getString("type_planet") + "]");
                System.out.println("[id: " + resultset.getInt("id_star") + "]");
                System.out.println("[Nombre: " + resultset.getString("namestar") + "]");
                System.out.println("[Masa: " + resultset.getString("masssolar") + "]");
                System.out.println("[Distancia de la tierra: " + resultset.getString("distanceearth") + "]");
            }

        } catch (Exception e) {
            System.out.println("Conexion fallida"+e);
        }
    }
}
