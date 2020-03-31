package club.banyuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @GetMapping("/user/{username}")
    String getUserBlog(@PathVariable String username,
                       @RequestParam(required = false, defaultValue = "1") Integer page,
                       @RequestParam(required = false, defaultValue = "2") Integer size,
                       Model model
    ) {
        User user = userService.getUserByName(username);
        PageInfo blog = blogService.pageUserBlogs(username, page, size);
        model.addAttribute("user", user);
        model.addAttribute("blog", blog);

        return "list";

    }
}
