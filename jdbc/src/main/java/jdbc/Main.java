package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "root";

            Connection conn = DriverManager.getConnection(url, user, password);
                
            System.out.println("Conexión exitosa a la base de datos");

            Statement st = conn.createStatement();
                 
            ResultSet rs = st.executeQuery("SHOW TABLES");

                System.out.println("Tablas en la base de datos 'proyecto':");

                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " + rs.getString(1));
                }
                rs.close();
                st.close();
                conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver de MySQL. Asegúrate de tener la dependencia correcta.");
        } catch (SQLException e) {
            System.out.println("Error al conectar o ejecutar la consulta SQL:");
        }
    }
}