package org.example.lab3.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ClientUpdateResponseDto {
    private Long id;
    private String username;
}
