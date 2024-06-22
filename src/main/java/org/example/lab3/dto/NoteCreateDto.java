package org.example.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.example.lab3.model.Client;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class NoteCreateDto {
    private String title;
    private String content;
    private Client client;
}
