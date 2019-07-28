package cn.ccttll.main.controller;

import cn.ccttll.main.entity.Comment;
import cn.ccttll.main.entity.Movie;
import cn.ccttll.main.service.MovieService;
import cn.ccttll.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller("movieController")
@RequestMapping("/movie")
public class MovieControlle {
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Map<String,Object> map){
        map.put("actionMovies",movieService.getHome("动作片",12));
        map.put("LoveMovies",movieService.getHome("爱情片",12));
        map.put("comedyMovies",movieService.getHome("喜剧片",12));
        return "home";
    }

    @RequestMapping("/detail")
    public String detail(@RequestParam(value = "movieId") Integer movieId,Map<String,Object> map){
        map.put("movie",movieService.getMovie(movieId));
        map.put("comments",userService.getAllCommentByMovieId(movieId));
        return "detail";
    }

    @RequestMapping("/search")
    public String search(@RequestParam(value = "movieName") String movieName,Map<String,Object> map){
        List<Movie> searchMovies=new ArrayList<Movie>();
        searchMovies=movieService.getMovie(movieName);
        Integer resultTotal=searchMovies.size();
        map.put("resultTotal",resultTotal);
        map.put("searchMovies",movieService.getMovie(movieName));
        return "search";
    }


    @RequestMapping(value = "/category")
    public String category(@RequestParam(value = "page",required = false)String pageStr,@RequestParam(value = "movieType")String movieType,Map<String,Object> map){
//        int page=1;  //页码默认值
//        if (null != pageStr && (!"".equals(pageStr))) {
//            try {
//                page = Integer.parseInt(pageStr);
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
//        }
//        int count=movieService.countMovie(movieType);
//        int last=count%15==0?(count/15):((count/15)+1);
//        map.put("page",page);
//        map.put("last",last);
        map.put("categoryMovies",movieService.getCategory(movieType,15));
        map.put("scoreMovies",movieService.getCategory(movieType,10));
        return "category";
    }
}
