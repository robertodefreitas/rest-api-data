package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse {

    private Long id;
    private Long idExtern;
    private String name;
    private String email;
    private String message;
    private LocalDateTime createdAt;
}