package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "paymentmethod")
public class PaymentMethod {
    @EmbeddedId
    private PaymentMethod_ID IDC;

    @Column(name = "PaymentMethod_Name", nullable = false, length = 255)
    private String PaymentMethod_Name;

    @ManyToOne
    @MapsId("LockerArea_ID")
    @JoinColumns({
        @JoinColumn(name = "Station_ID", referencedColumnName = "Station_ID"),
        @JoinColumn(name = "LockerArea_ID", referencedColumnName = "LockerArea_ID")
    })
    private LockerArea LockerArea;

    public PaymentMethod(){
    }

    public PaymentMethod(PaymentMethod_ID IDC, LockerArea LockerArea, String PaymentMethod_Name){
        this.IDC = IDC;
        this.LockerArea = LockerArea;
        this.PaymentMethod_Name = PaymentMethod_Name;
    }

    public PaymentMethod_ID getIDC(){
        return IDC;
    }

    public LockerArea getLockerArea() {
        return LockerArea;
    }

    public void setLockerArea(LockerArea LockerArea) {
        this.LockerArea = LockerArea;
    }

    public void setIDC(PaymentMethod_ID IDC){
        this.IDC = IDC;
    }

    public String getPaymentMethodName(){
        return PaymentMethod_Name;
    }

    public void setPaymentMethodName(String PaymentMethod_Name){
        this.PaymentMethod_Name = PaymentMethod_Name;
    }
}