package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/admin")
    String showAdmin(HttpSession session,
                     @RequestParam Optional<Integer> page,
                     @RequestParam Optional<Integer> size,
                     Model model) {
        User user = (User) session.getAttribute("USER");
        PageHelper.startPage(page.orElse(1), size.orElse(10));
        List<Blog> blogs = blogService.selectBlogsByUsername(user.getName());
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("blogs", pageInfo);
        model.addAttribute("username", user.getName());
        return "admin";

    }
}
