package io.github.lnschroeder.hexagonal.adapters.secondary;

import io.github.lnschroeder.hexagonal.domain.entity.Book;
import io.github.lnschroeder.hexagonal.domain.ports.BookRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class BookDatabase2 implements BookRepository {

  private static final Map<Long, Book> bookStore = new HashMap<>();

  @Override
  public void addBook(Book book) {
    bookStore.put(book.isbn(), book);
  }

  @Override
  public Book getBookByIsbn(Long isbn) {
    return bookStore.get(isbn);
  }

  @Override
  public List<Book> getBooks() {
    return new ArrayList<>(bookStore.values());
  }
}
