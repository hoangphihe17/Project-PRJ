/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dal;




import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class DBContext {
    public Connection connection;

    public DBContext() {
        try {
            // Change the username, password, and url to connect to your own database
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://DESKTOP-IAKAI6G\\SQLEXPRESS:1433;databaseName=PRJ301_Project";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try  {
            DBContext dbContext = new DBContext();
            if (dbContext.connection != null && !dbContext.connection.isClosed()) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
