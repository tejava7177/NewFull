package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";  // login.html 템플릿을 명시적으로 반환
    }

    @GetMapping("/loginSuccess")
    public String loginSuccess() {
        return "loginSuccess";  // loginSuccess.html 템플릿을 반환
    }

    @GetMapping("/loginFail")
    public String loginFail() {
        return "loginFail";  // loginSuccess.html 템플릿을 반환
    }
}
