package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Locker_ID implements Serializable {
    private Long LockerArea_ID;
    private Long Locker_ID;

    public Locker_ID() {
    }

    public Locker_ID(Long LockerArea_ID, Long Locker_ID) {
        this.LockerArea_ID = LockerArea_ID;
        this.Locker_ID = Locker_ID;
    }

    // Getters, setters, hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(LockerArea_ID, Locker_ID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Locker_ID that = (Locker_ID) obj;
        return Objects.equals(LockerArea_ID, that.LockerArea_ID) &&
               Objects.equals(Locker_ID, that.Locker_ID);
    }
}
