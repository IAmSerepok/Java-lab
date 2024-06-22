package org.example.lab3.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.lab3.model.Client;

@Data
@Accessors(chain = true)
public class NoteCreateResponseDto {
    private Long id;
    private String title;
    private Client client;
}
