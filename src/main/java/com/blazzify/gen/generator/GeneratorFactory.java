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
package com.blazzify.gen.generator;

import com.blazzify.gen.project.ExpressProject;
import com.blazzify.gen.project.GoProject;
import com.blazzify.gen.project.Project;
import com.blazzify.gen.project.SparkProject;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class GeneratorFactory {
    public static Generator createGenerator(Project project){
        String framework = project.getFramework();
        Generator generator = null;
        switch (framework.toLowerCase()){
            
            case "go":
                generator = new DefaultGenerator<>((GoProject) project);
                break;
                
            case "spark":
                generator = new DefaultGenerator<>((SparkProject) project);
                break;
                
            case "express":
                generator = new DefaultGenerator<>((ExpressProject) project);
                break;
                
            default:
                throw new UnsupportedOperationException("Framework " + framework + "not supported yet");
        }
        
        return generator;
    }
}
