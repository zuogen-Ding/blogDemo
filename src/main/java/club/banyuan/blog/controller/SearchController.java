package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class SearchController {
    @Autowired
    private BlogService blogService;

    //通过参数查找对应的值并返回
    @GetMapping("/search")
    String getResultBySearch(@RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "2") Integer size,
                             HttpSession session,
                             Model model) {

        String keyword = (String) session.getAttribute("KEYWORD");
        PageInfo blog = blogService.pageUserBlogsByKeyWord(keyword, page, size);
        session.removeAttribute("KEYWORD");
        model.addAttribute("blog",blog);
        return "list";
    }




}
