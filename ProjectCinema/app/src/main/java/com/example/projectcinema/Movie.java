package com.example.projectcinema;

public class Movie
{
    private int Id;
    private String MovieName;
    private String MovieGenre;
    private int MoviePoint;
    private String MovieAge;
    private String Status;

    public Movie(int id, String movieName, String movieGenre, int moviePoint, String movieAge, String status)
    {
        Id = id;
        MovieName = movieName;
        MovieGenre = movieGenre;
        MoviePoint = moviePoint;
        MovieAge = movieAge;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public String getMovieGenre() {
        return MovieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        MovieGenre = movieGenre;
    }

    public int getMoviePoint() {
        return MoviePoint;
    }

    public void setMoviePoint(int moviePoint) {
        MoviePoint = moviePoint;
    }

    public String getMovieAge() {
        return MovieAge;
    }

    public void setMovieAge(String movieAge) {
        MovieAge = movieAge;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
