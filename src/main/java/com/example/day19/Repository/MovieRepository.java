package com.example.day19.Repository;

import com.example.day19.Moudle.Movie;
import com.example.day19.Moudle.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
     List<Movie> findMoviesByIdDirector(Integer directorId);
     Movie findMovieById(Integer id);
     Movie findMovieByTitle(String title);
     List<Movie> findMoviesByRatingGreaterThan(int rate);

    List<Movie> findMoviesByGenre(String genre);

}
