package io.github.lnschroeder.hexagonal.domain.ports;

import io.github.lnschroeder.hexagonal.domain.entity.Book;
import java.util.List;

public interface BookService {
  // inbound port: exposes functions to outside
  void addBook(Book book);

  Book getBookByIsbn(Long id);

  List<Book> getBooks();
}
