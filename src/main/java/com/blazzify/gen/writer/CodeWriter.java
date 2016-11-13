/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.gen.writer;

import com.blazzify.gen.generator.SparkGenerator;
import com.blazzify.gen.model.Project;
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
 * @author azzuwan
 */
public class CodeWriter {
    private Project project;   
    private List<Table> tables;

    public CodeWriter(Project project, List<Table> tables) {
        this.project = project;
        this.tables = tables;
    }

    public void write() throws IOException {

        final String dir = System.getProperty("user.dir");
        JtwigTemplate template = JtwigTemplate.fileTemplate(dir + "/templates/java/spark/spark.twig");
        JtwigModel model = JtwigModel.newModel().with("tables", getTables());
        String generatedPath = project.getPath() + "/projects/" + getProject().getLanguage() + "/" + getProject().getName();
        String indexFile = generatedPath + "/server.java";
        System.out.println("Full generation path: " + indexFile);
        Path path = Paths.get(indexFile);
        Files.createDirectories(path.getParent());
        File file = new File(indexFile);
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SparkGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        template.render(model, fos);
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

    /**
     * @return the tables
     */
    public List<Table> getTables() {
        return tables;
    }

    /**
     * @param tables the tables to set
     */
    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

}
