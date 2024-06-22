package org.example.lab3.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class NoteUpdateTitleDto {
    private String title;
}
