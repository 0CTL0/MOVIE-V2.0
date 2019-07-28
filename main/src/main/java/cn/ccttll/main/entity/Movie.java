package cn.ccttll.main.entity;

public class Movie {
    private Integer movieId;
    private  String movieName;
    private String movieImgUrl;
    private String movieScore;
    private String movieDirector;
    private  String movieStar;
    private  String movieType;
    private  String movieArea;
    private  String movieYear;
    private  String movieSummary;
    private  String moviePlayUrl;

    public Movie(Integer movieId, String movieName, String movieImgUrl) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieImgUrl = movieImgUrl;
    }

    public Movie(Integer movieId, String movieName, String movieImgUrl, String movieScore, String movieDirector, String movieStar, String movieType, String movieArea, String movieYear, String movieSummary, String moviePlayUrl) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieImgUrl = movieImgUrl;
        this.movieScore = movieScore;
        this.movieDirector = movieDirector;
        this.movieStar = movieStar;
        this.movieType = movieType;
        this.movieArea = movieArea;
        this.movieYear = movieYear;
        this.movieSummary = movieSummary;
        this.moviePlayUrl = moviePlayUrl;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieImgUrl() {
        return movieImgUrl;
    }

    public void setMovieImgUrl(String movieImgUrl) {
        this.movieImgUrl = movieImgUrl;
    }

    public String getMovieScore() {
        return movieScore;
    }

    public void setMovieScore(String movieScore) {
        this.movieScore = movieScore;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieStar() {
        return movieStar;
    }

    public void setMovieStar(String movieStar) {
        this.movieStar = movieStar;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getMovieArea() {
        return movieArea;
    }

    public void setMovieArea(String movieArea) {
        this.movieArea = movieArea;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getMovieSummary() {
        return movieSummary;
    }

    public void setMovieSummary(String movieSummary) {
        this.movieSummary = movieSummary;
    }

    public String getMoviePlayUrl() {
        return moviePlayUrl;
    }

    public void setMoviePlayUrl(String moviePlayUrl) {
        this.moviePlayUrl = moviePlayUrl;
    }
}
