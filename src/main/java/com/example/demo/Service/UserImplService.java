package com.example.demo.Service;

import com.example.demo.Entitys.Project;
import com.example.demo.Entitys.User;
import com.example.demo.Repository.ProjetRepository;
import com.example.demo.Repository.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImplService implements UserService{
    @Autowired
    private UserRepositroy userRepositroy;
    @Autowired
    private ProjetRepository projetRepository;


    @Override
    public void addUser(User user) {
        userRepositroy.save(user);
    }

    @Override
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projetRepository.findById(projectId).orElse(null);
        User user = userRepositroy.findById(userId).orElse(null);
        Assert.notNull(project,"project must be null");
        Assert.notNull(user,"user must be null");
        List<User> users = new ArrayList<>();
        project.getUser();
        users.add(user);
        projetRepository.save(project);
    }

    @Override
    public void assignProjectToClient(int projectId, String firstName, String lastName) {

        Project project=projetRepository.findById(projectId).orElse(null);
        User user=userRepositroy.findUserByFirstNameAndLastName(firstName,lastName);
        if (user!=null && user.getRole().equals("CLIENT") && project!=null)
        {
            project.setUser(user);
            projetRepository.save(project);
        }
    }
}
