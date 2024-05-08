package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "possession_mrt_area")
public class Possession_Mrt_Area {
    @EmbeddedId
    private possessionMrtAreaKey ID;
    
    @ManyToOne
    @JoinColumn(name = "Station_ID", nullable = false)
    private MrtStation Station_ID;

    @ManyToOne
    @JoinColumn(name = "LockerArea_ID", nullable = false)
    private LockerArea LockerArea_ID;

    public Possession_Mrt_Area(){
    }

    public possessionMrtAreaKey getID() {
        return ID;
    }

    public void setID(possessionMrtAreaKey ID) {
        this.ID = ID;
    }

    public MrtStation getStationID() {
        return Station_ID;
    }

    public void setStationID(MrtStation Station_ID) {
        this.Station_ID = Station_ID;
    }

    public LockerArea getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(LockerArea LockerArea_ID){
        this.LockerArea_ID = LockerArea_ID;
    }
}

@Embeddable
class possessionMrtAreaKey implements Serializable {
    @Column(name = "Station_ID")
    private Long Station_ID;

    @Column(name = "LockerArea_ID")
    private Long LockerArea_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        possessionMrtAreaKey that = (possessionMrtAreaKey) o;
        return Objects.equals(Station_ID, that.Station_ID) &&
               Objects.equals(LockerArea_ID, that.LockerArea_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Station_ID, LockerArea_ID);
    }

    // Getters and setters
    public Long getStationID() {
        return Station_ID;
    }

    public void setStationID(Long Station_ID) {
        this.Station_ID = Station_ID;
    }

    public Long getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(Long LockerArea_ID) {
        this.LockerArea_ID = LockerArea_ID;
    }
}