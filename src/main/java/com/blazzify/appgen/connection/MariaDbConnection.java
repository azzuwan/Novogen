/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azzuwan
 */
public class MariaDbConnection implements DbConnection {
    
    private static MariaDbConnection instance = null;
    private static Connection conn;
    private static String url;
    protected MariaDbConnection(){
        try {
            conn = DriverManager.getConnection(MariaDbConnection.url);
        } catch (SQLException ex) {
            Logger.getLogger(MariaDbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MariaDbConnection getInstance(String url){
        MariaDbConnection.url = url;
        if(instance == null){            
            instance = new MariaDbConnection();
        }        
        return instance;
    }

    @Override
    public Connection getConnection() {
        return MariaDbConnection.conn;
    }
    
}
