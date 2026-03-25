package org.final_projet.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection connection_db() {
        
        Connection con = null;
        String url = "jdbc:mysql://localhost:3307/GestionEmploye";
        try {
            con = DriverManager.getConnection(url, "root", "");
            
        } catch (SQLException ex) {
            System.out.println("Connection echouee!" + ex.getMessage());
        }
        return con;
    }
}
