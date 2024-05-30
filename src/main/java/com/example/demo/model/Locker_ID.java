package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Locker_ID implements Serializable {
    // 複合主鍵
    private Long stationID;
    // private int lockerAreaID;
    private Long lockerID;

    public Locker_ID() {
    }

    public Locker_ID(Long stationID,  Long lockerID) {
        this.stationID = stationID;
        this.lockerID = lockerID;
    }

    // Getters, setters, hashCode and equals methods

    public Long getStationID(){
        return stationID;
    }

    public void setStationID(Long stationID){
        this.stationID = stationID;
    }

    public Long getLockerID(){
        return lockerID;
    }

    public void setLockerID(Long lockerID){
        this.lockerID = lockerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationID,  lockerID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Locker_ID that = (Locker_ID) obj;
        return Objects.equals(stationID, that.stationID) &&
              
               Objects.equals(lockerID, that.lockerID);
    }
}
