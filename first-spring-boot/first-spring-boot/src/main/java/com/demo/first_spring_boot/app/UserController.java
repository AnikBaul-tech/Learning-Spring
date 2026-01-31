package com.demo.first_spring_boot.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<User> getUsers(){
        return new ArrayList<>(userDb.values());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user){
        userDb.putIfAbsent(user.getId(),user);
        System.out.println("New User Created "+user.getId()+" "+user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }

    @PutMapping
    public  ResponseEntity<User> updateUser(@RequestBody User user){
        if (!userDb.containsKey(user.getId()))
            return new ResponseEntity<>(user , HttpStatus.NOT_FOUND);

        userDb.put(user.getId(), user);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        if (!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userDb.remove(id);
        return ResponseEntity.ok("User Deleted");
    }

//    @GetMapping("/user","/user/{userId}")

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(value = "userId",required = false) int id){
        if (!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userDb.get(id));
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(@PathVariable("userId") int id,@PathVariable(required = false)  int orderId){
        if (!userDb.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userDb.get(id));
    }
}
