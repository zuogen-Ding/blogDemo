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

}
