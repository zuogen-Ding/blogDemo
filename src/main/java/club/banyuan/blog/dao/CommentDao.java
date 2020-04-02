package club.banyuan.blog.dao;

import club.banyuan.blog.bean.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    List<Comment> selectCommentByBlogId(Integer id);

}
