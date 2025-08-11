package com.example.hackathon.user.application;

import com.example.hackathon.user.domain.User;
import com.example.hackathon.user.infrastructure.UserRepository;
import com.example.hackathon.user.interfaces.dto.LoginRequest;
import com.example.hackathon.user.interfaces.dto.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    @Transactional
    public User signup(SignupRequest request) {

        // 학번 중복 체크
        if (userRepository.findByStudentId(request.getStudentId()).isPresent()) {
            throw new IllegalArgumentException("이미 가입된 학번입니다.");
        }

        // 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                .name(request.getName())
                .studentId(request.getStudentId())
                .password(encodedPassword)
                .school(request.getSchool()).build();

        // 저장
        return userRepository.save(user);
    }

    // 로그인
    @Transactional(readOnly = true)
    public User login(LoginRequest request) {

        // 조회
        User user = userRepository.findByStudentId(request.getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 학번입니다."));

        // 검증
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 인증 성공, 리턴
        return user;
    }

}
