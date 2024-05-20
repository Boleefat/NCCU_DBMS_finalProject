package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class PaymentMethod_ID implements Serializable {
    private Long LockerArea_ID;
    private Long PaymentMethod_ID;

    public PaymentMethod_ID() {}

    public PaymentMethod_ID(Long LockerArea_ID, Long PaymentMethod_ID) {
        this.LockerArea_ID = LockerArea_ID;
        this.PaymentMethod_ID = PaymentMethod_ID;
    }

    // Getters, setters, hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(LockerArea_ID, PaymentMethod_ID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        PaymentMethod_ID that = (PaymentMethod_ID) obj;
        return Objects.equals(LockerArea_ID, that.LockerArea_ID) &&
               Objects.equals(PaymentMethod_ID, that.PaymentMethod_ID);
    }
}
