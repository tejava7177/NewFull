package org.example.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "text")
public class TextEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name = "text")
    private String text;
}
