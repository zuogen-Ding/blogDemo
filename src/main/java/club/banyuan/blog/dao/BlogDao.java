package club.banyuan.blog.dao;

import club.banyuan.blog.bean.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogDao {
    Blog selectBlogById(Integer id);
    List<Blog> selectBlogsByUsername(String username);
    Blog selectBlogsDetailByBlogId(Integer id);
    void creatBlog(Blog blog);
    void deleteBlog(Integer id);
    void updateBlog(Blog blog);
    List<Blog> selectAllBlogs();
    List<Blog> selectBlogByKeyWord(String keyword);
}
