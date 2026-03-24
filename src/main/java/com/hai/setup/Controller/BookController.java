package com.hai.setup.Controller;

import com.hai.setup.Dto.BookRequest;
import com.hai.setup.Dto.BookResponse;
import com.hai.setup.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookResponse> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public BookResponse findByID(@PathVariable long id){
        return bookService.findById(id);
    }

    @PostMapping
    public BookResponse save(@Valid @RequestBody BookRequest bookRequest){
        return bookService.addBook(bookRequest);
    }

    @PutMapping("/{id}")
    public BookResponse update( @RequestBody BookRequest bookRequest, @PathVariable long id){
        return bookService.updateBook(bookRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        bookService.deleteBookById(id);
    }

}
