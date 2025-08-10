package com.example.hackathon.user.interfaces;

import com.example.hackathon.user.application.AuthService;
import com.example.hackathon.user.interfaces.dto.LoginRequest;
import com.example.hackathon.user.interfaces.dto.SignupRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // 회원가입 API
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest request){

        authService.signup(request);
        return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");

    }

    // 로그인 API
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginRequest request){
        authService.login(request);

        return ResponseEntity.ok("로그인 성공!");
    }
}
