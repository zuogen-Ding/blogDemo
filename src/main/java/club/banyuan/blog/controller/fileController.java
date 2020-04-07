package club.banyuan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


@Controller
public class fileController {

//    @GetMapping("/upload")
//    String showUploadHtml(){
//        return "upload";
//    }
//    @PostMapping("/upload")
//    String doFileLoad(@RequestParam MultipartFile file){
//        String fileName=file.getOriginalFilename();
//        try {
//            Files.copy(file.getInputStream(), Paths.get("/Users/edz/Desktop/spring/blog/src/main/resources/static/",fileName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/picView/" + fileName;
//    }
}
