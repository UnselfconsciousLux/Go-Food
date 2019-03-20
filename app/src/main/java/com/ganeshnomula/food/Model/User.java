package com.ganeshnomula.food.Model;

/**
 * Created by ganeshnomula on 3/19/18.
 */

public class User {
    private int userId;
    private String fullname;
    private String password;
    private String phonenumber;
    private String email;
    private String usertype;

    public User() {
    }

    public User(String fullname, String password, String email, String usertype) {
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.usertype = usertype;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {return phonenumber;}

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
