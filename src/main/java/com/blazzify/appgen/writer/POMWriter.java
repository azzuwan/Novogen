/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blazzify.appgen.writer;

import com.blazzify.appgen.model.Project;

/**
 *
 * @author azzuwan
 */
public class POMWriter {
    private Project project;

    public POMWriter(Project project) {
        this.project = project;
    }
    
    
    /**
     * @return the project
     */
    public Project getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(Project project) {
        this.project = project;
    }
    
    
}
