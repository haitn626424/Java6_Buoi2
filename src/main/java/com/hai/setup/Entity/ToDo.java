package com.hai.setup.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters")
    private String title;
    @Size(min = 3, message = "Description should have at least 3 characters")
    private String description;

    private boolean completed;

}
