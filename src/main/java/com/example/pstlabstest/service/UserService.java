package com.example.pstlabstest.service;

import com.example.pstlabstest.dto.request.RegistrationRequestDto;
import com.example.pstlabstest.dto.response.RegistrationResponseDto;
import com.example.pstlabstest.entity.Role;
import com.example.pstlabstest.entity.User;
import com.example.pstlabstest.exception.UserDataException;
import com.example.pstlabstest.mapper.ObjectMapper;
import com.example.pstlabstest.repository.RoleRepository;
import com.example.pstlabstest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AuthenticationManager authenticationManager;
    private final ObjectMapper objectMapper;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Value("${role.admin}")
    private String roleAdmin;
    @Value("${role.user}")
    private String roleUser;


    @Transactional
    public RegistrationResponseDto saveUser(RegistrationRequestDto request) {
        log.info("Saving new user first name:{}; email:{}", request.getFirstNameDto(), request.getEmailDto());
        User user = save(request, roleUser);
        return objectMapper.toUserResponse(user);
    }

    public User save(RegistrationRequestDto request, String roleName) {
        log.info("Save user in database");
        if (userRepository.existsByEmail(request.getEmailDto())){
            log.error("User with this email:{} already exist", request.getEmailDto());
            throw new UserDataException("User with this email already exist");
        }
        if (userRepository.existsByPhone(request.getPhoneDto())){
            log.error("User with this phoneNumber:{} already exist", request.getPhoneDto());
            throw new UserDataException("User with this phone number already exist");
        }

        Role role = getRoleOrThrowException(roleName);
        User user = objectMapper.toUser(request);
        user.setUserRoles(Set.of(role));
        user.setPassword(passwordEncoder().encode(user.getPassword()));

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
            user.setFirstName(firstName);
            user.setLastName(lastName);
            userRepository.save(user);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, userRepository.getById(id).getEmail()));
        }
    }

    private Role getRoleOrThrowException(String roleName){
        log.info("Get role by role name {}", roleName);
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role doesn't exist"));
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
