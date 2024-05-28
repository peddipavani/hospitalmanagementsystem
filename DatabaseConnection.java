import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hospital_management?useSSL=false&serverTimezone=UTC";
    private static final String DATABASE_USER = "root"; // Your MySQL username
    private static final String DATABASE_PASSWORD = "Pavani@123456"; // Your MySQL password

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include the connector JAR in the classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred while connecting to the database.");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

