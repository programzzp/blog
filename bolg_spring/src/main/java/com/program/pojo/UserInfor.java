package com.program.pojo;


public class UserInfor {
    private String username;
    private String password;
    private String features; //爱好
    private String project;  //项目
    private String avatar;   //头像

    private UserInfor(){}

    public UserInfor(String username, String password, String features, String project, String avatar) {
        this.username = username;
        this.password = password;
        this.features = features;
        this.project = project;
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "UserInfor{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", features='" + features + '\'' +
                ", project='" + project + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
