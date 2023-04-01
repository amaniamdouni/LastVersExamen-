package com.example.demo.Service;

import com.example.demo.Entitys.Project;

import java.util.List;

public interface ProjetService {
     void addProject(Project project);
     List<Project> getAllCurrentProject() ;
     List<Project> getProjectsByScrumMaster(String fName, String lName);
}
