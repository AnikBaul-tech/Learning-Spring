package com.demo.first_spring_boot.app.service;

import com.demo.first_spring_boot.app.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private Map<Integer, User> userDb = new HashMap<>();

    public List<User> getAllUser(){
        return new ArrayList<>(userDb.values());
    }

    public User createUser (User user){
        userDb.putIfAbsent(user.getId(), user);
        return user;
    }

    public User updateUser (User user){
        if (!userDb.containsKey(user.getId()))
            throw new IllegalArgumentException("User with"+user.getId()+"id not present");
        userDb.put(user.getId(), user);
        return user;
    }

    public boolean deleteUser(int userId){
        if (!userDb.containsKey(userId))
            return false;
        userDb.remove(userId);
        return true;
    }
    public User getUserById(int id){
        return userDb.get(id);
    }
    public List<User> searchUser(String name){
        return userDb.values().stream().filter(u -> u.getName().equalsIgnoreCase(name)).toList();

    }


}
