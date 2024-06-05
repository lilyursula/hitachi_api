package com.example.hitachi_store.DTO;
 
public class HitachiStoreUserSaveDTO {
 
    private String username;
    private String email;
    private String password;
    private String role;
 
    public HitachiStoreUserSaveDTO(String username, String email, String password, String role) {
        this.username   = username;
        this.email      = email;
        this.password   = password;
        this.role       = role;
    }
 
    public HitachiStoreUserSaveDTO() {
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
        return "HitachiStoreUserSaveDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}