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
        
        String url = "jdbc:"+ db.getType().toLowerCase()+ "://"
                    + db.getHost().toLowerCase()
                    + "/" + db.getSchema().toLowerCase()
                    + "?user=" + db.getUser().toLowerCase()
                    + "&password=" + db.getPassword();
        
        switch(type){
            case "mysql":
                conn = MysqlConnection.getInstance(url).getConnection();
                break;
            case "mariadb":
                conn = MariaDbConnection.getInstance(url).getConnection();
                break;                
            case "postgresql":
                conn = PostgresConnection.getInstance(url).getConnection();
                break;
                
           default:
               throw new UnsupportedOperationException("The connection type is not supported yet");               
        }        
        return conn;
    }
}
