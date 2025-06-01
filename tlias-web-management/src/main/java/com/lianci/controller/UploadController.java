package com.lianci.controller;

import com.lianci.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@RestController
public class UploadController{

    @PostMapping("/upload")
    public Result upload(String name, Integer age , MultipartFile file) throws Exception{
        log.info("接受参数：{},{},{}", name, age, file);
        file.transferTo(new File("C:\\Users\\zdx\\Desktop/" + file.getOriginalFilename()));
        return Result.success();
    }
}
