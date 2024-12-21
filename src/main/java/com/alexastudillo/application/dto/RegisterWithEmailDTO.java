package com.alexastudillo.application.dto;

public class RegisterWithEmailDTO {
    private String email;
    private String password;

    public RegisterWithEmailDTO() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
