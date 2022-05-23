package com.medway.registration;


import org.springframework.stereotype.Component;
@Component
public class registration
{
    private String username;
    private String fullname;
    private String mailid;
    private String password;
    private String conpassword;
    private String gender;
    private String dob;
    private String phno;
    private String bld;
    private String city;


    public registration() {}

    public registration(String username, String fullname, String mailid, String password, String conpassword, String gender, String dob, String phno, String bloodgrp, String city) {
        this.username = username;
        this.fullname = fullname;
        this.mailid = mailid;
        this.password = password;
        this.conpassword = conpassword;
        this.gender = gender;
        this.dob = dob;
        this.phno = phno;
        this.bld = bloodgrp;
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMailid() {
        return mailid;
    }

    public void setMailid(String mailid) {
        this.mailid = mailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConpassword() {
        return conpassword;
    }

    public void setConpassword(String conpassword) {
        this.conpassword = conpassword;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getBld() {
        return bld;
    }

    public void setBld(String bld) {
        this.bld = bld;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "registration{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", mailid='" + mailid + '\'' +
                ", password='" + password + '\'' +
                ", conpassword='" + conpassword + '\'' +
                ", gender='" + gender + '\'' +
                ", dob='" + dob + '\'' +
                ", phno='" + phno + '\'' +
                ", bld='" + bld + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
