package cn.ccttll.main.service;

import cn.ccttll.main.entity.Comment;
import cn.ccttll.main.entity.User;

import java.util.List;

public interface UserService {
    User getByUserNameAndPassword(String UserName,String Password);
    int add(User user);
    void addComment(Comment comment);
    List<Comment> getAllCommentByMovieId(Integer movieId);
}
