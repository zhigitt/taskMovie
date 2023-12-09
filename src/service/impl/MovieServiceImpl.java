package service.impl;

import db.DataBase;
import models.Actor;
import models.Movie;
import service.MovieService;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    DataBase dataBase;

    public MovieServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Movie> getAllMovies() {
        return dataBase.movies;
    }

    @Override
    public void findMovieByNameOrPartName(String name) {
        for (Movie movie : dataBase.movies) {
            if (movie.getName().equalsIgnoreCase(name)) {
                System.out.println(movie);
                return;
            } else System.out.println("Myndai kino jok");
        }
    }

    @Override
    public void findMovieByActorName(String actorName) {
        for (Movie movie : dataBase.movies) {
            for (Actor actor : movie.getActors()) {
                if (actor.getName().equalsIgnoreCase(actorName)) {
                    System.out.println(movie.getActors());
                    System.out.println(movie);
                    return;
                }
            }
        }
        System.out.println("Myndai actor jok");
    }

    @Override
    public void findMovieByYear(int year) {
        for (Movie movie : dataBase.movies) {
            for (int i = 0; i < movie.getYear(); i++) {
                if (movie.getYear() == year) {
                    System.out.println(movie);
                    return;
                }
            }
        }
        System.out.println("Bul jyl mn kino jok");
    }

    @Override
    public void findMovieByProducer(String producerName) {
        for (Movie movie : dataBase.movies) {
            if (movie.getProducer().getFullName().equals(producerName)){
                System.out.println(movie);
                return;
            }
        }
        System.out.println("Myndai producerde kion jok");
    }

    @Override
    public void findMovieByGenre(String genre) {
        for (Movie movie : dataBase.movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)){
                System.out.println(movie);
                return;
            }
        }
        System.out.println("Myndai janr mn kino jok");
    }

    @Override
    public void findMovieByRole(String role) {
        for (Movie movie : dataBase.movies) {
            for (Actor actor : movie.getActors()) {
                if(actor.getRole().equalsIgnoreCase(role)){
                    System.out.println(movie);
                    return;
                }
            }
        }
        System.out.println("Myndai role mn kino jok");
    }
}
