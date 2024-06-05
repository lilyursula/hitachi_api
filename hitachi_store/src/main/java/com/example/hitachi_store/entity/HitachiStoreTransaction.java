package com.example.hitachi_store.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "transaction")

public class HitachiStoreTransaction {
    
    @Id
    @Column(name = "id", length = 12)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    @Column(name = "customer", length = 45)
    private int customer;
 
    @Column(name = "net_amount_paid", length = 11)
    private int net_amount_paid;
 
    @Column(name = "total_amount_paid", length = 11)
    private int total_amount_paid;

    @Column(name = "total_tax_paid", length = 11)
    private int total_tax_paid;

    @Column(name = "transaction_time", length = 11)
    private Date transaction_time;

    @Column(name = "payment_status", length = 11)
    private String payment_status;

    @Column(name = "payment_method", length = 11)
    private String payment_method;

    @Column(name = "product_id", length = 11)
    private int product_id;

    @Column(name = "staff_id", length = 11)
    private int staff_id;

    public HitachiStoreTransaction(int id, int customer, int net_amount_paid, int total_amount_paid, int total_tax_paid, Date transaction_time, 
                                        String payment_status, String payment_method, int product_id, int staff_id) {
                                            
        this.id                 = id;
        this.customer           = customer;
        this.net_amount_paid    = net_amount_paid;
        this.total_amount_paid  = total_amount_paid;
        this.total_tax_paid     = total_tax_paid;
        this.transaction_time   = transaction_time;
        this.payment_status     = payment_status;
        this.payment_method     = payment_method;
        this.product_id         = product_id;
        this.staff_id           = staff_id;
    }
 
    public HitachiStoreTransaction() {
    }

    public HitachiStoreTransaction(int customer, int net_amount_paid, int total_amount_paid, int total_tax_paid, Date transaction_time, 
                                    String payment_status, String payment_method, int product_id, int staff_id) {
        
        this.customer           = customer;
        this.net_amount_paid    = net_amount_paid;
        this.total_amount_paid  = total_amount_paid;
        this.total_tax_paid     = total_tax_paid;
        this.transaction_time   = transaction_time;
        this.payment_status     = payment_status;
        this.payment_method     = payment_method;
        this.product_id         = product_id;
        this.staff_id           = staff_id;
        }
 
    public int getTransactionId() {
        return id;
    }
 
    public void setTransactionId(int id) {
        this.id = id;
    }
 
    public int getCustomer() {
        return customer;
    }
 
    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getNetAmountPaid() {
        return net_amount_paid;
    }
 
    public void setNetAmountPaid(int net_amount_paid) {
        this.net_amount_paid = net_amount_paid;
    }

    public int getTotalAmountPaid() {
        return total_amount_paid;
    }
 
    public void setTotalAmountPaid(int total_amount_paid) {
        this.total_amount_paid = total_amount_paid;
    }

    public int getTotalTaxPaid() {
        return total_tax_paid;
    }
 
    public void setTotalTaxPaid(int total_tax_paid) {
        this.total_tax_paid = total_tax_paid;
    }
 
    public Date getTransactionTime() {
        return transaction_time;
    }
 
    public void setTransactionTime(Date transaction_time) {
        this.transaction_time = transaction_time;
    }

    public String getPaymentStatus() {
        return payment_status;
    }
 
    public void setPaymentStatus(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getPaymentMethod() {
        return payment_method;
    }
 
    public void setPaymentMethod(String payment_method) {
        this.payment_method = payment_method;
    }
 
    public int getProductId() {
        return product_id;
    }
 
    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getStaffId() {
        return staff_id;
    }
 
    public void setStaffId(int staff_id) {
        this.staff_id = staff_id;
    }
 
    @Override
    public String toString() {
        return "HitachiStoreTransctionDTO{" +
                "id=" + id +
                ", customer='" + customer + '\'' +
                ", net_amount_paid='" + net_amount_paid + '\'' +
                ", total_amount_paid='" + total_amount_paid + '\'' +
                ", total_tax_paid='" + total_tax_paid + '\'' +
                ", transaction_time='" + transaction_time + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", payment_method='" + payment_method + '\'' +
                ", product_id='" + product_id + '\'' +
                ", staff_id='" + staff_id + 
                '}';      
    }
}
