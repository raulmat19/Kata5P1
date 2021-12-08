package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class Kata5P1 {

    public static void main(String[] args) {
       
       String db = "kata5.db";
       String filename = "email.txt";
       Connection conn = connect(db);
       List<String> mailList = MailListReader.read(filename);
       insert(mailList, db, conn);
       
    }
       

    public static void insert(List<String> mailList, String db, Connection conn) {
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";
        
        for (String email : mailList) {
            try (
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, email);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    private static Connection connect(String db) {
        // Cadena de conexión SQLite
        String url = "jdbc:sqlite:" + db;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
        
}
