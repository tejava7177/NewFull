package org.example.service;

import org.example.model.TextEntry;

import java.util.Optional;

public interface TextService {
    TextEntry createText(TextEntry textEntry);

    Optional<TextEntry> getTextById(long textId);
    Iterable<TextEntry> getText();


}
