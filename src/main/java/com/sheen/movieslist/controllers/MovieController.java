package com.sheen.movieslist.controllers;

import com.sheen.movieslist.models.Movie;
import com.sheen.movieslist.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // tells spring this class handles HTTP requests
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // GET all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // GET one movie
    @GetMapping("/{id}")
    // pathVarible extract the id from the url
    public Movie getMovieById(@PathVariable Integer id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    // POST new movie
    @PostMapping
    public  Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // Put
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        movie.setTitle(updatedMovie.getTitle());
        movie.setYear(updatedMovie.getYear());
        movie.setRating(updatedMovie.getRating());

        return movieRepository.save(movie);
    }

    // Patch
    @PatchMapping("/{id}")
    public Movie partialUpdateMovie(@PathVariable Integer id, @RequestBody Movie updatedMovie) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        if (updatedMovie.getTitle() != null) {
            movie.setTitle(updatedMovie.getTitle());
        }
        if (updatedMovie.getRating() != null) {
            movie.setRating(updatedMovie.getRating());
        }
        if (updatedMovie.getYear() != null) {
            movie.setYear(updatedMovie.getYear());
        }

        return movieRepository.save(movie);
    }

    // Delete movie
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable Integer id) {
        movieRepository.deleteById(id);
        return "Movie deleted successfully";
    }
}
