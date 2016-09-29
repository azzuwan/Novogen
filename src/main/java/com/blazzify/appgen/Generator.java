/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author azzuwan
 */
public class Generator {

    public static void main(String[] args) throws SQLException {
        String host = args[0];
        String db   = args[1];
        String user = args[2];
        String pass = args[3];        
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/"+ db +"?user="+ user + "&password="+pass);
        DataContext dataContext = DataContextFactory.createJdbcDataContext(conn);
        
        
        //DOESNT WORK ON NEW MYSQL DRIVER
        // Using Mysql Connector 5+
        Schema[] schemas = dataContext.getSchemas();
        
        for (Schema schema: schemas) {
            System.out.println("Schema: " +schema.getName());
            
            Table[] tables = schema.getTables();
            for (Table table : tables){
                System.out.println("    Table: " + table.getName());
                
                Column[] columns = table.getColumns();                
                for(Column column : columns){
                    System.out.println("        Column: " + column.getName());
                }
                
            }
        }

    }
}
