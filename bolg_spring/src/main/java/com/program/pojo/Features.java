package com.program.pojo;

public class Features {
    private String username;
    private String features;

    public Features(){

    }

    public Features(String username, String features) {
        this.username = username;
        this.features = features;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "Features{" +
                "username='" + username + '\'' +
                ", features='" + features + '\'' +
                '}';
    }
}
