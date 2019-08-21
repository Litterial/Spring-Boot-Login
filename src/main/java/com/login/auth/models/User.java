package com.login.auth.models;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {
 @Id
 @GeneratedValue
    private int id;

 @Column(unique = true)
 @NotNull
 @Size(min=5,max=20)
 @Pattern(regexp = "\\S+", message="Spaces are not allowed")
    private String username;

 @NotNull
 @Size(min=8)
 @Pattern(regexp ="\\S+", message="Spaces are not allowed")
    private String password;
 @ManyToMany(cascade = CascadeType.ALL)
 @JoinTable(name="USER_ROLES",
         joinColumns = {@JoinColumn(name="USER_USERNAME",referencedColumnName = "username")},
         inverseJoinColumns = {@JoinColumn(name="ROLE_role",referencedColumnName = "role")})
    private Set<Role> roles;

    public User(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
