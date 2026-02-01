package com.demo.first_spring_boot.app.controller;

import com.demo.first_spring_boot.app.service.UserService;
import com.demo.first_spring_boot.app.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    public UserService userService = new UserService();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }

    @PutMapping
    public  ResponseEntity<User> updateUser(@RequestBody User user){
        User updated = userService.updateUser(user);
        if(updated == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if (!isDeleted)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok("User Deleted");
    }

//    @GetMapping("/user","/user/{userId}")

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(value = "userId",required = false) int id){
        User user = userService.getUserById(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(@PathVariable("userId") int id,@PathVariable(required = false)  int orderId){
        User user = userService.getUserById(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser(@RequestParam(required = false) String name){
        return ResponseEntity.ok(userService.searchUser(name));
    }

    @GetMapping("/info")
    public String getInfo(@RequestHeader("User-Agent") String userAgent){
        return userAgent;
    }
}
