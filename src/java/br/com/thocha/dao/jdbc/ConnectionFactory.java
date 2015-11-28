package br.com.thocha.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() {
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager
                        .getConnection(
                                "jdbc:postgresql://localhost:5432/CalendarEvent?currentSchema=apis", 
                                "postgres", "918171"
                                );
            
            System.out.println("CONNECTION " + conn);
            return conn;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        
    }
}
