package com.example.schedulesdevelopproject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequestDto {
    @NotBlank(message = "유저명 입력 필수")
    @Size(max = 4, message = "유저명은 4글자 이내")
    private final String username;

    @NotBlank(message = "이메일 입력 필수")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private final String email;

    @NotBlank(message = "비밀번호 입력 필수")
    @Pattern(
            regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",    // 최소 8자 이상, 영문자 포함, 숫자 포함
            message = "비밀번호는 최소 8자, 영문과 숫자를 포함해야 합니다."
    )
    private final String password;

    public CreateUserRequestDto(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
