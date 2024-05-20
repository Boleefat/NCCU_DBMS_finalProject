package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "possession")
public class Possession {
    @EmbeddedId
    private Possession_ID idB;

    @ManyToOne
    @MapsId("lockerAreaID")
    @JoinColumns({
        @JoinColumn(name = "Station_ID", referencedColumnName = "stationId"),
        @JoinColumn(name = "LockerArea_ID", referencedColumnName = "lockerAreaId")
    })
    private LockerArea lockerArea;

    @ManyToOne
    @MapsId("paymentMethodId")
    @JoinColumns({
        @JoinColumn(name = "LockerArea_ID", referencedColumnName = "lockerAreaId"),
        @JoinColumn(name = "PaymentMethod_ID", referencedColumnName = "paymentMethodId")
    })
    private PaymentMethod paymentMethod;

    @Column(name = "Possession_Status", nullable = false, length = 255)
    private String possessionStatus;

    public Possession() {}

    public Possession(PossessionId id, LockerArea lockerArea, PaymentMethod paymentMethod, String possessionStatus) {
        this.id = id;
        this.lockerArea = lockerArea;
        this.paymentMethod = paymentMethod;
        this.possessionStatus = possessionStatus;
    }

    public PossessionId getId() {
        return id;
    }

    public void setId(PossessionId id) {
        this.id = id;
    }

    public LockerArea getLockerArea() {
        return lockerArea;
    }

    public void setLockerArea(LockerArea lockerArea) {
        this.lockerArea = lockerArea;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPossessionStatus() {
        return possessionStatus;
    }

    public void setPossessionStatus(String possessionStatus) {
        this.possessionStatus = possessionStatus;
    }
}
