package com.hai.setup.Service;

import com.hai.setup.Dto.BookRequest;
import com.hai.setup.Dto.BookResponse;
import com.hai.setup.Entity.Book;

import java.util.List;

public interface BookService {

    List<BookResponse> findAll();

    BookResponse findById(long id);

    BookResponse addBook(BookRequest bookRequest);

    BookResponse updateBook(BookRequest bookRequest,long id);

    void deleteBookById(long id);
}
