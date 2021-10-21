package com.example.pstlabstest.controller;

import com.example.pstlabstest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

//    private final UserService userService;
//
//    @PutMapping("/update/{userId}")
//    public void update(@PathVariable long userId, String firstName, String lastName) {
//        userService.update(userId, firstName, lastName);
//    }
}
