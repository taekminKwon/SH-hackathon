package com.example.hackathon.user.interfaces;

import com.example.hackathon.common.APIResponse;
import com.example.hackathon.common.SuccessCode;
import com.example.hackathon.common.jwt.JwtTokenProvider;
import com.example.hackathon.user.application.AuthService;
import com.example.hackathon.user.domain.User;
import com.example.hackathon.user.interfaces.dto.LoginRequest;
import com.example.hackathon.user.interfaces.dto.SignupRequest;
import com.example.hackathon.user.interfaces.dto.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입 API
    @PostMapping("/signUp")
    public APIResponse<Void> signup(@Valid @RequestBody SignupRequest request){
        authService.signup(request);
        return APIResponse.success(SuccessCode.OK);

    }

    // 로그인 API
    @PostMapping("/login")
    public APIResponse<TokenResponse> login(@Valid @RequestBody LoginRequest request){
        // 유저 정보 받아
        User user = authService.login(request);
        // 토큰 생성
        String token = jwtTokenProvider.generateToken(user.getUsername());
        TokenResponse tokenResponse = new TokenResponse(token);

        return APIResponse.success(SuccessCode.OK, tokenResponse);
    }

    // 로그아웃 API
    @PostMapping("/logout")
    public APIResponse<String> logout(@AuthenticationPrincipal UserDetails userDetails){
        // @AuthenticationPrincipal 어노테이션 --> 유효한 토큰을 가진(로그인 된) 사용자만 호출 가능
        // 클라이언트 측에서 토큰을 삭제하는 방식으로 로그아웃 처리할 것이므로, 성공 응답만 보내면 된다.
        return APIResponse.success(SuccessCode.OK, "성공적으로 로그아웃 되었습니다.");
    }
}
