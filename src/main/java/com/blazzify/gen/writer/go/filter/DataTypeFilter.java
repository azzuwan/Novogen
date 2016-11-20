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
package com.blazzify.gen.writer.go.filter;

import com.blazzify.gen.exception.DataTypeNotSupportedException;
import com.mitchellbosecke.pebble.extension.Filter;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Azzuwan Aziz <azzuwan@gmail.com>
 */
public class DataTypeFilter implements Filter{

    @Override
    public Object apply(Object o, Map<String, Object> map) {
        String dataType;
        if(o == null){
            return null;
        }
        
        switch(o.toString()){            
            case "INTEGER":
                dataType = "uint";
                break;
            case "TINYINT":
                dataType = "uint";
                break;
            case "BIGINT":
                dataType = "uint";
                break;
            case "VARCHAR":
                dataType = "string";
                break;
            case "CHAR":
                dataType = "string";
                break;
            case "TEXT":
                dataType = "string";
                break;                
            case "DATE":
                dataType = "time.time";
                break;
            case "DATETIME":
                dataType = "time.time";
                break;
            case "TIMESTAMP":
                dataType = "string";
                break;
            case "BOOLEAN":
                dataType = "bool";
                break;
            case "FLOAT":
                dataType = "float32";
                break;
            default:
                dataType = null;
                throw new DataTypeNotSupportedException("Data Type " + o + " conversion to Go data type is not supported");                                
        }
        
        return dataType;
        
        
    }

    @Override
    public List<String> getArgumentNames() {
        return null;
    }
    
}
