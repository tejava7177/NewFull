package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
    @GetMapping("/login")
    String login(){
        return "login";  // login.html 템플릿을 명시적으로 반환
    }
}
