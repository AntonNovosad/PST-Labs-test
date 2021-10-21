package com.example.pstlabstest.service;

import com.example.pstlabstest.entity.User;
import com.example.pstlabstest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final UserRepository userRepository;


    public User save(User user) {
        String newPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(newPassword);
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(long id) {
        return userRepository.getById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void update(long id, String firstName, String lastName) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            user.setFirst_name(firstName);
            user.setLast_name(lastName);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, userRepository.getById(id).getEmail()));
        }
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
