package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "paymentmethod")
public class paymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PaymentMethod_ID")
    private Long PaymentMethod_ID;

    @Column(name = "PaymentMethod_Name", nullable = false, length = 255)
    private String PaymentMethod_Name;

    @OneToMany(mappedBy = "paymentMethod")
    private List<possession_area_pay> possessionsB;

    public paymentMethod(){
    }

    public paymentMethod(Long PaymentMethod_ID, String PaymentMethod_Name){
        this.PaymentMethod_ID = PaymentMethod_ID;
        this.PaymentMethod_Name = PaymentMethod_Name;
    }

    public long getPaymentMethodID(){
        return PaymentMethod_ID;
    }

    public void setPaymentMethodID(Long PaymentMethod_ID){
        this.PaymentMethod_ID = PaymentMethod_ID;
    }

    public String getPaymentMethodName(){
        return PaymentMethod_Name;
    }

    public void setPaymentMethodName(String PaymentMethod_Name){
        this.PaymentMethod_Name = PaymentMethod_Name;
    }
}