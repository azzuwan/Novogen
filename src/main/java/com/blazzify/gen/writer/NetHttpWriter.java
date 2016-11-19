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
import java.io.IOException;
import java.util.List;
import org.apache.metamodel.schema.Table;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class NetHttpWriter extends AbstractWriter{
    NetHttpWriter(Project project, List<Table> tables) {
        this.project = (GoProject) project;
        this.tables = tables;
    }

    @Override
    public void write() throws IOException {        
        
        JtwigTemplate serverTpl = JtwigTemplate.classpathTemplate("templates/go/nethttp/server.twig");
        JtwigTemplate dbTpl = JtwigTemplate.classpathTemplate("templates/go/nethttp/db.twig");
        JtwigModel model = JtwigModel.newModel()
                .with("project", this.project)
                .with("tables", this.tables);
        
        String generatedPath = project.getPath() + "/" + getProject().getName();        
        generateFile(generatedPath, "server.go", serverTpl, model);
        generateFile(generatedPath, "db.go", dbTpl, model);
    }
    
}
