package com.javirock.cleanarchevents.businesslayer.models;


public class RegistrationModel {
    private String userName;
    private String password;
    private String email;

    public RegistrationModel(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
