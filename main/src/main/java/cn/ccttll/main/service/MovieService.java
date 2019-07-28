package cn.ccttll.main.service;

import cn.ccttll.main.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
public interface MovieService {
//    Integer countMovie(String movieType);
    Movie getMovie(int movieId);
    List<Movie> getMovie(String movieName);
    List<Movie> getHome(String movieType,Integer pageSize);
    List<Movie> getCategory(String movieType,Integer pageSize);
}
