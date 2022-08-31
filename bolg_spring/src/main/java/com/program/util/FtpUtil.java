package com.program.util;


import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Properties;

@Component
public class FtpUtil {

    private static final Logger logger= LoggerFactory.getLogger(FtpUtil.class);

    @Value("${ftp.imgUrl}")
    private String imgUrl;

    @Value("${ftp.host}")
    private String host;

    @Value("${ftp.userName}")
    private String userName;

    @Value("${ftp.password}")
    private String password;

    @Value("${ftp.port}")
    private String port;

    @Value("${ftp.rootPath}")
    private String rootPath;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    private ChannelSftp getChannel() throws JSchException {
        JSch jSch=new JSch();

        Session session = jSch.getSession(userName, host, Integer.parseInt(port));
        session.setPassword(password);
        Properties sshConfig = new Properties();
        // 设置第一次登陆的时候提示，可选值：(ask | yes | no)
        session.setConfig("StrictHostKeyChecking", "no");
        session.setConfig(sshConfig);
        //设置登陆超时时间
        // 注意！！这里不设置超时间会报错
        session.connect(60000);

        Channel channel = session.openChannel("sftp");
        channel.connect(1000);

        return (ChannelSftp) channel;
    }

    public String putImages(InputStream inputStream, String imagesName){
        try{
            /**
             * 登录centos
             */
            ChannelSftp channel = getChannel();
            //传递文件到那个路径下
            String path=rootPath;
            //
            createDir(path, channel);

            //传入文件
            channel.put(inputStream,path+imagesName);


            channel.quit();
            channel.exit();

            String resultFile;
            resultFile=imgUrl+imagesName;

            return resultFile;

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("失败");
        }

        return "";
    }

    @Override
    public String toString() {
        return "FtpUtil{" +
                "imgUrl='" + imgUrl + '\'' +
                ", host='" + host + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", port='" + port + '\'' +
                ", rootPath='" + rootPath + '\'' +
                '}';
    }




    /**
     * 创建目录
     */
    private void createDir(String path, ChannelSftp sftp) throws SftpException {
        String[] folders = path.split("/");
        sftp.cd("/");
        for (String folder : folders) {
            if (folder.length() > 0) {
                try {
                    sftp.cd(folder);
                } catch (SftpException e) {
                    sftp.mkdir(folder);
                    sftp.cd(folder);
                }
            }
        }
    }

    /**
     * 删除图片
     */
    public void delImages(String imagesName) {
        try {
            ChannelSftp sftp = getChannel();
            String path = rootPath +  imagesName;
            sftp.rm(path);
            sftp.quit();
            sftp.exit();
        } catch (Exception e) {
            logger.error(" 删除失败：" + e.getMessage());
        }
    }

}
