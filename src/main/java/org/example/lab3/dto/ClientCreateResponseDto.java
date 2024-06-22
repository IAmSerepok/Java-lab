package org.example.lab3.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClientCreateResponseDto {
    private Long id;
}
