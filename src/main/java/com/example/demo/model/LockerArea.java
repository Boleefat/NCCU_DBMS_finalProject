package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "lockerarea")
public class LockerArea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "LockerArea_ID")
    private Long LockerArea_ID;

    @Column(name = "LockerArea_Location", nullable = false, length = 255)
    private String LockerArea_Location;

    @OneToMany(mappedBy = "lockerArea")
    private List<Possession_Mrt_Area> possessions;

    public LockerArea(){
    }

    public LockerArea(Long LockerArea_ID, String LockerArea_Location){
        this.LockerArea_ID = LockerArea_ID;
        this.LockerArea_Location = LockerArea_Location;
    }

    public long getLockerAreaID(){
        return LockerArea_ID;
    }

    public void setLockerAreaID(Long LockerArea_ID){
        this.LockerArea_ID = LockerArea_ID;
    }

    public String getLockerAreaLocation(){
        return LockerArea_Location;
    }

    public void setLockerAreaLocation(String LockerArea_Location){
        this.LockerArea_Location = LockerArea_Location;
    }
}