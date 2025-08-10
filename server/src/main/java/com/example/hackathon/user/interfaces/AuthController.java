package com.example.hackathon.user.interfaces;

import com.example.hackathon.common.jwt.JwtTokenProvider;
import com.example.hackathon.user.application.AuthService;
import com.example.hackathon.user.domain.User;
import com.example.hackathon.user.interfaces.dto.LoginRequest;
import com.example.hackathon.user.interfaces.dto.SignupRequest;
import com.example.hackathon.user.interfaces.dto.TokenResponse;
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
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입 API
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequest request){

        authService.signup(request);
        return ResponseEntity.ok("회원가입이 성공적으로 완료되었습니다.");

    }

    // 로그인 API
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest request){
        // 유저 정보 받아
        User user = authService.login(request);
        // 토큰 생성
        String token = jwtTokenProvider.generateToken(user.getUsername());

        return ResponseEntity.ok(new TokenResponse(token));
    }
}
