/*
 * The MIT License
 *
 * Copyright 2016 Azzuwan Aziz <azzuwan@gmail.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.blazzify.gen.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
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
