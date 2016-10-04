/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen.generator;


import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import com.blazzify.appgen.model.Project;
import com.blazzify.appgen.model.Database;
import java.nio.file.Path;

/**
 *
 * @author azzuwan
 */
public class SlimGenerator implements Generator {
    public static void main(String[] args) throws SQLException, IOException {
        //Get current execution path
        final String dir =  System.getProperty("user.dir");
        System.out.println("Excuting in directory: " + dir);
        String configPath = args[0];        
        Gson gson = new Gson();        
        String json = new String(Files.readAllBytes(Paths.get(configPath)));
        System.out.println(json);        
        
        Project project = gson.fromJson(json, Project.class);        
        Database database =  project.getDatabase();
        String projectName = project.getName();
        String projectPath = project.getPath();
        String projectLanguage = project.getLanguage();                
        String generatedPath = dir + "/projects/" + projectLanguage + "/" + projectName;
        
        
        String host = database.getHost();
        String db = database.getSchema();
        String user = database.getUser();
        String pass = database.getPassword();
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://"+host+"/" + db + "?user=" + user + "&password=" + pass);
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
        
        JtwigTemplate template = JtwigTemplate.fileTemplate(dir + "/templates/spark/test.twig");
        JtwigModel model = JtwigModel.newModel().with("tables", tableList);
        
        String fullGenerationPath = generatedPath + "/server.java";
        System.out.println("Full generation path: " + fullGenerationPath);
        Path path = Paths.get(fullGenerationPath);        
        Files.createDirectories(path.getParent());        
        File file = new File(fullGenerationPath);
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SparkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }                
        template.render(model, fos );
    }

    @Override
    public void generate(Project project) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
