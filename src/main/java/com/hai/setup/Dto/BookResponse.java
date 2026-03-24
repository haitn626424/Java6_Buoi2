package com.hai.setup.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponse {

    private String title;

    private String author;

    private double price;

    private String isbn;

}
