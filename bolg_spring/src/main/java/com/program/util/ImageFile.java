package com.program.util;

import java.util.ArrayList;


/**
 * 文件类型确认
 */

public class ImageFile {
    private static ArrayList<String> image_file;

    static {
        image_file=new ArrayList<>();
        image_file.add(".png");
        image_file.add(".gif");
        image_file.add(".jpg");
        image_file.add(".PNG");
        image_file.add(".GIF");
        image_file.add(".JPG");
    }


    /**
     * 判断是否为文件类型
     * @param imageFileName 文件名
     * @return
     */
    public static boolean judgeImageFileType(String imageFileName){
        String type = imageFileName.substring(imageFileName.lastIndexOf("."));
        //System.out.println(type);
        if (image_file.contains(type)){
            return true;
        }else{
            return false;
        }
    }
}
