package com.hai.setup.Entity;

import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String author;

    private double price;

    private String isbn;
}
