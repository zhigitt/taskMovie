package service;

import models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();
    void findMovieByNameOrPartName(String name);
    void findMovieByActorName(String actorName);
    void findMovieByYear(int year);
    void findMovieByProducer(String producerName);
    void findMovieByGenre(String genre);
    void findMovieByRole(String role);
}
