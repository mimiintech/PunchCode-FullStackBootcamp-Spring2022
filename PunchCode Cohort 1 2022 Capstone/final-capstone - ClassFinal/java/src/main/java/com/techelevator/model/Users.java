package com.techelevator.model;


public class Users {

    private int users_id;
    private String email;
    private String password_hash;
    private String allow;


  public Users() { }

    public Users(int users_id, String email, String password_hash, String allow) {
        this.users_id = users_id;
        this.email = email;
        this.password_hash = password_hash;
        this.allow = allow;
    }

    //   Users_Id
    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

//    Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    Password
    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

//    Allow

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }
}

