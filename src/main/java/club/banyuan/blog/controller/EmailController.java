package club.banyuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
    @PostMapping("/email/{emailId}/{}")
    String sendEmail(){
        return null;
    }
}
