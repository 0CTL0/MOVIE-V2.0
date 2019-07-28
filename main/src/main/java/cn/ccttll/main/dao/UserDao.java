package cn.ccttll.main.dao;

import cn.ccttll.main.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public interface UserDao {
    User selectByUsernameAndPassword(@Param("userName") String username,@Param("userPassword") String Password);
    int insertUser(User user);
}
