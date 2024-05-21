package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "lockerarea")
public class LockerArea {
    @EmbeddedId
    private LockerArea_ID IDA;

    @Column(name = "locker_area_location", nullable = false, length = 255)
    private String lockerAreaLocation;

    @ElementCollection
    @CollectionTable(name = "locker_area_payment_methods", joinColumns = {
        @JoinColumn(name = "station_id", referencedColumnName = "stationID"),
        @JoinColumn(name = "locker_area_id", referencedColumnName = "lockerAreaID")
    })
    @Column(name = "payment_method")
    private Set<String> paymentMethods;

    @ManyToOne
    @MapsId("stationID")
    @JoinColumn(name = "station_id")
    private MrtStation mrtStation;

    @OneToMany(mappedBy = "lockerArea")
    private Set<Locker> lockers;

    public LockerArea(){
    }

    public LockerArea(LockerArea_ID IDA, String lockerAreaLocation, MrtStation mrtStation, Set<String> paymentMethods){
        this.IDA = IDA;
        this.lockerAreaLocation = lockerAreaLocation;
        this.mrtStation = mrtStation;
        this.paymentMethods = paymentMethods;
    }

    public LockerArea_ID getIDA() {
        return IDA;
    }

    public void setIDA(LockerArea_ID IDA) {
        this.IDA = IDA;
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
}