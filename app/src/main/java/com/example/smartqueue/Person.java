package com.example.smartqueue;

public class Person {

    //params
    private String email;
    private String phone;
    private String username;
    private String password;


    //constractor full

    public Person(String email,String phone,String username, String password) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.email = email;

    }

    public Person(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //empty constractor empty

    public Person(){

}


}