package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Possession_ID implements Serializable {
    private Long lockerAreaID;
    private Long possessionID;

    public Possession_ID() {
    }

    public Possession_ID(Long lockerAreaID, Long possessionID) {
        this.lockerAreaID = lockerAreaID;
        this.possessionID = possessionID;
    }

    public Long getLockerAreaID() {
        return lockerAreaID;
    }

    public void setLockerAreaID(Long lockerAreaID) {
        this.lockerAreaID = lockerAreaID;
    }

    public Long getPossessionID() {
        return possessionID;
    }

    public void setPossessionID(Long possessionID) {
        this.possessionID = possessionID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Possession_ID that = (Possession_ID) o;
        return Objects.equals(lockerAreaID, that.lockerAreaID) &&
               Objects.equals(possessionID, that.possessionID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lockerAreaID, possessionID);
    }
}
