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
package com.blazzify.gen.writer;

import com.blazzify.gen.project.GoProject;
import com.blazzify.gen.project.Project;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.schema.Table;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class GoWriter implements Writer{
    private GoProject project;
    List<Table> tables;

    public GoProject getProject() {
        return project;
    }

    public void setProject(GoProject project) {
        this.project = project;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    GoWriter(Project project, List<Table> tables) {
        this.project = (GoProject) project;
        this.tables = tables;
    }

    @Override
    public void write() throws IOException {
        
        
        JtwigTemplate indexTemplate = JtwigTemplate.classpathTemplate("templates/go/nethttp/server.go");
        JtwigTemplate dbTemplate = JtwigTemplate.classpathTemplate("templates/go/nethttp/db.go");
        JtwigModel model = JtwigModel.newModel().with("tables", getTables());
        
        String generatedPath = project.getPath() + "/" + getProject().getName();
        
        String indexFilePathString = generatedPath + "/server.go";
        String dbFilePathString = generatedPath +"/db.go";
        System.out.println("Full generation path: " + indexFilePathString);
        
        Path indexFilePath = Paths.get(indexFilePathString);
        Path dbFilePath = Paths.get(dbFilePathString);
        
        Files.createDirectories(indexFilePath.getParent());
        Files.createDirectories(dbFilePath.getParent());
        
        File indexFile = new File(indexFilePathString);
        File dbFile = new File(dbFilePathString);
        
        FileOutputStream indexStream = null;
        FileOutputStream dbStream = null;

        try {
            indexStream = new FileOutputStream(indexFile);
            dbStream = new FileOutputStream(dbFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DefaultWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        indexTemplate.render(model, indexStream);
        dbTemplate.render(model, dbStream);
    }
    
}
