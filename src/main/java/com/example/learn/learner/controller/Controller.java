package com.example.learn.learner.controller;

import com.example.learn.learner.entity.Users;
import com.example.learn.learner.links.UserLinks;
import com.example.learn.learner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping(path = UserLinks.LIST_USERS)
    public ResponseEntity<?> listUsers(@RequestParam(required = false, name = "page", defaultValue = UriConstant.DEFAULT_PAGE_NUMBER) Integer page,
                                       @RequestParam(required = false, name = "limit", defaultValue = UriConstant.DEFAULT_PAGE_LIMIT) Integer limit,
                                       @RequestParam(required = false, name = "sortBy", defaultValue = UriConstant.DEFAULT_SORT_PROPERTIES) String sortBy,
                                       @RequestParam(required = false, name = "sort", defaultValue = UriConstant.DEFAULT_PAGE_SORT) String sort) {
        System.out.println("Controller: List Users");
        return ResponseEntity.ok(userService.getUsers(page, limit, sort, sortBy));
    }

//    @GetMapping(path = UserLinks.LIST_USERS + "?limit={limit}")
//    public ResponseEntity<?> listUsers(@RequestParam int limit) {
//        System.out.println("Controller: List Users");
//        Page<Users> resources = userService.getUsers(limit);
//        return ResponseEntity.ok(resources);
//    }

    @PostMapping(path = UserLinks.ADD_USERS)
    public ResponseEntity<?> saveUser(@RequestBody Users user) {
        System.out.println("Controller: Saved Users");
        Users resources = userService.saveUser(user);
        return ResponseEntity.ok(resources);
    }
}
