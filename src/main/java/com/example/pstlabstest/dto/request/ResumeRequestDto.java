package com.example.pstlabstest.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeRequestDto {

    @NotNull @NotBlank
    private String name;

    @NotNull @NotBlank
    private String description;
}
