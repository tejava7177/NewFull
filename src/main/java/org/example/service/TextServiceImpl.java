package org.example.service;


import org.example.model.TextEntry;
import org.example.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TextServiceImpl implements TextService{
    @Autowired
    private TextRepository textRepository;

    @Override
    public TextEntry createText(TextEntry textEntry){
        return textRepository.save(textEntry);
    }

    @Override
    public Optional<TextEntry> getTextById(long textId) {
        return textRepository.findById(textId);
    }

    @Override
    public Iterable<TextEntry> getText() {
        return textRepository.findAll();
    }


}
