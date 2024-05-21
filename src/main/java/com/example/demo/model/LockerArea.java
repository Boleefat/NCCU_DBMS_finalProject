package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "lockerarea")
public class LockerArea {
    @EmbeddedId
    private LockerArea_ID lockerAreaId;

    @Column(name = "locker_area_location", nullable = false)
    private String lockerAreaLocation;

    // 多值屬性
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
    private MrtStation mrtStation; //

    @OneToMany(mappedBy = "lockerArea") //
    private Set<Locker> lockers;

    public LockerArea(){
    }

    public LockerArea(LockerArea_ID lockerAreaId, String lockerAreaLocation , Set<String> paymentMethods, MrtStation mrtStation){
        this.lockerAreaId = lockerAreaId;
        this.lockerAreaLocation = lockerAreaLocation;
        this.paymentMethods = paymentMethods;
        this.mrtStation = mrtStation;
    }

    public LockerArea_ID getLockerAreaId() {
        return lockerAreaId;
    }

    public void setlockerAreaId(LockerArea_ID lockerAreaId) {
        this.lockerAreaId = lockerAreaId;
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