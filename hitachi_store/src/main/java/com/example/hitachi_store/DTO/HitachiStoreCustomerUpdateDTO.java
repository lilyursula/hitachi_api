package com.example.hitachi_store.DTO;

import java.sql.Date;

public class HitachiStoreCustomerUpdateDTO {
    private int id_user;
    private String name;
    private Date birthdate;
    private String birthplace;
    private Date updated_at;
 
    public HitachiStoreCustomerUpdateDTO( int id_user, String name, Date birthdate, String birthplace,   Date updated_at) {
        this.id_user    = id_user;
        this.name       = name;
        this.birthdate  = birthdate;
        this.birthplace = birthplace;
        this.updated_at = updated_at;
    }
 
    public HitachiStoreCustomerUpdateDTO() {
    }
 
 
    public int getUserId() {
        return id_user;
    }
 
    public void setUserId(int id_user) {
        this.id_user = id_user;
    }

    public String getCustomerName() {
        return name;
    }
 
    public void setCustomerName(String name) {
        this.name = name;
    }
 
    public Date getBirthDate() {
        return birthdate;
    }
 
    public void setBirthDate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthPlace() {
        return birthplace;
    }
 
    public void setBirthPlace(String birthplace) {
        this.birthplace = birthplace;
    }

    
    public Date getUpdatedAt() {
        return updated_at;
    }
 
    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }


 
    @Override
    public String toString() {
        return "HitachiStoreCustomerUpdateDTO{" +
                ", id_user='" + id_user + 
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", updated_at='" + updated_at + 
                '}';
    }
}
