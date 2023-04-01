package com.example.demo.Controller;


import com.example.demo.Entitys.Project;
import com.example.demo.Service.ProjetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
@RequiredArgsConstructor

public class ProjectController {
    @Autowired
    ProjetService projetService;
    @PostMapping("/addProject")
    public void addProject (@RequestBody Project project){
        projetService.addProject(project);
    }

    @GetMapping("/allCurrentProject")
    public List<Project> getAllCurrentProject() {
        return projetService.getAllCurrentProject();
    }
    @GetMapping("/getProjBySM")
    public List<Project> getProjectsByScrumMaster(String fName, String lName){
        return projetService.getProjectsByScrumMaster(fName,lName);
    }


}
