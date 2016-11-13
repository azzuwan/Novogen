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
public class MysqlConnection implements DbConnection {
    private static MysqlConnection instance = null;
    private static Connection conn;
    private static String url;
    protected MysqlConnection(){
        try {
            conn = DriverManager.getConnection(MysqlConnection.url);
        } catch (SQLException ex) {
            Logger.getLogger(MariaDbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MysqlConnection getInstance(String url){
        MysqlConnection.url = url;
        if(instance == null){            
            instance = new MysqlConnection();            
        }        
        return instance;
    }

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
