package com.example.pstlabstest.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.example.pstlabstest.dto.ValidationConstant.*;
import static com.example.pstlabstest.dto.ValidationConstant.PASSWORD_MSG;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDto {

    @Pattern(regexp = EMAIL_REGEXP)
    @NotNull
    @NotBlank
    private String email;

    @NotNull @NotBlank @Length(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH, message = PASSWORD_MSG)
    private String password;
}
