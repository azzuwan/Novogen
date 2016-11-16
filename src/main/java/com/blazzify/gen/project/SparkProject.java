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
package com.blazzify.gen.project;

import com.blazzify.gen.db.Database;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class SparkProject implements Project {
    
    private String name = null;
    private String path = null;
    private String language = null;
    private String framework = null;
    private String orm = null;
    private Database database = null;

    /**
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the language
     */
    @Override
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    @Override
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the orm
     */
    @Override
    public String getOrm() {
        return orm;
    }

    /**
     * @param orm the orm to set
     */
    @Override
    public void setOrm(String orm) {
        this.orm = orm;
    }

    /**
     * @return the database
     */
    @Override
    public Database getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    @Override
    public void setDatabase(Database database) {
        this.database = database;
    }

    /**
     * @return the path
     */
    @Override
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    @Override
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the framework
     */
    @Override
    public String getFramework() {
        return framework;
    }

    /**
     * @param framework the framework to set
     */
    @Override
    public void setFramework(String framework) {
        this.framework = framework;
    }
}
