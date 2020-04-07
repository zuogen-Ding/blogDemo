package club.banyuan.blog.controller;

import club.banyuan.blog.bean.User;
import club.banyuan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    String showLoginHtml(HttpSession session,
                         @RequestParam(required = false) String next) {

        if (next != null) session.setAttribute("NEXT_URI", next);
        return "login";
    }

    @PostMapping
    String login(@RequestParam String username,
                 @RequestParam String password,
                 HttpSession session) throws UnsupportedEncodingException {
        User user = null;
        String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        if (username.matches(regex)) {
            user = userService.getUserByEmail(username);
        } else {
            user = userService.getUserByName(username);
        }
        if (user != null && password.equals(user.getPassword())) {
            session.setAttribute("USER", user);
            String uri = (String) session.getAttribute("NEXT_URI");
            if (uri != null) {
                session.removeAttribute("NEXT_URI");
                return "redirect:" + uri;
            }

            return "redirect:/admin/"+ URLEncoder.encode(user.getName(),"utf-8");

        }
        return "redirect:/login";
    }
}
