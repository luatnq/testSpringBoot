package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements BookServiceInter{
    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return (List<Book>) bookRepository.findAll();
    }

    @Override
    public List<Book> container(String bookName){
        return (List<Book>) bookRepository.findByBookNameContaining(bookName);
    }

    @Override
    public void deleteAllBook(){
        bookRepository.deleteAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        Book saved = bookRepository.save(book);
        return saved;
    }


    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
//    @Autowired
//    BookRepository bookRepository;
//
//    @GetMapping("/books")
//
//
//    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String bookName) {
//        try {
//            List<Book> books = new ArrayList<>();
//            if (bookName == null) {
//                bookRepository.findAll().forEach(books::add);
//            } else {
//                bookRepository.findByBookNameContaining(bookName).forEach(books::add);
//            }
//            if (books.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//            return new ResponseEntity<>(books, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/books/{id}")
//    public ResponseEntity<Book> getTutorialById(@PathVariable("id") long id) {
//        Optional<Book> bookData = bookRepository.findById(id);
//        if (bookData.isPresent()) {
//            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/books")
//    public ResponseEntity<Book> createBook(@RequestBody Book book) {
//        try {
//            Book book1 = bookRepository.save(new Book(book.getBookName(), book.getAuthor(), book.getPublishYear()));
//            return new ResponseEntity<>(book1, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PutMapping("/books/{id}")
//    public ResponseEntity<Book> updateBook(@PathVariable("id") long id,@RequestBody Book book){
//        Optional<Book> bookData = bookRepository.findById(id);
//        if(bookData.isPresent()){
//            Book book1=bookData.get();
//            book1.setBookName(book.getBookName());
//            book1.setAuthor(book.getAuthor());
//            book1.setPublishYear(book.getPublishYear());
//            return new ResponseEntity<>(bookRepository.save(book1),HttpStatus.OK);
//        } else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @DeleteMapping("/books")
//    public ResponseEntity<HttpStatus> deleteBook(){
//        try{
//            bookRepository.deleteAll();
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @DeleteMapping("/books/{id}")
//    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id){
//        try{
//            bookRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }