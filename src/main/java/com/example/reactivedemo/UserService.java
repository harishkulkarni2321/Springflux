package com.example.reactivedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Flux<UserDto> getUser(){
        return  userRepository.findAll().map(AppUtils::entityToDto);
    }

    public Mono<UserDto> getUser(Integer id){
        return userRepository.findById(id).map(AppUtils::entityToDto);
    }

    public Mono<User> saveProduct(Mono<UserDto> user){
        return user.map(AppUtils::DtoToEntity).flatMap(userRepository::insert);
    }
}
