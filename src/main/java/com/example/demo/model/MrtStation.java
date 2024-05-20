package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mrtstation")
public class MrtStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Station_ID")
    private Long Station_ID;

    @Column(name = "Station_Name", nullable = false, length = 255)
    private String Station_Name;

    @Column(name = "Location", nullable = false, length = 255)
    private String Location;

    @OneToMany(mappedBy = "MrtStation")
    private Set<LockerArea> LockerAreas;

    public MrtStation(){
    }

    public MrtStation(Long Station_ID, String Station_Name, String Location){
        this.Station_ID = Station_ID;
        this.Station_Name = Station_Name;
        this.Location = Location;
    }

    public Long getStationID(){
        return Station_ID;
    }

    public void setStationID(Long Station_ID){
        this.Station_ID = Station_ID;
    }

    public String getStationName(){
        return Station_Name;
    }

    public void setStationName(String Station_Name){
        this.Station_Name = Station_Name;
    }

    public String getLocation(){
        return Location;
    }

    public void setLocation(String Location){
        this.Location = Location;
    }

    public Set<LockerArea> getLockerAreas() {
        return LockerAreas;
    }

    public void setLockerAreas(Set<LockerArea> LockerAreas) {
        this.LockerAreas = LockerAreas;
    }
}