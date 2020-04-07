package club.banyuan.blog.service;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private BlogDao blogDao;
    @Autowired
    public BlogService(BlogDao blogDao) {
        this.blogDao = blogDao;
    }

    public List<Blog> selectBlogsByUsername(String username){
        return blogDao.selectBlogsByUsername(username);
    }

    public Blog getBlogById(Integer id){
        return blogDao.selectBlogById(id);
    }

    public void createBlog(Blog blog){
        blogDao.creatBlog(blog);
    }

    public void deleteBlog(Integer id){
        blogDao.deleteBlog(id);
    }

    public void updateBlog(Blog blog){
        blogDao.updateBlog(blog);
    }

    public Blog selectBlogsDetailByBlogId (Integer id){
        return blogDao.selectBlogsDetailByBlogId(id);

    }

    public List<Blog> selectAllBlogs(){
        return blogDao.selectAllBlogs();
    }

    public List<Blog> selectBlogByKeyword(String keyword){
        return blogDao.selectBlogByKeyWord(keyword);
    }

}
