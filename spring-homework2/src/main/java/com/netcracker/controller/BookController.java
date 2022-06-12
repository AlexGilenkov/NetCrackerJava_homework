package com.netcracker.controller;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Book;
import com.netcracker.repository.BookRepository;
import com.netcracker.response.DeleteResponse;
import com.netcracker.service.PatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    PatchService patchService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Book book = searchBook(id);

        return  ResponseEntity.ok().body(book);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<DeleteResponse> deleteBook(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Book book = searchBook(id);

        bookRepository.delete(book);

        return  ResponseEntity.ok().body(
                new DeleteResponse("Book with number: " + id + " deleted"));
    }

    @PutMapping("/books")
    public Book putBookById(@RequestBody Book b) throws ResourceNotFoundException {
        Book book = searchBook(b.getId());

        bookRepository.delete(book);

        return bookRepository.save(b);
    }

    @PatchMapping("/books")
    public Book patchBookById(@RequestBody Book b) throws ResourceNotFoundException {
        Book book = searchBook(b.getId());

        return bookRepository.save(patchService.patchBook(book, b));
    }


    private Book searchBook(Integer id) throws ResourceNotFoundException {
        return bookRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found for id = " + id));
    }

}
