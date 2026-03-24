package com.hai.setup.Controller;

import com.hai.setup.Dto.BookRequest;
import com.hai.setup.Dto.BookResponse;
import com.hai.setup.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> findAll(){
        List<BookResponse> books = bookService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> findByID(@PathVariable long id){
        BookResponse books = bookService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(books);
    }

    @PostMapping
    public ResponseEntity<BookResponse> save(@Valid @RequestBody BookRequest bookRequest){
        BookResponse bookAdd = bookService.addBook(bookRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookAdd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@Valid @RequestBody BookRequest bookRequest, @PathVariable long id){
        BookResponse bookUpdate = bookService.updateBook(bookRequest, id);
        return ResponseEntity.status(HttpStatus.OK).body(bookUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id){
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();// 204
    }

}
