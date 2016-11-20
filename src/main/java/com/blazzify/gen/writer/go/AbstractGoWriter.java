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
package com.blazzify.gen.writer.go;

import com.blazzify.gen.writer.AbstractWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public abstract class AbstractGoWriter extends AbstractWriter {

    public void format(String path) {
       
        try {
            Process p = null;
            boolean isWindows = System.getProperty("os.name")
                    .toLowerCase().startsWith("windows");
            
            if (isWindows) {
                p = new ProcessBuilder(new String[]{"cmd.exe", "/c", "gofmt", path})
                        .inheritIO().start();
                        
                
            } else {
                p = new ProcessBuilder(new String[]{"gofmt", "-s", "-w", path})
                        .inheritIO().start();                
                
            }
            int exitCode = p.waitFor();
            System.out.println("EXIT CODE: " + exitCode);
            p.destroy();
                
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(AbstractGoWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
