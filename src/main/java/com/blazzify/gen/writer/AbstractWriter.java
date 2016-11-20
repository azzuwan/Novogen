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

import com.blazzify.gen.project.Project;
import com.blazzify.gen.pebble.PebbleExtension;
import com.blazzify.gen.pebble.filter.SingularFilter;
import com.blazzify.gen.pebble.filter.StringCaseFilter;
import com.blazzify.gen.pebble.filter.go.DataTypeFilter;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public abstract class AbstractWriter implements Writer {

    protected Project project;
    protected List<Table> tables;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }
    
    protected void generate(String path, String name, String templatePath, Map model){
        try {
            String pathString = path + "/" + name;
            System.out.println("Creating " + pathString);
            Path filePath = Paths.get(pathString);
            Files.createDirectories(filePath.getParent());
            PebbleExtension extension = new PebbleExtension();
            
            extension.getFilters().put("data_type", new DataTypeFilter());
            extension.getFilters().put("camel_case", new StringCaseFilter());
            extension.getFilters().put("singular", new SingularFilter());
            
            PebbleEngine engine = new PebbleEngine.Builder().extension(extension).build();
            
            PebbleTemplate template = engine.getTemplate(templatePath);
            java.io.Writer writer = new FileWriter(path + "/" + name);
                        
            template.evaluate(writer, model);
            System.out.println(writer.toString());            
            writer.close();
            
        } catch (PebbleException | IOException ex) {
            Logger.getLogger(AbstractWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
