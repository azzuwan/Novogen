/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen;

import com.google.gson.Gson;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author azzuwan
 */
public class ProjectJSONReader {
    public static void main(String[] args) throws IOException {
        
        String path = args[0];        
        Gson gson = new Gson();        
        String json = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println(json);
    }
}
