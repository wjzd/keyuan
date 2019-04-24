package com.controller;

import com.kyUtils.FileUploadKy;
import com.kyUtils.Ran;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUpload {


    @RequestMapping("/upload")
    public String fileUpload(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(value = "file") MultipartFile file)throws IOException {


        String hint=FileUploadKy.fileUpload(request,response,file);


        return "fileUpload.html";

    }



}
