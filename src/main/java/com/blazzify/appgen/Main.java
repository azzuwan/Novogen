/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen;

import com.blazzify.appgen.cli.Cli;
import com.blazzify.appgen.generator.Generator;
import com.blazzify.appgen.generator.GeneratorFactory;
import com.blazzify.appgen.model.Project;

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
        Generator gen  = GeneratorFactory.createGenerator(project);
        gen.generate();
        
    }

}
