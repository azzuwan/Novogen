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
class ExpressGenerator implements Generator {
    private Project project;

    public ExpressGenerator(Project project) {
        this.project = project;
    }

    @Override
    public void generate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
