package com.example.day19.Service;

import com.example.day19.ApiException.ApiException;
import com.example.day19.Moudle.Director;
import com.example.day19.Moudle.Movie;
import com.example.day19.Repository.DirectorRepository;
import com.example.day19.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository movieRepository;
    private DirectorRepository directorRepository;


    public MovieService(MovieRepository movieRepository, DirectorRepository directorRepository){
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie(Integer id, Movie movie){
        Movie oldMovie = movieRepository.findById(id).orElse(null);

        if (oldMovie == null)
            throw new ApiException("Movie with id: "+id+" was not found.");

        movie.setId(id);
        movieRepository.save(movie);
    }

    public void deleteMovie(Integer id){
        Movie oldMovie = movieRepository.findById(id).orElse(null);

        if (oldMovie == null)
            throw new ApiException("Movie with id: "+id+" was not found.");
        movieRepository.deleteById(id);
    }

    public Movie getMovieByTitle(Movie movie){
        if (movie.getTitle() == null || movie.getTitle().isEmpty())
            throw new ApiException("Movie title is required for the search.");

        Movie result = movieRepository.findMovieByTitle(movie.getTitle());
        if (result == null)
            throw new ApiException("Movie with title: "+movie.getTitle()+" was not found.");

        return result;
    }


    public Integer getMovieDurationByName(Movie movie){
        if (movie.getTitle() == null || movie.getTitle().isEmpty())
            throw new ApiException("Movie title is required.");

        Movie movieResult = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieResult == null)
            throw new ApiException("Movie with title: "+movie.getTitle()+" was not found.");

        return movieResult.getDuration();
    }

    public String getDirectorNameByMovieName(Movie movie){
        if (movie.getTitle() == null || movie.getTitle().isEmpty())
            throw new ApiException("Movie title is required.");

        Movie movieResult = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieResult == null)
            throw new ApiException("Movie with title: "+movie.getTitle()+" was not found.");

        Director director = directorRepository.findById(movieResult.getIdDirector()).orElse(null);
        if (director == null)
            throw new ApiException("Unexpected error happened this movie has no director.");

        return director.getName();
    }

    public List<Movie> getMoviesByDirectorId(Director director){
        if (director == null)
            throw new ApiException("directory is required.");

        List<Movie> movies = movieRepository.findMoviesByIdDirector(director.getId());
        return movies;
    }

    public Integer getMovieRatingByName(Movie movie){
        if (movie.getTitle() == null || movie.getTitle().isEmpty())
            throw new ApiException("Movie title is required.");

        Movie movieResult = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieResult == null)
            throw new ApiException("Movie with title: "+movie.getTitle()+" was not found.");

        return movie.getRating();
    }


    public List<Movie> findMoviesByRating(Integer rating){
        if (rating == null)
            throw new ApiException("Movie rating is required.");

        List<Movie> movies = movieRepository.findMoviesByRatingGreaterThan(rating);
        return movies;
    }

    public List<Movie> getMoviesByGenre(Movie movie){
        if (movie.getGenre() == null || movie.getGenre().isEmpty())
            throw new ApiException("Movie genre is required.");

        List<Movie> movies = movieRepository.findMoviesByGenre(movie.getGenre());

        return movies;
    }



}
