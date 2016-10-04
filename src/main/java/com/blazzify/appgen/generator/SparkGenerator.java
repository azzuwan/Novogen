/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen.generator;

/**
 *
 * @author azzuwan
 */
import com.blazzify.appgen.connection.ConnectionFactory;
import com.blazzify.appgen.writer.CodeWriter;
import com.blazzify.appgen.model.Database;
import com.blazzify.appgen.model.Project;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

public class SparkGenerator implements Generator {
    private Project project;
    public SparkGenerator(Project project) {
        this.project = project;
    }
   
    @Override
    public void generate() {
        try {
            //Get current execution path
            final String dir = System.getProperty("user.dir");
            System.out.println("Excuting in directory: " + dir);
            
            Database database = this.project.getDatabase();
            String projectName = this.project.getName();
            String projectPath = this.project.getPath();
            String language = this.project.getLanguage();
            
            String host = database.getHost();
            String db = database.getSchema();
            String user = database.getUser();
            String pass = database.getPassword();
            
            //TODO: Change to a connection factory
            Connection conn = ConnectionFactory.create(database);
            DataContext dataContext = DataContextFactory.createJdbcDataContext(conn);
            
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
            CodeWriter cw = new CodeWriter(this.project, tableList);
            cw.write();
        } catch (IOException ex) {
            Logger.getLogger(SparkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project = project;
    }

}
