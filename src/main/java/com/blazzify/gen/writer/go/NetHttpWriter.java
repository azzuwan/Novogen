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
package com.blazzify.gen.writer.go;

import com.blazzify.gen.project.GoProject;
import com.blazzify.gen.project.Project;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class NetHttpWriter extends AbstractGoWriter {

    public NetHttpWriter(Project project, List<Table> tables) {
        this.project = (GoProject) project;
        this.tables = tables;
    }

    @Override
    public void write() throws IOException {        
        String generatedPath = project.getPath() + "/" + getProject().getName(); 
        Map model = new HashMap();
        model.put("project", project);
        model.put("tables", tables);
        
        String dbTpl = "templates/go/nethttp/db.twig";
        generateFile(generatedPath, "db.go", dbTpl, model);
        
        String serverTpl = "templates/go/nethttp/server.twig";
        generateFile(generatedPath, "server.go", serverTpl, model);
    }

}
