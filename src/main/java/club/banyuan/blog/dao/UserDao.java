package club.banyuan.blog.dao;

import club.banyuan.blog.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUserByName(String name);

}
