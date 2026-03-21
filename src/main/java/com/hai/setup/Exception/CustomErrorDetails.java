package com.hai.setup.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CustomErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;

}
