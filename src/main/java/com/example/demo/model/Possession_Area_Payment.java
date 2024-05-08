package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "possession_area_pay")
public class Possession_Area_Payment {
    @EmbeddedId
    private possessionAreaPayKey IDB;
    
    @ManyToOne
    @JoinColumn(name = "LockerArea_ID", nullable = false)
    private LockerArea LockerArea_ID;

    @ManyToOne
    @JoinColumn(name = "PaymentMethod_ID", nullable = false)
    private PaymentMethod PaymentMethod_ID;

    public Possession_Area_Payment(){
    }

    public possessionAreaPayKey getIDB() {
        return IDB;
    }

    public void setIDB(possessionAreaPayKey IDB) {
        this.IDB = IDB;
    }

    public LockerArea getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(LockerArea LockerArea_ID){
        this.LockerArea_ID = LockerArea_ID;
    }

    public PaymentMethod getPaymentMethodID() {
        return PaymentMethod_ID;
    }

    public void setPaymentMethodID(PaymentMethod PaymentMethod_ID){
        this.PaymentMethod_ID = PaymentMethod_ID;
    }
}

@Embeddable
class possessionAreaPayKey implements Serializable {
    @Column(name = "LockerArea_ID")
    private Long LockerArea_ID;

    @Column(name = "PaymentMethod_ID")
    private Long PaymentMethod_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        possessionAreaPayKey that = (possessionAreaPayKey) o;
        return Objects.equals(LockerArea_ID, that.LockerArea_ID) &&
               Objects.equals(PaymentMethod_ID, that.PaymentMethod_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LockerArea_ID, PaymentMethod_ID);
    }

    // Getters and setters
    public Long getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(Long LockerArea_ID) {
        this.LockerArea_ID = LockerArea_ID;
    }

    public Long getPaymentMethodID() {
        return PaymentMethod_ID;
    }

    public void setPaymentMethodID(Long PaymentMethod_ID) {
        this.PaymentMethod_ID = PaymentMethod_ID;
    }
}