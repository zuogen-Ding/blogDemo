package club.banyuan.blog.service;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserByName(String name){
        return userDao.selectUserByName(name);
    }

}
