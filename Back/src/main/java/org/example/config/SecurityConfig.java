package org.example.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;


//시큐리티 설정 클래스
@Configuration
@EnableWebSecurity          //가장 중요함.
@EnableMethodSecurity
@RequiredArgsConstructor         
public class SecurityConfig  {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers( "/static/**", "/css/**", "/js/**", "/images/**");
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // CSRF 토큰 쿠키 설정
                )
                .cors(withDefaults()) // Spring Security에서 CORS 지원 사용
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/login", "/api/v1/**").permitAll()
                        .anyRequest().authenticated() // 나머지 요청은 인증 필요
                )
                .formLogin(form -> form.loginPage("/login").permitAll()
                )
                .logout(logout -> logout
                        .permitAll());

        return http.build();
    }

    // CORS 설정을 위한 필터를 명시적으로 추가
//    public static class SimpleCorsFilter extends OncePerRequestFilter {
//        @Override
//        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//                throws ServletException, IOException {
//            response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
//            response.setHeader("Access-Control-Allow-Credentials", "true");
//            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
//
//            filterChain.doFilter(request, response);
//        }
//    }

}
