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
package com.blazzify.gen.cli;

import com.blazzify.gen.exception.FrameworkNotSupportedExecption;
import com.blazzify.gen.project.ExpressProject;
import com.blazzify.gen.project.GoProject;
import com.blazzify.gen.project.Project;
import com.blazzify.gen.project.SparkProject;
import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.jayway.jsonpath.JsonPath;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class Cli {

    private Project project;

    /**
     * 
     * @param args     
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
                String framework = JsonPath.read(json, "$.framework");
                
                switch(framework){
                    
                    case "spark":                        
                        project = gson.fromJson(json, SparkProject.class);
                        break;
                        
                    case "nethttp":                        
                        project = gson.fromJson(json, GoProject.class);
                        break;
                        
                    case "express":
                        project = gson.fromJson(json, ExpressProject.class);
                        break;
                        
                    default:
                        throw new FrameworkNotSupportedExecption("Framework: "+framework+ " specified in project.json is not yet supported");
                }
                

            } catch (IOException ex) {
                Logger.getLogger(Cli.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FrameworkNotSupportedExecption ex) {
                System.out.println("Framework: specified in project.json is not yet supported");                
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
     * @param project     
     */
    public void setProject(Project project) {
        this.project = project;
    }

}
