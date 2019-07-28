package cn.ccttll.common;

import java.util.UUID;

public class UploadUtil {
    /*
     * 生成唯一的文件名，解决文件重名问题：
     */
    public static String getUUIDFileName(String fileName) {
        //将文件名的前面部分进行截取：xx.jpg————》.jpg
        int idx=fileName.lastIndexOf(".");
        String extention=fileName.substring(idx);
        //把随机生成的文件名的-去掉
        String uuidFileName= UUID.randomUUID().toString().replace("-","")+extention;
        return uuidFileName;
    }

    public static void main(String[] args) {
        //该类可以生成随机地文件名
        System.out.println(UUID.randomUUID());
    }
}

