package models;

import java.util.Comparator;
import java.util.LinkedList;

public class Movie {
    private int id;
    private String name;
    private int year;
    private String genre;
    private Producer producer;
    private LinkedList<Actor> actors;

    public Movie(int id, String name, int year, String genre, Producer producer, LinkedList<Actor> actors) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.producer = producer;
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public LinkedList<Actor> getActors() {
        return actors;
    }

    public void setActors(LinkedList<Actor> actors) {
        this.actors = actors;
    }

    public static Comparator<Movie> sortByYear = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getYear() - o2.getYear();
        }
    };

    public static Comparator<Movie> sorByMovieNameAtoZ = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

    public static Comparator<Movie> sorByMovieNameZtoA = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };

    public static Comparator<Movie> sorByProducer = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getProducer().getFullName().compareTo(o2.getProducer().getFullName());
        }
    };


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", producer=" + producer +
                ", actors=" + actors +
                '}'+ "\n" + "\n";
    }
}
