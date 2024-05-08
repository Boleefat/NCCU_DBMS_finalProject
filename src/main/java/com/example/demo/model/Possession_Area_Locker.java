package com.example.demo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "possession_area_locker")
public class possession_area_locker {
    @EmbeddedId
    private possessionAreaLockerKey IDC;
    
    @ManyToOne
    @JoinColumn(name = "LockerArea_ID", nullable = false)
    private LockerArea LockerArea_ID;

    @ManyToOne
    @JoinColumn(name = "Locker_ID", nullable = false)
    private locker Locker_ID;

    public possession_area_locker(){
    }

    public possessionAreaLockerKey getIDC() {
        return IDC;
    }

    public void setIDC(possessionAreaLockerKey IDC) {
        this.IDC = IDC;
    }

    public lockerArea getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(lockerArea LockerArea_ID){
        this.LockerArea_ID = LockerArea_ID;
    }

    public locker getLockerID() {
        return Locker_ID;
    }

    public void setLockerID(locker Locker_ID){
        this.Locker_ID = Locker_ID;
    }
}

@Embeddable
class possessionAreaLockerKey implements Serializable {
    @Column(name = "LockerArea_ID")
    private Long LockerArea_ID;

    @Column(name = "Locker_ID")
    private Long Locker_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        possessionAreaLockerKey that = (possessionAreaLockerKey) o;
        return Objects.equals(LockerArea_ID, that.LockerArea_ID) &&
               Objects.equals(Locker_ID, that.Locker_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LockerArea_ID, Locker_ID);
    }

    // Getters and setters
    public Long getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(Long LockerArea_ID) {
        this.LockerArea_ID = LockerArea_ID;
    }

    public Long getLockerID() {
        return Locker_ID;
    }

    public void setLockerID(Long Locker_ID) {
        this.Locker_ID = Locker_ID;
    }
}