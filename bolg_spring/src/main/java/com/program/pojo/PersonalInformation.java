package com.program.pojo;

public class PersonalInformation {
    private String school ;     //学校
    private String name;        //姓名
    private String education;   //学历
    private String mail;        //电子邮件地址
    private String phone;       //手机号
    private String address;     //家庭住址


    public PersonalInformation(){}


    public PersonalInformation(String school, String name, String education, String mail, String phone, String address) {
        this.school = school;
        this.name = name;
        this.education = education;
        this.mail = mail;
        this.phone = phone;
        this.address = address;
    }


    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "school='" + school + '\'' +
                ", name='" + name + '\'' +
                ", education='" + education + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
