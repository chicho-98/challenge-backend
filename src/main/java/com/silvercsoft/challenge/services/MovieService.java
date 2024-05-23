package com.silvercsoft.challenge.services;

import com.silvercsoft.challenge.model.Actor;
import com.silvercsoft.challenge.model.EditMovieDTO;
import com.silvercsoft.challenge.model.Movie;
import com.silvercsoft.challenge.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ActorService actorService;

    public MovieService(MovieRepository movieRepository, ActorService actorService) {
        this.movieRepository = movieRepository;
        this.actorService = actorService;
    }

    public Movie createMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    public Movie getMovie(Long id) {
        return this.movieRepository.findById(id).orElseThrow();
    }

    public Movie editMovie(Long id, EditMovieDTO editMovieDTO) {
        Movie movie = this.getMovie(id);
        movie.setTitle(editMovieDTO.title());
        movie.setRuntimeMinutes(editMovieDTO.runtimeMinutes());
        movie.setGenre(editMovieDTO.genre());
        return this.movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        this.movieRepository.deleteById(id);
    }

    public Movie addActor(Long movieId, Long actorId) {
        Movie movie = this.getMovie(movieId);
        Actor actor = this.actorService.getActor(actorId);
        movie.addActor(actor);
        return this.movieRepository.save(movie);
    }

    public Movie removeActor(Long movieId, Long actorId) {
        Movie movie = this.getMovie(movieId);
        Actor actor = this.actorService.getActor(actorId);
        movie.removeActor(actor);
        return this.movieRepository.save(movie);
    }

    public List<Movie> getMovies() {
        return this.movieRepository.findAll();
    }
}
