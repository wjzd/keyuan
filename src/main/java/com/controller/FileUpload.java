package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.InputStream;

@Controller
public class FileUpload {

    @RequestMapping("/upload")
    public String fileUpload(HttpServletRequest req, @RequestParam(value="file")MultipartFile file)throws Exception{

        InputStream inputStream=null;
        try {
            inputStream=file.getInputStream();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "fileUpload.html";
    }
}
