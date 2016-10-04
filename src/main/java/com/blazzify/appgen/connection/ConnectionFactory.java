/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen.connection;

import com.blazzify.appgen.model.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azzuwan
 */
public class ConnectionFactory {
    public static Connection create(Database db){
        Connection conn = null;
        String type = db.getType().toLowerCase();        
        switch(type){
            case "mysql":
                conn = sqlConnection(db);
                break;
                
            case "postgresql":
                conn = sqlConnection(db);
                break;
                
           default:
               throw new UnsupportedOperationException("The connection type is not supported yet");               
        }        
        return conn;
    }
    
    private static Connection sqlConnection(Database db){
        Connection conn = null;
        try {
             conn = DriverManager.getConnection("jdbc:"+ db.getType().toLowerCase()+ "://"
                    + db.getHost().toLowerCase()
                    + "/" + db.getSchema().toLowerCase()
                    + "?user=" + db.getUser().toLowerCase()
                    + "&password=" + db.getPassword());            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}
