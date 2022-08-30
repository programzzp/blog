package com.program.pojo;

import javax.security.auth.login.Configuration;

public class ContentData {
    String id;
    String title; //标题
    String introduce; //介绍
    String date;  //时间
    String article; //内容
    String classification; //分类

    public ContentData(){}


    public ContentData(String id, String title, String introduce, String date, String article, String classification) {
        this.id = id;
        this.title = title;
        this.introduce = introduce;
        this.date = date;
        this.article = article;
        this.classification = classification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getData() {
        return date;
    }

    public void setData(String date) {
        this.date = date;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "ContentData{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                ", data='" + date + '\'' +
                ", article='" + article + '\'' +
                ", classification='" + classification + '\'' +
                '}';
    }
}
