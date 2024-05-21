package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "paymentmethod")
public class PaymentMethod {
    @EmbeddedId
    private PaymentMethod_ID IDC;

    @Column(name = "payment_method_name", nullable = false, length = 255)
    private String paymentMethodName;

    @OneToMany(mappedBy = "paymentMethod")
    private Set<Possession> possessions;

    public PaymentMethod(){
    }

    public PaymentMethod(PaymentMethod_ID IDC, String paymentMethodName){
        this.IDC = IDC;
        this.paymentMethodName = paymentMethodName;
    }

    public PaymentMethod_ID getIDC(){
        return IDC;
    }

    public void setIDC(PaymentMethod_ID IDC){
        this.IDC = IDC;
    }

    public String getPaymentMethodName(){
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName){
        this.paymentMethodName = paymentMethodName;
    }
}