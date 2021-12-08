package kata5p1.Introduccion;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBD {
    
    public static void createNewDatabase(String fileName){
        String url = "jdbc:sqlite:" + fileName;
        
        try (Connection conn = DriverManager.getConnection(url)){
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("El driver es " + meta.getDriverName());
                System.out.println("Se ha creado una nueva BD.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void createNewTable() {
        // Cadena de conexión SQLite
        String url = "jdbc:sqlite:kata5.db";
        
        // Instrucción SQL para crear nueva tabla
        String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
                   + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
                   + " Mail text NOT NULL);";
        
        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            
            // Se crea la nueva tabla
            stmt.execute(sql);
            System.out.println("Tabla creada");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
