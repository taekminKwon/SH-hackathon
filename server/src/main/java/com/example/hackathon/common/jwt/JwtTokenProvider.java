package com.example.hackathon.common.jwt;

import com.example.hackathon.user.infrastructure.UserRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final UserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String secretKey;

    private Key key;
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    private final long tokenValidityMilliseconds = 1000 * 60 * 60;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    // JWT 토큰 생성
    public String generateToken(String studentId) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + tokenValidityMilliseconds);

        return Jwts.builder()
                .setSubject(studentId)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(key, signatureAlgorithm)
                .compact();
    }

    // 사용자 학번 추출
    public String getStudentId(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }

    // 인증 정보 조회
    public Authentication getAuthentication(String token){
        UserDetails userDetails = userDetailsService.loadUserByUsername(getStudentId(token));

        // UserDetails 객체로 SpringSecurity의 Authentication 객체를 생성, 반환
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    // Http 요청 헤더에서 토큰 추출
    public String resolveToken(HttpServletRequest requetst) {
        String bearerToken = requetst.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // "Bearer " 이후 나열된 Token 가져오기
        }

        return null;
    }

    // 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
    } catch (io.jsonwebtoken.security.SignatureException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }

}
