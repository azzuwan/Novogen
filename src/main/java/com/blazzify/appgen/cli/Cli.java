/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen.cli;

import com.blazzify.appgen.model.Project;
import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author azzuwan
 */
public class Cli {

    private Project project;

    /**
     * 
     * @param config_file The JSON project config file
     */
    public Cli(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: gen config_file");
        } else {
            try {

                String configPath = args[0];
                Gson gson = new Gson();
                String json = new String(Files.readAllBytes(Paths.get(configPath)));
                System.out.println(json);

                Project p = gson.fromJson(json, Project.class);
                this.project = p;

            } catch (IOException ex) {
                Logger.getLogger(Cli.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param projectConfig the project to set
     */
    public void setProject(Project project) {
        this.project = project;
    }

}
