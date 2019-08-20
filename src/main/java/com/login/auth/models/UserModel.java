package com.login.auth.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class UserModel {
 @Id
 @GeneratedValue
    private int id;

 @NotNull
 @Size(min=5,max=20)
 @Pattern(regexp = "\\S+", message="Spaces are not allowed")
    private String username;

 @NotNull
 @Size(min=8)
 @Pattern(regexp ="\\S+", message="Spaces are not allowed")
    private String password;
}
