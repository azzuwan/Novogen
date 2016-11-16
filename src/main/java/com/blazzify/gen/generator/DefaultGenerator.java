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
package com.blazzify.gen.generator;

import com.blazzify.gen.connection.ConnectionFactory;
import com.blazzify.gen.db.Database;
import com.blazzify.gen.project.Project;
import com.blazzify.gen.writer.Writer;
import com.blazzify.gen.writer.WriterFactory;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.jdbc.JdbcDataContext;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class DefaultGenerator<P extends Project> implements Generator{
    private P project;
    
    public DefaultGenerator(P project){
        this.project = project;
    }
    
    @Override
    public void generate() {
        try {
            //Get current execution path
            final String dir = System.getProperty("user.dir");
            System.out.println("Excuting in directory: " + dir);
            
            Database database = this.project.getDatabase();           
            String db = database.getSchema();            
            Connection conn = ConnectionFactory.create(database);
            DataContext dataContext = new JdbcDataContext(conn);
            
            List<Schema> schemaList = new ArrayList<>();
            List<Table> tableList = new ArrayList<>();
            List<Column> columnList = new ArrayList<>();
            
            //Traverse database
            Schema[] schemas = dataContext.getSchemas();
            schemaList = Arrays.asList(schemas);
            
            for (Schema schema : schemas) {
                System.out.println("Schema: " + schema.getName());
                
                if (schema.getName().equals(db)) {
                    
                    Table[] tables = schema.getTables();
                    tableList = Arrays.asList(tables);
                    
                    for (Table table : tables) {
                        System.out.println("    Table: " + table.getName());
                        
                        Column[] columns = table.getColumns();
                        columnList = Arrays.asList(columns);
                        for (Column column : columns) {
                            System.out.println("        Column: " + column.getName());
                        }
                    }
                }
            }
            
            System.out.println("table list: " + tableList.size());
            Writer writer = WriterFactory.createWriter(this.project, tableList);
            writer.write();
        } catch (IOException ex) {
            Logger.getLogger(DefaultGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
