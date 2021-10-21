package com.example.pstlabstest.service;

import com.example.pstlabstest.entity.User;
import com.example.pstlabstest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

    public boolean deleteUser(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            User user = userRepository.findByEmail(email).get();
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }
}
