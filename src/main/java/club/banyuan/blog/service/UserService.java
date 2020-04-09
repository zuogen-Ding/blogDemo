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

    public User getUserByEmail(String email) {
        return userDao.selectUserByEmail(email);
    }

    public void updatePasswd(String newPasswd, Integer id) {
        userDao.updatePassword(newPasswd, id);
    }
    public User getUsrByBlogId(Integer id){
        return userDao.selectUserByBlogId(id);
    }

    public void setUserByAvatar(Integer id, String avatar) {
        userDao.updateUser(id,avatar);
    }
}
