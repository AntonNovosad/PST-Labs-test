package com.example.pstlabstest.controller;

import com.example.pstlabstest.dto.request.RegistrationRequestDto;
import com.example.pstlabstest.dto.response.RegistrationResponseDto;
import com.example.pstlabstest.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/home")
@AllArgsConstructor
public class RegistrationController {

    private final static String USER_EXIST_MSG = "user with email %s exist";
    private final UserService userService;

    @PostMapping("/reg")
    public ResponseEntity<?> userRegistration(@Valid @RequestBody RegistrationRequestDto request){
        RegistrationResponseDto response = userService.saveUser(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
