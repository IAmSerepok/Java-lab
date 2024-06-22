package org.example.lab3.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorDto {
    private String message;
}
