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
public class GoProject implements Project{
    private String name;
    private String path;
    private String language;
    private String framework;
    private String orm;
    private Database database;

    public GoProject(String name, String path, String language, String framework, String orm, Database Database) {
        this.name = name;
        this.path = path;
        this.language = language;
        this.framework = framework;
        this.orm = orm;
        this.database = Database;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String getFramework() {
        return framework;
    }

    @Override
    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public String getOrm() {
        return orm;
    }

    @Override
    public void setOrm(String orm) {
        this.orm = orm;
    }

    @Override
    public Database getDatabase() {
        return database;
    }

    @Override
    public void setDatabase(Database Database) {
        this.database = Database;
    }
    
    

    
}
