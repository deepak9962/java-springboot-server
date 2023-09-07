package com.example.learn.learner.entity;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {

    @Id
    private String _id;

    private String first_name;

    private String last_name;

    private String email;

    private String gender;

    private String avatar;

    private String domain;

    private boolean available;

    public Users(String _id,
                 String first_name,
                 String last_name,
                 String email,
                 String gender,
                 String avatar,
                 String domain,
                 boolean available) {
        this._id = _id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
        this.domain = domain;
        this.available = available;
    }

    public Users() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
