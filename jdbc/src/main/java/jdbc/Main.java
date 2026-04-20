package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/proyecto";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("SHOW TABLES")) {

                System.out.println("Conexión exitosa a la base de datos");
                System.out.println("Tablas en la base de datos 'proyecto':");

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " + rs.getString(1));
                }
                rs.close();
                st.close();
                conn.close();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontró el driver de MySQL. Asegúrate de tener la dependencia correcta.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error al conectar o ejecutar la consulta SQL:");
            e.printStackTrace();
        }
    }
}