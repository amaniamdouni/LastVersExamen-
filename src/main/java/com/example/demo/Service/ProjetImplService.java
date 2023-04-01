package com.example.demo.Service;

import com.example.demo.Entitys.Project;
import com.example.demo.Entitys.Role;
import com.example.demo.Entitys.User;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.Repository.SprintRepository;
import com.example.demo.Repository.UserRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetImplService implements ProjetService {

    private final ProjetRepository projetRepository;
    private final UserRepositroy userRepositroy;
    private final SprintRepository sprintRepository;


    @Override
    public void addProject(Project project) {
        projetRepository.save(project);
    }

    @Override
    public List<Project> getAllCurrentProject() {
        LocalDate thisDay = LocalDate.now();
        List<Project> projects=projetRepository.findAllBySprintsStartdateGreaterThan(thisDay);
        return projects;
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String firstname, String lastname) {
        return projetRepository.findallByUserRoleAndUserFirstnameUserLastname(Role.SCRUM_MASTER,firstname,lastname);
    }

}
