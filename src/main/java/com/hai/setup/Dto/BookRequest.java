package com.hai.setup.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {
    @NotBlank(message = "title must be not null")
    private String title;
    @NotBlank(message = "author must be not null")
    private String author;
    @PositiveOrZero(message = "price must be larger than or equal to Zero")
    private double price;


}
