package com.login.auth.models;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    private String role;

    public Role(){};
    public Role(String role)
    {
        this.role=role;
    }

    @ManyToMany(mappedBy = "roles") //mappedBy used on non-owning side the value of of the identifier is the name of the field used in the owning side.
    private List<User> users;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



}
