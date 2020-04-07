package club.banyuan.blog.service;

import club.banyuan.blog.bean.Comment;
import club.banyuan.blog.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentDao commentDao;
    @Autowired
    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public List<Comment> selectCommentByBlogId(Integer id){
        return commentDao.selectCommentByBlogId(id);
    }

}
