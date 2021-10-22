package com.example.pstlabstest.mapper;

import com.example.pstlabstest.dto.request.RegistrationRequestDto;
import com.example.pstlabstest.dto.request.ResumeRequestDto;
import com.example.pstlabstest.dto.response.RegistrationResponseDto;
import com.example.pstlabstest.entity.Resume;
import com.example.pstlabstest.entity.Role;
import com.example.pstlabstest.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObjectMapperImpl implements ObjectMapper {

    @Override
    public RegistrationResponseDto toUserResponse(User user) {
        Collection<Role> userRoles = user.getUserRoles();
        List<String> roles = userRoles.stream().map(Role::getName).collect(Collectors.toList());
        return RegistrationResponseDto
                .builder()
                .emailDto(user.getEmail())
                .firstNameDto(user.getFirstName())
                .lastNameDto(user.getLastName())
                .phoneDto(user.getPhone())
                .rolesDto(roles)
                .build();
    }

    @Override
    public User toUser(RegistrationRequestDto request) {
        return User
                .builder()
                .email(request.getEmailDto())
                .password(request.getPasswordDto())
                .firstName(request.getFirstNameDto())
                .lastName(request.getLastNameDto())
                .phone(request.getPhoneDto())
                .build();
    }

    @Override
    public Resume toResume(ResumeRequestDto resumeRequestDto) {
        return Resume
                .builder()
                .name(resumeRequestDto.getName())
                .description(resumeRequestDto.getDescription())
                .build();
    }
}
