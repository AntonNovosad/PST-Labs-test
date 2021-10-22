package com.example.pstlabstest.mapper;

import com.example.pstlabstest.dto.request.RegistrationRequestDto;
import com.example.pstlabstest.dto.request.ResumeRequestDto;
import com.example.pstlabstest.dto.response.RegistrationResponseDto;
import com.example.pstlabstest.entity.Resume;
import com.example.pstlabstest.entity.User;

public interface ObjectMapper {
    RegistrationResponseDto toUserResponse(User user);
    User toUser(RegistrationRequestDto request);
    Resume toResume(ResumeRequestDto resumeRequestDto);
}
