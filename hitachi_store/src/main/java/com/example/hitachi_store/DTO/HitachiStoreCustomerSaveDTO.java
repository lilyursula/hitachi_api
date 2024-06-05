package com.example.hitachi_store.DTO;

import java.sql.Date;

public class HitachiStoreCustomerSaveDTO {
    private int id_user;
    private String created_by;
    private Date created_at;
 
    public HitachiStoreCustomerSaveDTO(int id_user, String created_by, Date created_at) {
        this.id_user    = id_user;
        this.created_by = created_by;
        this.created_at = created_at;
    }
 
    public HitachiStoreCustomerSaveDTO() {
    }
 
 
    public int getUserId() {
        return id_user;
    }
 
    public void setUserId(int id_user) {
        this.id_user = id_user;
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

    @Override
    public String toString() {
        return "HitachiStoreCustomerSaveDTO{" +
                ", id_user='" + id_user + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_at='" + created_at + 
                '}';
    }
    
}
