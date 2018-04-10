package com.example.spring.mysql.model;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
@Component
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idUser;

    private String username;
    private String password;
    private String email;
    private Integer idRole;

    public Users() {
        this.username = "";
    }

    public Users(Long idUser) {
        this.idUser = idUser;
    }

    public Users(String username, String password, String email, Integer idRole) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.idRole = idRole;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdRole() {
        return idRole;
    }
}
