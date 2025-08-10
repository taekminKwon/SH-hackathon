package com.example.hackathon.user.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String studentId; // (학번 --> 로그인 Id로 사용)

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String school;

    private String role = "ROLE_USER";

    @Builder
    public User(String name, String studentId, String password, String school) {
        this.name = name;
        this.studentId = studentId;
        this.password = password;
        this.school = school;
    }

    // 권한 목록 체크
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public String getUsername() {
        // SpringSecurity의 username은 고유식별자를 의미 --> 학번 ID 사용할 것이므로, studentId를 반환
        return this.studentId;
    }

    // 계정 상태 확인, 4가지 다 우선은 true로 설정해서 관리
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
