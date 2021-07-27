package multimedia.service;

import lombok.AllArgsConstructor;
import multimedia.MovieNotFoundException;
import multimedia.command.CreateMovieCommand;
import multimedia.command.UpdateMovieCommand;
import multimedia.dto.MovieDto;
import multimedia.entity.Movie;
import multimedia.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final ModelMapper modelMapper;

    private final MovieRepository repository;

    public MovieDto saveMovie(CreateMovieCommand command) {
        Movie movie = new Movie(command.getTitle(), command.getDirector(), command.getFilmStudio());
        repository.save(movie);
        return modelMapper.map(movie, MovieDto.class);
    }

    public List<MovieDto> listAllMovie() {
        return repository.findAll().stream().map(m -> modelMapper.map(m, MovieDto.class))
                .collect(Collectors.toList());
    }

    public MovieDto findMovieById(int id) {
        return modelMapper.map(repository.findById(id)
                        .orElseThrow(() -> new MovieNotFoundException(id)),
                MovieDto.class);
    }

    @Transactional
    public MovieDto updateMovieById(int id, UpdateMovieCommand command) {
        Movie movie = repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
        movie.setTitle(command.getTitle());
        movie.setDirector(command.getDirector());
        movie.setFilmStudio(command.getFilmStudio());
        return modelMapper.map(movie, MovieDto.class);
    }

    public void deleteMovieById(int id) {
        repository.deleteById(id);
    }

    public void deleteAllMovie() {
        repository.deleteAll();
    }
}
