package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mrtstation")
public class MrtStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id")
    private Long stationID;

    @Column(name = "station_name", nullable = false, length = 255)
    private String stationName;

    @Column(name = "location", nullable = false, length = 255)
    private String location;

    @OneToMany(mappedBy = "mrtStation")
    private Set<LockerArea> lockerAreas;

    public MrtStation(){
    }

    public MrtStation(Long stationID, String stationName, String location){
        this.stationID = stationID;
        this.stationName = stationName;
        this.location = location;
    }

    public Long getStationID(){
        return stationID;
    }

    public void setStationID(Long stationID){
        this.stationID = stationID;
    }

    public String getStationName(){
        return stationName;
    }

    public void setStationName(String stationName){
        this.stationName = stationName;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public Set<LockerArea> getLockerAreas() {
        return lockerAreas;
    }

    public void setLockerAreas(Set<LockerArea> lockerAreas) {
        this.lockerAreas = lockerAreas;
    }
}