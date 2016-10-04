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
import com.blazzify.appgen.writer.CodeWriter;
import com.blazzify.appgen.model.Database;
import com.blazzify.appgen.model.Project;
import com.blazzify.appgen.cli.CommandHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.metamodel.DataContext;
import org.apache.metamodel.DataContextFactory;
import org.apache.metamodel.schema.Column;
import org.apache.metamodel.schema.Schema;
import org.apache.metamodel.schema.Table;

public class SparkGenerator {

    public static void main(String[] args) throws SQLException, IOException {

        //Get current execution path
        final String dir = System.getProperty("user.dir");
        System.out.println("Excuting in directory: " + dir);

        CommandHandler cli = new CommandHandler(args);
        Project project = cli.getProject();
        Database database = project.getDatabase();
        String projectName = project.getName();
        String projectPath = project.getPath();
        String language = project.getLanguage();

        String host = database.getHost();
        String db = database.getSchema();
        String user = database.getUser();
        String pass = database.getPassword();
        
        //TODO: Change to a connection factory 
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + pass);
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
        CodeWriter cw = new CodeWriter(project, tableList);
        cw.write();
    }

}
