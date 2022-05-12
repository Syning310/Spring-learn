package com.syning.boot.boot04web02.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormController {

    @GetMapping(value = "formlay")
    public String form_layouts() {

        return "form/form_layouts";
    }


    /**
     * MultipartFile 自动封装上传来的文件
     *
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping(value = "/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart(value = "headerImg") MultipartFile headerImg,
                         @RequestPart(value = "photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息: email={}, username={}, headerImg={}, photos={}",
                email, username, headerImg.getSize(), photos.length);


        if (!headerImg.isEmpty()) {
            // 保存到文件服务器，或 OSS 服务器
            String fileName = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\" + fileName));
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String fileName = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\z\\" + fileName));
                }
            }
        }

            return "redirect:/main.html";
    }


}
