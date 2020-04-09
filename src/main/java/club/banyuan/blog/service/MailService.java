package club.banyuan.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;


    public void sendActiveMessage(String username) {
        String message = "你已经注册半圆网络的blog，请点击如下链接进行激活";
        String url = "http://localhost:8080/active?token=";
        long token = (new Date()).getTime();
        // b) 将token和用户名保存在redis上
        redisService.storeToken("" + token, username, 60);
        url += token;
        message += url;

        String email = userService.getUserByName(username).getEmail();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("2245617623@qq.com");
        mailMessage.setTo(email);//接收邮件的邮箱
        mailMessage.setSubject("半圆网络激活邮件");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
