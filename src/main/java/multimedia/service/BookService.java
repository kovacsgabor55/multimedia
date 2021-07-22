package multimedia.service;

import lombok.AllArgsConstructor;
import multimedia.command.CreateBookCommand;
import multimedia.command.UpdateBookCommand;
import multimedia.dto.BookDto;
import multimedia.entity.Book;
import multimedia.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookService {

    private final ModelMapper modelMapper;

    private final BookRepository repository;

    public BookDto saveBook(CreateBookCommand command) {
        Book book = new Book(command.getAuthor(), command.getTitle(), command.getReleaseDate());
        repository.save(book);
        return modelMapper.map(book, BookDto.class);
    }

    public List<BookDto> listAllBook() {
        return repository.findAll().stream().map(b -> modelMapper.map(b, BookDto.class))
                .collect(Collectors.toList());
    }

    public BookDto findBookById(int id) {
        return modelMapper.map(repository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Book not fount: " + id)),
                BookDto.class);
    }

    //TODO
    public BookDto updateBookById(int id, UpdateBookCommand command) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found: " + id));
        book.setAuthor(command.getAuthor());
        book.setTitle(command.getTitle());
        book.setReleaseDate(command.getReleaseDate());
        return modelMapper.map(book, BookDto.class);
    }

    public void deleteBookById(int id) {
        repository.deleteById(id);
    }

    public void deleteAllBook() {
        repository.deleteAll();
    }
}
