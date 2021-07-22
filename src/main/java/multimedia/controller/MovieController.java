package multimedia.controller;

import lombok.AllArgsConstructor;
import multimedia.command.CreateMovieCommand;
import multimedia.command.UpdateMovieCommand;
import multimedia.dto.MovieDto;
import multimedia.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("movie/")
public class MovieController {

    private final MovieService service;

    @GetMapping("all")
    public List<MovieDto> getMovies() {
        return service.listAllMovie();
    }

    @GetMapping("{id}")
    public MovieDto findMovieById(@PathVariable("id") int id) {
        return service.findMovieById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDto createMovie(@RequestBody CreateMovieCommand command) {
        return service.saveMovie(command);
    }

    @PutMapping("{id}")
    public MovieDto updateBook(@PathVariable("id") int id, @RequestBody UpdateMovieCommand command) {
        return service.updateMovieById(id, command);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable("id") int id) {
        service.deleteMovieById(id);
    }

    @DeleteMapping("deleteall")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllMovie() {
        service.deleteAllMovie();
    }
}
