/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.gen;

import com.blazzify.gen.cli.Cli;
import com.blazzify.gen.generator.GeneratorFactory;
import com.blazzify.gen.model.Project;

/**
 *
 * @author azzuwan
 */
public class Main {
    
    public static void main(String[] args) {
         
        final String dir = System.getProperty("user.dir");        
        System.out.println("Excuting in directory: " + dir);
        Cli cli  = new Cli(args);        
        Project project = cli.getProject();        
        GeneratorFactory.createGenerator(project).generate();        
    }

}
