package com.proj.neo4j.basic.service;

import com.proj.neo4j.basic.model.User;
import com.proj.neo4j.basic.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired UserRepo userRepo;
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(Long userId,User user) {
        User u = userRepo.findByUserId(userId);
        u.setAge(user.getAge());
        u.setName(user.getName());
        u.setPassword(user.getPassword());
        u.setMobileNumber(user.getMobileNumber());
        return userRepo.save(u);
    }

    public User getUserByUserId(Long userId) {
        return userRepo.findByUserId(userId);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User deleteUser(Long userId) {
        User u = userRepo.findByUserId(userId);
        userRepo.delete(u);
        return u;
    }
}
