package com.example.hitachi_store.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "customer")


public class HitachiStoreCustomer {

    @Id
 
    @Column(name = "id_user", length = 45)
    private int id_user;
 
    @Column(name = "name", length = 45)
    private String name;
 
    @Column(name = "birthdate", length = 12)
    private Date birthdate;

    @Column(name = "birthplace", length = 45)
    private String birthplace;

    @Column(name = "created_by", length = 45)
    private String created_by;

    @Column(name = "created_at", length = 45)
    private Date created_at;
 
    @Column(name = "updated_at", length = 45)
    private Date updated_at;

    @Column(name = "updated_by", length = 45)
    private String updated_by;

    public HitachiStoreCustomer(int id_user, String name, Date birthdate, String birthplace, String created_by, Date created_at, Date updated_at, String updated_by) {
        this.id_user    = id_user;
        this.name       = name;
        this.birthdate  = birthdate;
        this.birthplace = birthplace;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
    }
 
    public HitachiStoreCustomer() {
    }

    public HitachiStoreCustomer(String name, Date birthdate, String birthplace, String created_by, Date created_at, Date updated_at, String updated_by) {
        this.name       = name;
        this.birthdate  = birthdate;
        this.birthplace = birthplace;
        this.created_by = created_by;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.updated_by = updated_by;
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

    public String getCreatedBy() {
        return created_by;
    }
 
    public void setCreatedBy(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreatedAt() {
        return created_at;
    }
 
    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }
 
    public void setUpdatedAt(Date date) {
        this.updated_at = date;
    }

    public String getUpdatedBy() {
        return updated_by ;
    }
 
    public void setUpdatedBy(String updated_by) {
        this.updated_by = updated_by;
    }
 
    @Override
    public String toString() {
        return "HitachiStoreCustomerDTO{" +
                ", id_user='" + id_user + 
                ", name='" + name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", birthplace='" + birthplace + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", updated_by='" + updated_by + 
                '}';
    }




    
}
