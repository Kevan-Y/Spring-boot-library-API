package com.kyang47.as2.book;

import com.kyang47.as2.library.Library;
import com.kyang47.as2.library.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, LibraryRepository libraryRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book, Long library_ref) {
        Library library = libraryRepository.findById(library_ref).orElseThrow(() ->
                new IllegalStateException("Library with id " + library_ref + " does not exists"));
        book.setLibrary(library);
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        boolean exists = bookRepository.existsById(id);

        if (!exists)
            throw new IllegalStateException("Book with id " + id + " does not exists");

        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(Long id, String title, String summary) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Book with id " + id + " does not exists"));

        if (title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title))
            book.setTitle(title);

        if (summary != null && summary.length() > 0 && !Objects.equals(book.getSummary(), summary))
            book.setSummary(summary);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Book with id " + id + " does not exists"));
    }

    public List<Book> getBookByName(String name) {
        return bookRepository.findBookByName(name).orElseThrow(() ->
                new IllegalStateException("Book with name " + name + " does not exists"));
    }
}
