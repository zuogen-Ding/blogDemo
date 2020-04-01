package club.banyuan.blog.dao;

import club.banyuan.blog.bean.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogDao {
    List<Blog> selectBlogsByUsername(String username) ;
    Blog selectBlogById(Integer id);

}
