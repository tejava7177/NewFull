package org.example.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
    @PostMapping("/doLogout")
    public String logut(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            // 로그아웃 처리
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }


        return  "redirect:/login";
    }
}
