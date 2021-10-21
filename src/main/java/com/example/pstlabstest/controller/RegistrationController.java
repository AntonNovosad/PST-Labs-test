package com.example.pstlabstest.controller;

import com.example.pstlabstest.dto.RegistrationRequestDto;
import com.example.pstlabstest.entity.Role;
import com.example.pstlabstest.entity.User;
import com.example.pstlabstest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/home")
@AllArgsConstructor
public class RegistrationController {

//    private final static String USER_EXIST_MSG = "user with email %s exist";
//    private final UserService userService;
//
//    @Value("${role.user}")
//    private String roleUser;

//    @PostMapping("/reg")
//    public ResponseEntity<?> registration(@RequestBody RegistrationRequestDto request) {
//        if (userService.findByEmail(request.getEmailDto()).isPresent()) {
//            return new ResponseEntity<>(String.format(USER_EXIST_MSG, request.getEmailDto()), HttpStatus.BAD_REQUEST);
//        } else {
//            return new ResponseEntity<>(userService.save(
//                    new User(10L,
//                            request.getEmailDto(),
//                            request.getPasswordDto(),
//                            request.getFirstNameDto(),
//                            request.getLastNameDto(),
//                            request.getPhoneDto(),
//                            roleUser)
//            ), HttpStatus.OK);
//        }
//    }
}
