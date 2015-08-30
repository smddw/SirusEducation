/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suranga
 */
public class DBManager {
    
    static Connection connection; 
    
    public static void connect(String location, String username, String password) throws SQLException{
       
            connection = DriverManager.getConnection(location,username,password);
        
    } 
    
    
    public static ResultSet getResultSet(String query) throws SQLException{
    
        ResultSet resultSet = null; 
             
       
            Statement statement = connection.createStatement();
            resultSet =  statement.executeQuery(query);
            
                             
        return resultSet; 
    
    } 
    
    public static void execute(String query) throws SQLException{
          
             Statement statement = connection.createStatement();
             int row = statement.executeUpdate(query);
    
    } 
    
    public static PreparedStatement getPreparedStatement(String sql) throws SQLException{
    
        return connection.prepareStatement(sql);
    }
    
    public static void execute(PreparedStatement statement) throws SQLException{
    
        int row = statement.executeUpdate();
            
    }
    
    
    }
    
    
    
    
