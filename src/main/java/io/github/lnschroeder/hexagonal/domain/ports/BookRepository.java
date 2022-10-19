package io.github.lnschroeder.hexagonal.domain.ports;

import io.github.lnschroeder.hexagonal.domain.entity.Book;
import java.util.List;

public interface BookRepository {
  // outbound port: for connecting external repos e.g. databases
  void addBook(Book book);

  Book getBookByIsbn(Long id);

  List<Book> getBooks();
}
