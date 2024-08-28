package org.example.controller;


import org.example.model.TextEntry;
import org.example.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000")  // 프론트엔드가 실행되는 주소 (일반적으로 3000번 포트)
public class TextController {
    @Autowired
    private TextService textService;

    @GetMapping
    public Iterable<TextEntry> getAllTextEntry(){
        return textService.getText();
    }

    @PostMapping
    public TextEntry createText(@RequestBody TextEntry textEntry){
        return textService.createText(textEntry);
    }


}
