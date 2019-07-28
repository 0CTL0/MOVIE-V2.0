package cn.ccttll.main.controller;

import cn.ccttll.main.entity.Comment;
import cn.ccttll.main.entity.User;
import cn.ccttll.main.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller("UserController")
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/regist")
    public String regist(){
        return "regist";
    }
    @RequestMapping("/toRegist")
    public String toRegist(User user, Map<String,Object> map,RedirectAttributes redirectAttributes){
        //后台验证注册数据
        String usernameRegex = "[a-zA-Z]{6,12}";
        boolean flag1 = user.getUserName().matches(usernameRegex);
        String passRegex = "[0-9]{6,}";
        boolean flag2 = user.getUserPassword().matches(passRegex);
        String phoneRegex ="[1][3578][0-9]{9}";
        boolean flag3 = user.getUserPhone().matches(phoneRegex);
        String emialRegex ="[a-zA-Z_0-9]{3,}@([a-zA-Z]+|\\d+)(\\.[a-zA-Z]+)+";
        boolean flag4 = user.getUserEmail().matches(emialRegex);
        if(!(flag1&&flag2&&flag3&&flag4)){
            String msg="请按要求的格式输入";
            map.put("msg",msg);
           return "regist";
        }
        else{
            if(userService.add(user)>0){
               // redirectAttributes.addFlashAttributie("userName",user.getUserName());  redirectAttributes的方法无法使用？？
                return "redirect:/user/login";
            }
            else{
                String msg="注册失败";
                map.put("msg",msg);
                return "regist";
            }
        }
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, @RequestParam(value = "userName") String userName, @RequestParam(value = "userPassword") String userPassword,Map<String,Object> map){
        User user=userService.getByUserNameAndPassword(userName,userPassword);
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/movie/home";
        }
        else {
            String msg="请输入正确的用户名或密码";
            map.put("msg",msg);
            return "login";
        }
    }
    //,@Param(value = "input_comment") String comtent
    @RequestMapping("/comment")
    public String addComment(HttpSession session, @Param(value = "movieId") Integer movieId, Comment comment, RedirectAttributes attributes){
        //空指针异常User user=(User) session.getAttribute("user");
        User user=(User) session.getAttribute("user");
        if(user!=null){
                Date date =new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
                String commentDataTime = sdf.format(date);
                Comment comment2=new Comment();
                comment2.setUserName(user.getUserName());
                comment2.setMovieId(movieId);
                comment2.setComment(comment.getComment());
                comment2.setCommentDataTime(commentDataTime);
                userService.addComment(comment2);
                return "redirect:/movie/detail?movieId="+movieId;
            }
            else {
                String msg="请登录后评论";
                attributes.addFlashAttribute("msg", msg);
                return "redirect:/user/login";
            }
    }

}
