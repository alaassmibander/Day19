package com.example.day19.Controller;

import com.example.day19.Moudle.Director;
import com.example.day19.Moudle.Movie;
import com.example.day19.Service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {


    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllMovies() {
        return ResponseEntity.status(200).body(movieService.getAllMovies());
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@RequestBody @Valid Movie movie, @PathVariable Integer id, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body("Movie update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        return ResponseEntity.status(200).body("Movie with id: " + id + " was delete.");
    }

    @GetMapping("/title")
    public ResponseEntity getMovieByTitle(@RequestBody Movie movie) {
        return ResponseEntity.status(200).body(movieService.getMovieByTitle(movie));
    }


    @GetMapping("/duration")
    public ResponseEntity getDurationByTitle(@RequestBody Movie movie) {
        return ResponseEntity.status(200).body(movieService.getMovieDurationByName(movie));
    }

    @GetMapping("/directorName")
    public ResponseEntity getDirectorName(@RequestBody Movie movie) {
        return ResponseEntity.status(200).body(movieService.getDirectorNameByMovieName(movie));
    }

    @GetMapping("/fromDirector")
    public ResponseEntity getMoviesByDirectorId(@RequestBody Movie movie) {
        return ResponseEntity.status(200).body(movieService.getDirectorNameByMovieName(movie));
    }

    @GetMapping("/all/byDirectorId")
    public ResponseEntity getMoviesByDirectorId(@RequestBody Director director) {
        return ResponseEntity.status(200).body(movieService.getMoviesByDirectorId(director));
    }


    @GetMapping("/rating")
    public ResponseEntity getRatingByName(@RequestBody Movie movie) {
        return ResponseEntity.status(200).body(movieService.getMovieRatingByName(movie));
    }


    @GetMapping("/all/rating")
    public ResponseEntity getMoviesByRating(@RequestBody Integer rating) {
        return ResponseEntity.status(200).body(movieService.findMoviesByRating(rating));
    }

    @GetMapping("/all/genre")
    public ResponseEntity getMoviesByGenre(@RequestBody Movie movie) {
        return ResponseEntity.status(200).body(movieService.getMoviesByGenre(movie));
    }

}