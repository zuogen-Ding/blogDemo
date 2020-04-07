package club.banyuan.blog.dao;

import club.banyuan.blog.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUserByName(String name);
    User selectUserByEmail(String email);
    User selectUserByBlogId(Integer id);

}
