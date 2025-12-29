package com.reactive.spring.basic.service;

import com.reactive.spring.basic.entity.User;
import com.reactive.spring.basic.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    @Override
    public Mono<User> createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Mono<User> getSingleUser(int id) {
        return userRepo.findById(id);
    }

    @Override
    public Mono<User> updateUser(int id, User user) {
        return userRepo.findById(id)
                 .flatMap(u->{
                    u.setMobile(user.getMobile());
                    u.setName(user.getName());
                    return userRepo.save(u);
                });
    }

    @Override
    public Mono<User> deleteUser(int id) {
        return userRepo.findById(id).flatMap(user -> userRepo.delete(user).thenReturn(user));
    }

    @Override
    public Flux<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public Flux<User> getUserByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public Flux<User> getUserByMobile(String mobile) {
        return userRepo.findByMobile();
    }

    @Override
    public Mono<String> findNameById(int id) {
        return userRepo.findNameById(id);
    }

}
