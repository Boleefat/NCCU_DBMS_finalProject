package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "lockerarea")
public class LockerArea {
    @EmbeddedId
    private LockerArea_ID idA;

    @Column(name = "lockerarea_location", nullable = false, length = 255)
    private String lockerAreaLocation;

    @ManyToOne
    @MapsId("station_id")
    @JoinColumn(name = "station_id")
    private MrtStation mrtStation;

    @OneToMany(mappedBy = "LockerArea")
    private Set<Locker> lockers;

    @OneToMany(mappedBy = "LockerArea")
    private Set<PaymentMethod> paymentMethods;

    @OneToMany(mappedBy = "LockerArea")
    private Set<Possession> possessions;

    public LockerArea(){
    }

    public LockerArea(LockerArea_ID idA, String lockerAreaLocation, MrtStation mrtStation){
        this.idA = idA;
        this.lockerAreaLocation = lockerAreaLocation;
        this.mrtStation = mrtStation;
    }

    public LockerArea_ID getIdA() {
        return idA;
    }

    public void setIdA(LockerArea_ID idA) {
        this.idA = idA;
    }

    public String getLockerAreaLocation() {
        return lockerAreaLocation;
    }

    public void setLockerAreaLocation(String lockerAreaLocation) {
        this.lockerAreaLocation = lockerAreaLocation;
    }


    public MrtStation getMrtStation() {
        return mrtStation;
    }

    public void setMrtStation(MrtStation mrtStation) {
        this.mrtStation = mrtStation;
    }

    public Set<Locker> getLockers() {
        return lockers;
    }

    public void setLockers(Set<Locker> lockers) {
        this.lockers = lockers;
    }

    public Set<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Set<Possession> getPossessions() {
        return possessions;
    }

    public void setPossessions(Set<Possession> possessions) {
        this.possessions = possessions;
    }
}