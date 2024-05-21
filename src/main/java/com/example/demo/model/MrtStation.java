package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mrt_station")
public class MrtStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id")
    private int stationID;

    @Column(name = "station_name", nullable = false)
    private String stationName;

    @Column(name = "mrt_station_location", nullable = false)
    private String mrtStationLocation;

    @OneToMany(mappedBy = "mrtStation") //
    private Set<LockerArea> lockerAreas;

    public MrtStation(){
    }

    public MrtStation(int stationID, String stationName, String mrtStationLocation){
        this.stationID = stationID;
        this.stationName = stationName;
        this.mrtStationLocation = mrtStationLocation;
    }

    public int getStationID(){
        return stationID;
    }

    public void setStationID(int stationID){
        this.stationID = stationID;
    }

    public String getStationName(){
        return stationName;
    }

    public void setStationName(String stationName){
        this.stationName = stationName;
    }

    public String getMrtStationLocation(){
        return mrtStationLocation;
    }

    public void setMrtStationLocation(String mrtStationLocation){
        this.mrtStationLocation = mrtStationLocation;
    }

    public Set<LockerArea> getLockerAreas() {
        return lockerAreas;
    }

    public void setLockerAreas(Set<LockerArea> lockerAreas) {
        this.lockerAreas = lockerAreas;
    }
}