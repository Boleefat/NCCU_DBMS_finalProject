package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class LockerArea_ID implements Serializable {
    // 複合主鍵
    private Long stationID;
    @Column(name = "locker_areaid")
    private Long lockerAreaID;

    public LockerArea_ID() {
    }

    public LockerArea_ID(Long stationID, Long lockerAreaID) {
        this.stationID = stationID;
        this.lockerAreaID = lockerAreaID;
    }

    // Getters, setters, hashCode and equals methods

    public Long getStationID() {
        return stationID;
    }

    public void setStationID(Long stationID) {
        this.stationID = stationID;
    }

    public Long getLockerAreaID() {
        return lockerAreaID;
    }

    public void setLockerAreaID(Long lockerAreaID) {
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
