package com.syning.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Slf4j

/**
 *  文件上传测试
 */
@Controller
public class FormController {


    /**
     *
     * @param headerImg     // 单文件文件
     * @param photos        // 多文件
     */
    @PostMapping("/upload")
    public String upload(@RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息: headerImg文件大小={}, photos上传了几个文件={}",headerImg.getSize(), photos.length);

        // 文件不等于空
        if (!headerImg.isEmpty()) {
            // 保存到文件服务器，或者 OSS 服务器

            // 获取文件名
            String fileName = headerImg.getOriginalFilename();
            // 转移到磁盘
            headerImg.transferTo(new File("D:\\imgs\\" + fileName));
        }


        // 文件数量大于 0
        if (photos.length > 0) {
            for (MultipartFile m : photos) {
                if (!m.isEmpty()) {
                    String fileName = m.getOriginalFilename();
                    m.transferTo(new File("D:\\imgs\\" + fileName));
                }
            }
        }

        return "redirect:/index";  // 重定向到 index 页面
    }






    @GetMapping("/formlayouts")
    public String formlayouts() {

        return "form/form_layouts";
    }

}
