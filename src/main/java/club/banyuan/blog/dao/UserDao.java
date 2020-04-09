package club.banyuan.blog.dao;

import club.banyuan.blog.bean.User;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUserByName(String name);
    User selectUserByEmail(String email);
    User selectUserByBlogId(Integer id);
    void updatePassword(String newPw, Integer id);
    void updateUser(Integer id,String avatar);

}
