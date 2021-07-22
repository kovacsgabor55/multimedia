package multimedia.controller;

import lombok.AllArgsConstructor;
import multimedia.command.CreateBookCommand;
import multimedia.command.UpdateBookCommand;
import multimedia.dto.BookDto;
import multimedia.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("book/")
public class BooksController {

    private final BookService service;

    @GetMapping("all")
    public List<BookDto> getBooks() {
        return service.listAllBook();
    }

    @GetMapping("{id}")
    public BookDto findBookById(@PathVariable("id") int id) {
        return service.findBookById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody CreateBookCommand command) {
        return service.saveBook(command);
    }

    @PutMapping("{id}")
    public BookDto updateBook(@PathVariable("id") int id, @RequestBody UpdateBookCommand command) {
        return service.updateBookById(id, command);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id") int id) {
        service.deleteBookById(id);
    }

    @DeleteMapping("deleteall")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllBook() {
        service.deleteAllBook();
    }
}
