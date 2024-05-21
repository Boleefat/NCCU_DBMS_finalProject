package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Locker_ID implements Serializable {
    // 複合主鍵
    private int stationID;
    private int lockerAreaID;
    private int lockerID;

    public Locker_ID() {
    }

    public Locker_ID(int stationID, int lockerAreaID, int lockerID) {
        this.stationID = stationID;
        this.lockerAreaID = lockerAreaID;
        this.lockerID = lockerID;
    }

    // Getters, setters, hashCode and equals methods

    public int getStationID(){
        return stationID;
    }

    public void setStationID(int stationID){
        this.stationID = stationID;
    }

    public int getLockerAreaID(){
        return lockerAreaID;
    }

    public void setLockerAreaID(int lockerAreaID){
        this.lockerAreaID = lockerAreaID;
    }

    public int getLockerID(){
        return lockerID;
    }

    public void setLockerID(int lockerID){
        this.lockerID = lockerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationID, lockerAreaID, lockerID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Locker_ID that = (Locker_ID) obj;
        return Objects.equals(stationID, that.stationID) &&
               Objects.equals(lockerAreaID, that.lockerAreaID) &&
               Objects.equals(lockerID, that.lockerID);
    }
}
