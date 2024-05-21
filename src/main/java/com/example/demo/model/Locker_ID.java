package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Locker_ID implements Serializable {
    // 複合主鍵
    private Long lockerAreaID;
    private Long lockerID;

    public Locker_ID() {
    }

    public Locker_ID(Long lockerAreaID, Long lockerID) {
        this.lockerAreaID = lockerAreaID;
        this.lockerID = lockerID;
    }

    // Getters, setters, hashCode and equals methods

    public Long getLockerAreaID(){
        return lockerAreaID;
    }

    public void setLockerAreaID(Long lockerAreaID){
        this.lockerAreaID = lockerAreaID;
    }

    public Long getLockerID(){
        return lockerID;
    }

    public void setLockerID(Long lockerID){
        this.lockerID = lockerID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lockerAreaID, lockerID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Locker_ID that = (Locker_ID) obj;
        return Objects.equals(lockerAreaID, that.lockerAreaID) &&
               Objects.equals(lockerID, that.lockerID);
    }
}
