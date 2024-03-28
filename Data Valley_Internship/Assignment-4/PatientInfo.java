import java.sql.*;

public class PatientInfo{
    // JDBC URL, username, and password of Oracle database
    static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Register JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Open a connection
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT id, name, problem, bill FROM patients";
            rs = stmt.executeQuery(sql);

            // Display patient information
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String problem = rs.getString("problem");
                double bill = rs.getDouble("bill");

                // Display values
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Problem: " + problem);
                System.out.println("Bill: " + bill);
                System.out.println();
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}