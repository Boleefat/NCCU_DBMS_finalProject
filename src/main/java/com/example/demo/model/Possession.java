package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "possession")
public class Possession {
    @EmbeddedId
    private Possession_ID IDB;

    @ManyToOne
    @MapsId("lockerAreaID")
    @JoinColumns({
        @JoinColumn(name = "station_id", referencedColumnName = "station_id"),
        @JoinColumn(name = "locker_area_id", referencedColumnName = "locker_areaid")
    })
    private LockerArea lockerArea;

    @ManyToOne
    @MapsId("paymentMethodID")
    @JoinColumns({
        @JoinColumn(name = "locker_area_id", referencedColumnName = "locker_areaid"),
        @JoinColumn(name = "payment_method_id", referencedColumnName = "paymentMethodID")
    })
    private PaymentMethod paymentMethod;

    public Possession() {
    }

    public Possession(Possession_ID IDB, LockerArea lockerArea, PaymentMethod paymentMethod) {
        this.IDB = IDB;
        this.lockerArea = lockerArea;
        this.paymentMethod = paymentMethod;
    }

    public Possession_ID getIDB() {
        return IDB;
    }

    public void setIDB(Possession_ID IDB) {
        this.IDB = IDB;
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
}