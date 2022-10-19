package io.github.lnschroeder.hexagonal.domain;

import io.github.lnschroeder.hexagonal.domain.entity.Book;
import io.github.lnschroeder.hexagonal.domain.ports.BookRepository;
import io.github.lnschroeder.hexagonal.domain.ports.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private BookRepository bookRepository;

  @Autowired
  public void setBookRepo(@Qualifier("bookDatabase2") BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void addBook(Book book) {
    System.out.println("--- Add book ---");
    System.out.println(book);

    bookRepository.addBook(book);
  }

  @Override
  public Book getBookByIsbn(Long id) {
    Book book = bookRepository.getBookByIsbn(id);

    System.out.println("--- Get book " + id + " ---");
    System.out.println(book);

    return book;
  }

  @Override
  public List<Book> getBooks() {
    List<Book> books = bookRepository.getBooks();

    System.out.println("--- List all books ---");
    System.out.println(books);

    return books;
  }

}
