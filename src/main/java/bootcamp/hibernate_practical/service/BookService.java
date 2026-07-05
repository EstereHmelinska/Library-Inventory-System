package bootcamp.hibernate_practical.service;

import bootcamp.hibernate_practical.dto.BookResponse;
import bootcamp.hibernate_practical.dto.CreateBookRequest;
import bootcamp.hibernate_practical.dto.UpdateBookRequest;
import bootcamp.hibernate_practical.entity.Book;
import bootcamp.hibernate_practical.exception.BookNotFoundException;
import bootcamp.hibernate_practical.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse createBook(CreateBookRequest request) {
        Book book = new Book(
                request.getTitle(),
                request.getAuthor(),
                request.getGenre(),
                request.getPublicationYear(),
                true
        );
        Book savedBook = bookRepository.save(book);
        return mapToResponse(savedBook);
    }

    public List<BookResponse> getAllBooks() {
        // Fetch all books from the repository
        List<Book> books = bookRepository.findAll();
        // Convert each Book entity into BookResponse DTO
        List<BookResponse> responses = books.stream()
                .map(book -> mapToResponse(book))
                .collect(Collectors.toList());
        // Return the list
        return responses;
    }

    public BookResponse getBookById(Long id) {
        // Find the book by its ID
        Book book = bookRepository.findById(id)
                // Throw RuntimeException if not found
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        // Convert the entity to BookResponse
        return mapToResponse(book);
    }

    public BookResponse updateBook(Long id, UpdateBookRequest request) {
        // Find existing book
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        // Update its fields
        book.setTitle(request.getTitle());
        // Save the updated entity
        Book updatedBook = bookRepository.save(book);
        // Convert to BookResponse
        return mapToResponse(updatedBook);
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        bookRepository.delete(book);

    }

    public List<BookResponse> findByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        List<BookResponse> responses = books.stream()
                .map(book -> mapToResponse(book))
                .collect(Collectors.toList());
        return responses;
    }

    public List<BookResponse> findAvailableBooks() {
        List<Book> books = bookRepository.findByAvailableTrue();
        List<BookResponse> responses = books.stream()
                .map(book -> mapToResponse(book))
                .collect(Collectors.toList());
        return responses;
    }

    private BookResponse mapToResponse(Book book) {
        //map Book to BookResponse
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getPublicationYear(),
                book.isAvailable()
        );
    }

    public List<BookResponse> findBooksPublishedAfter(int publicationYear) {
        List<Book> books = bookRepository.findByPublicationYearGreaterThan(publicationYear);
        List<BookResponse> responses = books.stream()
                .map(book -> mapToResponse(book))
                .collect(Collectors.toList());
        return responses;

    }

    public long countBooks() {
        return bookRepository.count();
    }

    public List<BookResponse> findBooksByPartialTitle(String title) {
        List<Book> books = bookRepository.findByTitleContaining(title);
        List<BookResponse> responses = books.stream()
                .map(book -> mapToResponse(book))
                .collect(Collectors.toList());
        return responses;

    }
}
