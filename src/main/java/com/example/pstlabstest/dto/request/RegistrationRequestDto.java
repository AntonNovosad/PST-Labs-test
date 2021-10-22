package com.example.pstlabstest.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.example.pstlabstest.dto.ValidationConstant.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDto {

    @Pattern(regexp = EMAIL_REGEXP)
    @NotNull @NotBlank
    private String emailDto;

    @NotNull @NotBlank @Length(min = MIN_PASSWORD_LENGTH, max = MAX_PASSWORD_LENGTH, message = PASSWORD_MSG)
    private String passwordDto;

    @NotNull @NotBlank
    private String firstNameDto;

    @NotNull @NotBlank
    private String lastNameDto;

    @NotNull @NotBlank @Length(min = MIN_PHONE_LENGTH, max = MAX_PHONE_LENGTH, message = PHONE_MSG)
    private String phoneDto;
}
