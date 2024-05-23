package com.silvercsoft.challenge.controllers;

import com.silvercsoft.challenge.model.EditMovieDTO;
import com.silvercsoft.challenge.model.Movie;
import com.silvercsoft.challenge.model.MovieDTO;
import com.silvercsoft.challenge.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/movies")
public class MovieControllers {

    private final MovieService movieService;

    public MovieControllers(MovieService movieService) {
        this.movieService = movieService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Movie createMovie(@RequestBody Movie movie) {
        return this.movieService.createMovie(movie);
    }

    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable Long id) {
        Movie movie = this.movieService.getMovie(id);
        return new MovieDTO(movie.getTitle(), movie.getRuntimeMinutes(), movie.getGenre(), movie.getActors());
    }

    @GetMapping
    public List<Movie> getMovies() {
        return this.movieService.getMovies();
    }

    @PutMapping("/{id}")
    public Movie editMovie(@PathVariable Long id, @RequestBody EditMovieDTO editMovieDTO) {
        return this.movieService.editMovie(id, editMovieDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        this.movieService.deleteMovie(id);
    }

    @PostMapping("/{movieId}/actors/{actorId}")
    public Movie addActor(@PathVariable Long movieId, @PathVariable Long actorId) {
        return this.movieService.addActor(movieId, actorId);
    }

    @DeleteMapping("/{movieId}/actors/{actorId}")
    public Movie removeActor(@PathVariable Long movieId, @PathVariable Long actorId) {
        return this.movieService.removeActor(movieId, actorId);
    }
}
