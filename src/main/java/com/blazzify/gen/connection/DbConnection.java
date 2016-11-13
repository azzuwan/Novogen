/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.gen.connection;

import java.sql.Connection;

/**
 *
 * @author azzuwan
 */
public interface DbConnection {

    /**
     *
     * @return Connection object
     */
    public Connection getConnection();
}
