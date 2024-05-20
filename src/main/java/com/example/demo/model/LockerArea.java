package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "lockerarea")
public class LockerArea {
    @EmbeddedId
    private LockerArea_ID IDA;

    @Column(name = "LockerArea_Location", nullable = false, length = 255)
    private String LockerArea_Location;

    @ManyToOne
    @MapsId("Station_ID")
    @JoinColumn(name = "Station_ID")
    private MrtStation MrtStation;

    @OneToMany(mappedBy = "LockerArea")
    private Set<Locker> Lockers;

    @OneToMany(mappedBy = "LockerArea")
    private Set<PaymentMethod> PaymentMethods;

    @OneToMany(mappedBy = "LockerArea")
    private Set<Possession> Possessions;

    public LockerArea(){
    }

    public LockerArea(LockerArea_ID IDA, String LockerArea_Location, MrtStation MrtStation){
        this.IDA = IDA;
        this.LockerArea_Location = LockerArea_Location;
        this.MrtStation = MrtStation;
    }

    public LockerArea_ID getIDA() {
        return IDA;
    }

    public void setIDA(LockerArea_ID IDA) {
        this.IDA = IDA;
    }

    public String getLockerAreaLocation() {
        return LockerArea_Location;
    }

    public void setLockerAreaLocation(String LockerArea_Location) {
        this.LockerArea_Location = LockerArea_Location;
    }


    public MrtStation getMrtStation() {
        return MrtStation;
    }

    public void setMrtStation(MrtStation MrtStation) {
        this.MrtStation = MrtStation;
    }

    public Set<Locker> getLockers() {
        return Lockers;
    }

    public void setLockers(Set<Locker> Lockers) {
        this.Lockers = Lockers;
    }

    public Set<PaymentMethod> getPaymentMethods() {
        return PaymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethod> PaymentMethods) {
        this.PaymentMethods = PaymentMethods;
    }

    public Set<Possession> getPossessions() {
        return Possessions;
    }

    public void setPossessions(Set<Possession> Possessions) {
        this.Possessions = Possessions;
    }
}