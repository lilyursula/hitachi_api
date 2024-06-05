package com.example.hitachi_store.entity;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "user")

public class HitachiStoreUser {
    
    @Id
    @Column(name = "id", length = 12)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @Column(name = "username", length = 45)
    private String username;
 
    @Column(name = "email", length = 45)
    private String email;
 
    @Column(name = "password", length = 12)
    private String password;

    @Column(name = "role", length = 12)
    private String role;
 
    public HitachiStoreUser(int id, String username, String email, String password, String role) {
        this.id         = id;
        this.username   = username;
        this.email      = email;
        this.password   = password;
        this.role       = role;
    }
 
    public HitachiStoreUser() {
    }

    public HitachiStoreUser(String username, String email, String password, String role) {
        this.username   = username;
        this.email      = email;
        this.password   = password;
        this.role       = role;
    }
 
    public int getHitachiStoreUserId() {
        return id;
    }
 
    public void setHitachiStoreUserId(int id) {
        this.id = id;
    }
 
    public String getHitachiStoreUserUsername() {
        return username;
    }
 
    public void setHitachiStoreUserUsername(String username) {
        this.username = username;
    }
 
    public String getHitachiStoreUserEmail() {
        return email;
    }
 
    public void setHitachiStoreUserEmail(String email) {
        this.email = email;
    }

    public String getHitachiStoreUserPassword() {
        return password;
    }
 
    public void setHitachiStoreUserPassword(String password) {
        this.password = password;
    }
 
    public String getHitachiStoreUserRole() {
        return role;
    }
 
    public void setHitachiStoreUserRole(String role) {
        this.role = role;
    }
 
    @Override
    public String toString() {
        return "hitachiStoreUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

    public static Object withDefaultPasswordEncoder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'withDefaultPasswordEncoder'");
    }

    public void save(HitachiStoreUser hitachiStoreUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
