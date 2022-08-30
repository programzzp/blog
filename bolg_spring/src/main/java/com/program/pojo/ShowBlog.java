package com.program.pojo;

public class ShowBlog {
    private int page;
    private int size;

    public ShowBlog(){}

    public ShowBlog(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "ShowBlog{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
