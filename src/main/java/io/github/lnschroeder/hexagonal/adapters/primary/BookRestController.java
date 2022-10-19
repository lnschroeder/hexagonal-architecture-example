package io.github.lnschroeder.hexagonal.adapters.primary;

import io.github.lnschroeder.hexagonal.domain.entity.Book;
import io.github.lnschroeder.hexagonal.domain.ports.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
public class BookRestController {

  private BookService bookService;

  @Autowired
  public void setBookService(BookService bookService) {
    this.bookService = bookService;
  }

  @PostMapping
  public ResponseEntity<HttpStatus> addBook(Book book) {
    bookService.addBook(book);

    return ResponseEntity.ok(HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBook(@PathVariable Long id) {
    Book book = bookService.getBookByIsbn(id);

    return new ResponseEntity<>(book, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Book>> listBooks() {
    List<Book> books = bookService.getBooks();

    return new ResponseEntity<>(books, HttpStatus.OK);
  }
}
