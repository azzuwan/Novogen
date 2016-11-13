/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.gen.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azzuwan
 */
public class PostgresConnection implements DbConnection {
    private static PostgresConnection instance = null;
    private static Connection conn;
    private static String url;
    protected PostgresConnection(){
        try {
            conn = DriverManager.getConnection(PostgresConnection.url);
        } catch (SQLException ex) {
            Logger.getLogger(MariaDbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static PostgresConnection getInstance(String url){
        PostgresConnection.url = url;
        if(instance == null){
            instance = new PostgresConnection();
        }
        
        return instance;
    }
    @Override
    public Connection getConnection() {
        return PostgresConnection.conn;
    }
    
}
