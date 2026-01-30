package com.demo.first_spring_boot.app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private Map<Integer,User> userDb = new HashMap<>();

    @GetMapping
    public List<User> getUser(){
        return new ArrayList<>(userDb.values());
    }

    @PostMapping
    public String createUser(@RequestBody User user){
        userDb.putIfAbsent(user.getId(),user);
        System.out.println("New User Created "+user.getId()+" "+user.getEmail());
        return "User Created";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        if (userDb.containsKey(user.getId())) {
            userDb.put(user.getId(), user);
        }
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        if (userDb.containsKey(id))
            return "User Not Found";
        userDb.remove(id);
        return "User deleted";
    }
}
