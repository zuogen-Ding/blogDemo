package club.banyuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogController {
    @GetMapping("/user/{username}")
    @ResponseBody
    String getUserBlog(@PathVariable String username) {

        return "访问"+username+"的博客";

    }

}
