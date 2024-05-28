package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LockerArea_ID implements Serializable {
    // 複合主鍵
    private int stationID;
    @Column(name = "locker_areaid")
    private int lockerAreaID;

    public LockerArea_ID() {
    }

    public LockerArea_ID(int stationID, int lockerAreaID) {
        this.stationID = stationID;
        this.lockerAreaID = lockerAreaID;
    }

    // Getters, setters, hashCode and equals methods

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public int getLockerAreaID() {
        return lockerAreaID;
    }

    public void setLockerAreaID(int lockerAreaID) {
        this.lockerAreaID = lockerAreaID;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(stationID, lockerAreaID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LockerArea_ID that = (LockerArea_ID) obj;
        return Objects.equals(stationID, that.stationID) &&
               Objects.equals(lockerAreaID, that.lockerAreaID);
    }
}
