package cn.ccttll.main.service.impl;

import cn.ccttll.main.dao.CommentDao;
import cn.ccttll.main.dao.UserDao;
import cn.ccttll.main.entity.Comment;
import cn.ccttll.main.entity.User;
import cn.ccttll.main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceimpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommentDao commentDao;

   public User getByUserNameAndPassword(String userName,String password){
        return userDao.selectByUsernameAndPassword(userName,password);
    }

    public int add(User user){
        return userDao.insertUser(user);
    }

    public void addComment(Comment comment){
        commentDao.insertComment(comment);
    }

    public List<Comment> getAllCommentByMovieId(Integer movieId){
       return commentDao.selectBymovieId(movieId);
    }
}
