package com.example.hackathon.common.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = jwtTokenProvider.resolveToken(request);

        // 토큰 유효성 확인
        if (token != null && jwtTokenProvider.validateToken(token)){

            Authentication authentication = jwtTokenProvider.getAuthentication(token);

            // SecurityContext에 Authentication 객체를 저장 --> "인증된 상태"를 만듦
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 다음 필터로 체인 넘김
        filterChain.doFilter(request, response);

    }
}
