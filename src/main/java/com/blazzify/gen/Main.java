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
package com.blazzify.gen;

import com.blazzify.gen.cli.Cli;
import com.blazzify.gen.generator.GeneratorFactory;
import com.blazzify.gen.project.Project;

/**
 *
 * @author Azzuwan Aziz  <azzuwan@gmail.com>
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
