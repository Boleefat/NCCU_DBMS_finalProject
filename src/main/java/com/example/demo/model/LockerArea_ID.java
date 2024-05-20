package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class LockerArea_ID implements Serializable {
    private Long Station_ID;
    private Long LockerArea_ID;

    public LockerArea_ID() {}

    public LockerArea_ID(Long Station_ID, Long LockerArea_ID) {
        this.Station_ID = Station_ID;
        this.LockerArea_ID = LockerArea_ID;
    }

    // Getters, setters, hashCode and equals methods
    @Override
    public int hashCode() {
        return Objects.hash(Station_ID, LockerArea_ID);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LockerArea_ID that = (LockerArea_ID) obj;
        return Objects.equals(Station_ID, that.Station_ID) &&
               Objects.equals(LockerArea_ID, that.LockerArea_ID);
    }
}
