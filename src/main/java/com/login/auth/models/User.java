package com.login.auth.models;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity

public class User {
 @Id
 @Column(unique = true) //looks for a unique column name
 @NotNull(message="This field is required")
 @Size(min=5,max=20)
 @Pattern(regexp = "\\S+", message="Spaces are not allowed") //regex pattern to not allow spaces
    private String username;

 @NotNull(message="This field is required")
 @Size(min=8,message="Passwords must be a minimum of 8 charaters")
 @Pattern(regexp ="\\S+", message="Spaces are not allowed") //regex pattern to not allow spaces
    private String password;

 @ManyToMany(cascade = CascadeType.ALL)//multiple roles can be assigned to multiple people
 @JoinTable(name="USER_ROLES", //creates a table for the relationship between User and Role. User is the owning side
         joinColumns = {@JoinColumn(name="USER_USERNAME",referencedColumnName = "username")}, // primary key for the owning side (User)
         inverseJoinColumns = {@JoinColumn(name="ROLE_ROLE",referencedColumnName = "role")}) //primary key for the non-owning side;reference the name of the column in the other class
    private List<Role> roles;

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
