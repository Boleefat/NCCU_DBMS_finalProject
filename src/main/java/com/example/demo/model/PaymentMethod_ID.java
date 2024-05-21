package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class PaymentMethod_ID implements Serializable {
    private Long lockerAreaID;
    private Long paymentMethodID;

    public PaymentMethod_ID() {
    }

    public PaymentMethod_ID(Long lockerAreaID, Long paymentMethodID) {
        this.lockerAreaID = lockerAreaID;
        this.paymentMethodID = paymentMethodID;
    }

    // Getters, setters, hashCode and equals methods

    public Long getLockerAreaID(){
        return lockerAreaID;
    }

    public void setLockerAreaID(Long lockerAreaID){
        this.lockerAreaID = lockerAreaID;
    }

    public Long getPaymentMethodID(){
        return paymentMethodID;
    }

    public void setPaymentMethodID(Long paymentMethodID){
        this.paymentMethodID = paymentMethodID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lockerAreaID, paymentMethodID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PaymentMethod_ID that = (PaymentMethod_ID) obj;
        return Objects.equals(lockerAreaID, that.lockerAreaID) &&
               Objects.equals(paymentMethodID, that.paymentMethodID);
    }
}
