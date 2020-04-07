package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.Comment;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.BlogService;
import club.banyuan.blog.service.CommentService;
import club.banyuan.blog.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @GetMapping("blog/{blogId}")
    String getBlogByBlogId(@PathVariable(value = "blogId") Integer id, Model model){
        Blog blog =blogService.getBlogById(id);
        List<Comment> comments = commentService.selectCommentByBlogId(id);
        model.addAttribute ("blog",blog);
        model.addAttribute ("comments",comments);
        return "item";
    }


    @GetMapping("/user/{username}")
    String getUserBlog(@PathVariable String username,
                       @RequestParam(required = false, defaultValue = "1") Integer page,
                       @RequestParam(required = false, defaultValue = "2") Integer size,
                       Model model
    ) {
        User user = userService.getUserByName(username);
        PageInfo blog = blogService.pageUserBlogsByUsername(username, page, size);
        model.addAttribute("user", user);
        model.addAttribute("blog", blog);
        return "list";

    }

    @GetMapping("/blog/{id}")
    String showBlogById(@PathVariable(value = "id")  Integer id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        return "item";
    }


    @GetMapping("blog/edit")
    String createBlog(@RequestParam(value = "title") String title,
                @RequestParam(value = "content") String content,
                HttpSession session){
            Blog blog=new Blog ();
            User user =(User) session.getAttribute ("USER");
            blog.setAuthor (user);
            blog.setTitle (title);
            blog.setContent (content);
            blogService.createBlog(blog);
            return "redirect:/blog/"+blog.getId ();


    }

    @DeleteMapping("blog/{blogId}")
    String deleteBlogByBlogId(@PathVariable(value = "blogId") Integer blogId,
                              HttpSession session ){
        User user=(User)session.getAttribute ("USER");
        Blog blog = blogService.selectBlogsDetailByBlogId (blogId);
        if(user.getName ().equals (blog.getAuthor ().getName ())){
            blogService.deleteBlog(blogId);
        }

        return "redirect:/admin";
    }


    @GetMapping("blog/{blogId}/edit")
    String showEdit(@PathVariable(value = "blogId") Integer id,Model model){
        Blog blog = blogService.getBlogById (id);
        model.addAttribute ("blog",blog);
        return "edit";
    }

    @PutMapping("blog/{blogId}/edit")
    String updateBlog(@PathVariable(value = "blogId") Integer id,
                      @RequestParam String title,
                      @RequestParam String content){
        Blog blog=new Blog();
        blog.setId(id);
        blog.setTitle(title);
        blog.setContent(content);
        blogService.updateBlog(blog);
        return "redirect:/blog/"+id;
    }
}
