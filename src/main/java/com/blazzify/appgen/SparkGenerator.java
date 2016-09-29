/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen;

/**
 *
 * @author azzuwan
 */
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
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

public class SparkGenerator {

    public static void main(String[] args) throws SQLException {

        // DB infos
        String host = args[0];
        String db = args[1];
        String user = args[2];
        String pass = args[3];        

        //DOESNT WORK ON NEW MYSQL DRIVER
        // Using Mysql Connector 5+
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?user=" + user + "&password=" + pass);
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
        JtwigTemplate template = JtwigTemplate.fileTemplate("/home/azzuwan/Projects/Tempoyak/tempoyak/templates/spark/test.twig");

        JtwigModel model = JtwigModel.newModel().with("tables", tableList);

        template.render(model, System.out);
    }

}
