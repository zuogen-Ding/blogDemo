package club.banyuan.blog.controller;

import club.banyuan.blog.service.MailService;
import club.banyuan.blog.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class MailController {
    private MailService mailService;

    @Autowired
    private RedisService redisService;
    @ResponseBody
    @PostMapping("/mail/send-active-mail")
    String sendActiveMail(Principal principal) {
        String username = principal.getName();
        mailService.sendActiveMessage(username);
        return "邮件已发送";
    }

    @ResponseBody
    @GetMapping("/active")
    String activeAccount(@RequestParam(value = "token") String token) {
        // 使用token查找redis上的用户名
        String username = redisService.getUsernameByToken(token);
        if (username == null) {
            return "用户不存在";
        }
        else {
           return "激活成功";
        }
    }
}
