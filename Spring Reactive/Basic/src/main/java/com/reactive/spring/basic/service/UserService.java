package com.reactive.spring.basic.service;

import com.reactive.spring.basic.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> createUser(User user);
    Mono<User> getSingleUser(int id);
    Mono<User> updateUser(int id, User user);
    Mono<User> deleteUser(int id);
    Flux<User> getAllUsers();
    Flux<User> getUserByName(String name);
    Flux<User> getUserByMobile(String mobile);
    Mono<String> findNameById(int id);
}
