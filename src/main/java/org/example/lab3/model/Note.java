package org.example.lab3.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
}

