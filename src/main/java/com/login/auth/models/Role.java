package com.login.auth.models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue
    private int id;

    private String role;

    @ManyToMany(mappedBy = "roles") //mappedBy used on non-owning side the value of of the identifier is the name of the field used in the owning side.
    private List<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
