package club.banyuan.blog.dao;

import club.banyuan.blog.bean.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogDao {
    Blog selectBlogById(Integer id);
    List<Blog> selectBlogsByUsername(String username);
    List<Blog> selectBlogsDetailByUsername(String username);
    void creatBlog(Blog blog);
}
