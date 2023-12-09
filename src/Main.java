import db.DataBase;
import models.Actor;
import models.Movie;
import models.Producer;
import service.MovieService;
import service.impl.MovieServiceImpl;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        DataBase dataBase = new DataBase();

        MovieService movieService = new MovieServiceImpl(dataBase);


        Producer producerJerTogolok = new Producer(1, "Rustam", "Askenov");
        Producer producerVanchopa = new Producer(2, "Ashat", "Tabaldiev");
        Producer producerbajariki = new Producer(3, "Nurlan", "Janybekov");

        LinkedList<Actor> actorsJerTogolok = new LinkedList<>(List.of(
                new Actor(1, "Samat", "glavnyi"),
                new Actor(2, "Kubanych", "neglavnyi")
        ));

        LinkedList<Actor> actorsVanchopa = new LinkedList<>(List.of(
                new Actor(1, "Aktan", "glavnyi"),
                new Actor(2, "Janysh", "neglavnyi")
        ));

        LinkedList<Actor> actorsBajariki = new LinkedList<>(List.of(
                new Actor(1, "Ulan", "glavnyi"),
                new Actor(2, "Atai", "neglavnyi")
        ));

        LinkedList<Movie> movies = new LinkedList<>(List.of(
                new Movie(1, "Jer togolok", 2019, "Komedy", producerJerTogolok, actorsJerTogolok),
                new Movie(2, "Vanchopa", 2018, "Komedy", producerVanchopa, actorsVanchopa),
                new Movie(3, "Bajariki", 2017, "Komedy", producerbajariki, actorsBajariki))
        );

        dataBase.movies.addAll(movies);

        while (true) {
            System.out.println("""
                         FIND:                             SORTING:              
                    1. Get all movie                  8. Sort by movie name 
                    2. Find movie by name             9. Sort by year 
                    3. Find movie by name actor       10. Sort by producer
                    4. Find movie by year 
                    5. Find movie by peoducer 
                    6. Find movie by genre
                    7. Find movie by role
                    """);

            System.out.print("Select: ");
            switch (sc1.nextInt()) {
                case 1 -> {
                    System.out.println(movieService.getAllMovies());
                }
                case 2 -> {
                    System.out.print("Name movie: ");
                    String movieName = sc2.nextLine();

                    movieService.findMovieByNameOrPartName(movieName);
                }
                case 3 -> {
                    System.out.print("Name actor: ");
                    String actorName = sc2.nextLine();

                    movieService.findMovieByActorName(actorName);
                }
                case 4 -> {
                    System.out.print("Movie year: ");
                    int movieYear = sc1.nextInt();

                    movieService.findMovieByYear(movieYear);
                }
                case 5 -> {
                    System.out.print("Name producer: ");
                    String nameProducer = sc2.nextLine();

                    movieService.findMovieByProducer(nameProducer);
                }
                case 6 -> {
                    System.out.print("Movie genre: ");
                    String movieGenre = sc2.nextLine();

                    movieService.findMovieByGenre(movieGenre);
                }
                case 7 -> {
                    System.out.print("Movie role: ");
                    String movieRole = sc2.nextLine();

                    movieService.findMovieByRole(movieRole);
                }
                case 8 -> {
                    System.out.println("""
                            1. A to Z
                            2. Z to A
                            """);

                    System.out.print("Select: ");
                    switch (sc1.nextInt()){
                        case 1 -> {
                            movies.sort(Movie.sorByMovieNameAtoZ);
                            System.out.println(movies);
                        }
                        case 2 -> {
                            movies.sort(Movie.sorByMovieNameZtoA);
                            System.out.println(movies);
                        }
                    }
                }
                case 9 -> {
                    movies.sort(Movie.sortByYear);
                    System.out.println(movies);
                }
                case 10 -> {
                    movies.sort(Movie.sorByProducer);
                    System.out.println(movies);
                }

            }
        }
    }


}