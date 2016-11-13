/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.gen.model;

/**
 *
 * @author azzuwan
 */
public class Project {
    
    private String name = null;
    private String path = null;
    private String language = null;
    private String framework = null;
    private String orm = null;
    private Database database = null;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the orm
     */
    public String getOrm() {
        return orm;
    }

    /**
     * @param orm the orm to set
     */
    public void setOrm(String orm) {
        this.orm = orm;
    }

    /**
     * @return the database
     */
    public Database getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(Database database) {
        this.database = database;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the framework
     */
    public String getFramework() {
        return framework;
    }

    /**
     * @param framework the framework to set
     */
    public void setFramework(String framework) {
        this.framework = framework;
    }
}
