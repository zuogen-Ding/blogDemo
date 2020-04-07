package club.banyuan.blog.controller;

import club.banyuan.blog.bean.Blog;
import club.banyuan.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    @GetMapping(value = {"/","/homepage"})
    String showIndex(@RequestParam Optional<Integer> page,
                    @RequestParam Optional<Integer> size,
                    Model model){
        PageHelper.startPage (page.orElse (1),size.orElse (10),"id asc");
        List<Blog> blogs=blogService.selectAllBlogs();
        PageInfo pageInfo=new PageInfo (blogs);
        model.addAttribute ("blogs",pageInfo);
        return "homepage";
    }
}
