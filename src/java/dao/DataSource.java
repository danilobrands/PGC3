/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danil
 */
public class DataSource {
    private String hostname;
    private String username;
    private String password;
    private String database;
    private Connection connection;
    
    public DataSource(){
        try {
            hostname = "localhost";
            database = "gamehateos";
            username = "hateos";
            password = "hate0s";
            
            String URL = "jdbc:mysql://" + hostname+":3306/"+database+"?useTimezone=true&serverTimezone=UTC";
            //System.err.println("1");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //System.err.println("2");
            connection = DriverManager.getConnection(URL, username, password);
            //System.err.println("3");
            System.out.println("DataSource - Conected");
            
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar - " + ex.getMessage());
        }
        
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
}
