package com.example.hackathon.user.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequest {
    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "학번은 필수입니다.")
    private String studentId;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "학교 이름은 필수입니다.")
    private String school;
}
