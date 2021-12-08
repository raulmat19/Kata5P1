package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    
    private Connection connect() {
          
            Connection con = null;
            String url = "jdbc:sqlite:kata5.db";
            
            try{
                con = DriverManager.getConnection(url);

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } 
            
            return con;   
        }
        
        public void selectAll(){
            
            String sql = "SELECT * FROM PEOPLE";
            
            try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
                
                // Bucle sobre el conjunto de registros.
                while (rs.next()) {
                    System.out.println(rs.getInt("Id") + "\t" +
                                       rs.getString("Nombre") + "\t" +
                                       rs.getString("Apellidos") + "\t" +
                                       rs.getString("Departamento") + "\t");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

        }
    
}
