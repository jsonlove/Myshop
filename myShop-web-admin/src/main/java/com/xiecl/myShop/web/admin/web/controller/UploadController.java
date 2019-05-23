package com.xiecl.myShop.web.admin.web.controller;

import com.xiecl.myShop.commons.constans.ConstansUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,Object> upload( MultipartFile dropfile, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        //获取文件名.getName()文件名.getOriginalFilename() 带后缀文件名
        String filename=dropfile.getOriginalFilename();
        //获取存储路径
        String path= ConstansUtil.UPLOAD_IMG_PATH;
        //获得项目根路径
        //String filePath = request.getSession().getServletContext().getRealPath("/static/upload");
        //获取文件后缀
        String filesuffix=filename.substring(filename.lastIndexOf("."));
        //生成储存文件夹对象
        File file=new File(path);
        //判断文件夹存在
        if(!file.exists()){
            file.mkdir();
        }
        //为文件生成独立文件名
        file=new File(path, UUID.randomUUID()+filesuffix);
        String path11 = file.getPath();
        try {
            //写入文件
            dropfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return map;
    }
}
