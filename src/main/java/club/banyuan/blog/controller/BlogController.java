package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.BlogService;
import club.banyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private UserService userService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/user/{username}")
    String getUserBlog(@PathVariable String username,
                       @RequestParam(required = false, defaultValue = "1") Integer page,
                       @RequestParam(required = false, defaultValue = "2") Integer size,
                       Model model
    ) {
        User user = userService.getUserByName(username);
        List<Blog> blog = blogService.selectBlogsByUsername(username);
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
}
