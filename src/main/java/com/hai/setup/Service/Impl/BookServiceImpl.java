package com.hai.setup.Service.Impl;

import com.hai.setup.Dto.BookRequest;
import com.hai.setup.Dto.BookResponse;
import com.hai.setup.Entity.Book;
import com.hai.setup.Exception.CustomResourceNotFoundException;
import com.hai.setup.Repository.BookRepository;
import com.hai.setup.Service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<BookResponse> findAll() {
       return bookRepository.findAll()
               .stream()
               .map(book -> modelMapper.map(book, BookResponse.class))
               .collect(Collectors.toList());
    }

    @Override
    public BookResponse findById(long id) {
        return bookRepository.findById(id)
                .map((book) -> modelMapper.map(book, BookResponse.class))
                .orElseThrow(() -> new CustomResourceNotFoundException("Book not found for this id : " + id));
    }

    @Override
    public BookResponse addBook(BookRequest bookRequest) {
      Book book =   modelMapper.map(bookRequest, Book.class);
      book.setIsbn(generateIsbn());
      return modelMapper.map(bookRepository.save(book), BookResponse.class);
    }
    private String generateIsbn() {
        return "ISBN-" + UUID.randomUUID().toString().substring(0,13);
    }

    @Override
    public BookResponse updateBook(BookRequest bookRequest, long id) {
        return bookRepository.findById(id).map(b ->{
            if(bookRequest.getTitle() != null) b.setTitle(bookRequest.getTitle());
            if(bookRequest.getAuthor() != null) b.setAuthor(bookRequest.getAuthor());
            if(bookRequest.getPrice() >=0) b.setPrice(bookRequest.getPrice());
            bookRepository.save(b);
            return modelMapper.map(b, BookResponse.class);
        }).orElseThrow(() -> new CustomResourceNotFoundException("Book not found for this id : " + id));
    }

    @Override
    public void deleteBookById(long id) {
       bookRepository.deleteById(id);
    }
}
