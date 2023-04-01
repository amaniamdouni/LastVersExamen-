package com.example.demo.Service;

import com.example.demo.Entitys.Project;
import com.example.demo.Entitys.User;

public interface UserService {
     void addUser(User user);
     void assignProjectToUser (int projectId, int userId);
     void assignProjectToClient(int projectId, String firstName, String lastName);

}
