package com.example.springbootappdemo.Contorller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String upload(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(nickname);
        // 文件名称
        System.out.println(photo.getOriginalFilename());
        // 文件类型
        System.out.println(photo.getContentType());
        System.out.println(System.getProperty("user.dir"));

        String path = request.getServletContext().getRealPath("/upload/");
        // 文件存储路径（会动态变化）
        System.out.println(path);

        saveFile(photo,path);
        return "upload succeed";
    }

    public void saveFile(MultipartFile photo,String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }

        File file = new File(path+photo.getOriginalFilename());
        // 自动将网络上传输的photo文件对象存储到file路径中
        photo.transferTo(file);
    }
}
