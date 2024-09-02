package org.example.controller;

import org.example.model.UserEntity;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")  // 프론트엔드가 실행되는 주소 (일반적으로 3000번 포트)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserEntity user) {
        userService.saveUser(user);
        return ResponseEntity.ok("회원가입 성공");
    }
}
