/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen.generator;

import com.blazzify.appgen.model.Project;

/**
 *
 * @author azzuwan
 */
public class GeneratorFactory {
    public static Generator generate(Project project){
        String framework = project.getFramework();
        Generator generator = null;
        switch (framework.toLowerCase()){
            case "spark":
                generator = new SparkGenerator();
                break;
                
            case "slim":                
                generator = new SlimGenerator();
                break;
                
            case "laravel":
                generator = new LaravelGenerator();
                break;
                
            case "express":
                generator = new ExpressGenerator();
                break;
                
        
        }
        
        return generator;
    }
}
