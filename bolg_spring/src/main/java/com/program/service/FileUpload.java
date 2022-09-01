package com.program.service;


import com.program.pojo.Result;
import com.program.pojo.StatusCode;
import com.program.util.FtpUtil;
import com.program.util.ImageFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileUpload {

    @Autowired
    private FtpUtil ftpUtil;


    /**
     * 图片上传
     * @param image
     * @return
     */
    public String imageFileUpload(MultipartFile image){

        //获取图片名称
        String imageName = image.getOriginalFilename();


        //判断是否为图片
        if (ImageFile.judgeImageFileType(imageName)){

            //防止上传的两个图片
            String uploadName= UUID.randomUUID()+imageName;


            InputStream inputStream=null;
            try {
                inputStream = image.getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }

            /**
             * 将图片传递到nginx服务器中
             * 返回图片url地址
             */
            String imgPath = ftpUtil.putImages(inputStream, uploadName);


           return imgPath;

        }else {
            return null;
        }
    }

}
