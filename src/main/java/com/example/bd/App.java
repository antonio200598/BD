package com.example.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    private static String DB_URL = "jdbc:mysql://localhost/school";
    private static String DB_USER = "root";
    private static String DB_PASSWORD = "PQRnex379!!";
            
    public static void main(String[] args) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
                
                Connection conn = null;
                Statement stmt = null;
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
   
                stmt = conn.createStatement();
                String sqlCommand = "INSERT INTO students (name, email) VALUES ('mauricio', 'mauricio@gmail.com')";
                stmt.executeUpdate(sqlCommand, Statement.RETURN_GENERATED_KEYS);
                
                ResultSet rs = null;
                rs = stmt.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                id = rs.getInt(1);
                }

                conn.close();	
                System.out.println(" Id: " + id);
                
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
