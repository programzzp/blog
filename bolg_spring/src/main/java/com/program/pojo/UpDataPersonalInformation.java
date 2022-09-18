package com.program.pojo;

public class UpDataPersonalInformation {
    private PersonalInformation personalInformation;
    private String username;

    public UpDataPersonalInformation(PersonalInformation personalInformation, String username) {
        this.personalInformation = personalInformation;
        this.username = username;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UpDataPersonalInformation{" +
                "personalInformation=" + personalInformation +
                ", username='" + username + '\'' +
                '}';
    }
}
