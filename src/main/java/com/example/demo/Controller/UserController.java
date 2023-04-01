package com.example.demo.Controller;


import com.example.demo.Entitys.User;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserService userService ;
    @PostMapping("/addUser")
    public void addUser(@RequestBody User user)
    {
        userService.addUser(user);
    }

    @PostMapping("/addProjectToUser")
    public void assignProjectToUser (@PathVariable int projectId, int userId){
        userService.assignProjectToUser(projectId,userId);
    }
    @PostMapping("/addProjectToClient")
    public void assignProjectToClient(@PathVariable int projectId, @RequestBody String firstName, String lastName){
        userService.assignProjectToClient(projectId ,firstName ,lastName );
    }
}
