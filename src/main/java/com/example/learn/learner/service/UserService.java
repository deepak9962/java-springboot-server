package com.example.learn.learner.service;

import com.example.learn.learner.entity.Users;
import com.example.learn.learner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users saveUser(Users users) {
        System.out.println("UserService: Save user methode");
        return userRepository.save(users);
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Page<Users> getUsers(int page, int size, String sort, String... properties) {
        return userRepository.findAll(PageRequest.of(page, size, Sort.Direction.fromString(sort), properties));
    }

}
