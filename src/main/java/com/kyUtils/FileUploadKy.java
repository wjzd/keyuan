package com.kyUtils;

import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传
 */
public class FileUploadKy {

    public static String fileUpload(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam(value = "file") MultipartFile file) throws IOException {

        String path = null;// 文件路径
        String json = "";
        String hint="";
        if (file!=null) {// 判断上传的文件是否为空

            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
            System.out.println("上传的文件原名称:"+fileName);
            // 判断文件类型
            type = fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
            if (type!=null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();

                    realPath=realPath+"upload/";


                    System.out.println("根路径："+realPath);
                    // 自定义的文件名称
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
                    System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

                    String trueFileName = df.format(new Date())+ Ran.getItemID() + "." + type;
                    // 设置存放图片文件的路径
                    path = realPath+/*System.getProperty("file.separator")+*/trueFileName;
                    System.out.println("存放图片文件的路径:"+path);
                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
                    hint="success";
                    System.out.println("文件成功上传到指定目录下");

                    /*json = "{\"res\":1}";*/
                }else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    hint="文件类型错误";
                }
            }else {
                System.out.println("文件类型为空");

                hint="文件类型为空";

            }
        }else {
            System.out.println("没有找到相对应的文件");
            hint="没有找到相对应的文件";

        }
        /*response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);*/
        return hint;
    }

}