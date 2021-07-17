package com.example.reactivedemo;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Democontroller {

  @Autowired
  private UserService userService;

    @GetMapping("/getuser")
    public User getUser(){
        User user =new User();
        user.setId("1");
        user.setName("test");

        return user;
    }


    @GetMapping
    public Flux<UserDto> users(){
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public Mono<UserDto> getUser(@PathVariable Integer id){
        return userService.getUser(id);
    }

    @PostMapping("/saveUser")
    public Mono<User> saveuser(@RequestBody  Mono<UserDto> user){
        return userService.saveProduct(user);
    }
}
