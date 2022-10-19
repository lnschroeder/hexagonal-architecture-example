package io.github.lnschroeder.hexagonal.adapters.secondary;

import io.github.lnschroeder.hexagonal.domain.entity.Book;
import io.github.lnschroeder.hexagonal.domain.ports.BookRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BookDatabase1 implements BookRepository {

  private static final List<Book> bookShelf = new ArrayList<>();

  @Override
  public void addBook(Book book) {
    bookShelf.add(book);
  }

  @Override
  public Book getBookByIsbn(Long isbn) {
    for (Book book : bookShelf) {
      if (isbn.equals(book.isbn())) {
        return book;
      }
    }
    return null;
  }

  @Override
  public List<Book> getBooks() {
    return new ArrayList<>(bookShelf);
  }
}
