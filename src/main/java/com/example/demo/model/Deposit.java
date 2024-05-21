package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Calendar;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("deposit")
public class Deposit extends Locker{

    @Column(name = "deposit_id", nullable = false)
    private Long depositID;

    @Column(name = "deposit_password", nullable = false, length = 255)
    private String depositPassword;

    public Deposit(){
    }

    public Deposit(Locker_ID IDB, LockerArea lockerArea, int size, int price, Boolean statusUsed, Boolean statusNotUsed, Boolean statusReservedButNotUsed, Long reservationID, Calendar depositTimestamp, Calendar pickUpTimestamp, Long depositID, String depositPassword){
        super(IDB, lockerArea, size, price, statusUsed, statusNotUsed, statusReservedButNotUsed, reservationID, depositTimestamp, pickUpTimestamp);
        this.depositID = depositID;
        this.depositPassword = depositPassword;
    }

    public Long getDepositID(){
        return depositID;
    }

    public void setDepositID(Long depositID){
        this.depositID = depositID;
    }

    public String getDepositPassword(){
        return depositPassword;
    }

    public void setDepositPassword(String depositPassword){
        this.depositPassword = depositPassword;
    }

    @Transient
    public BigDecimal getTotalPrice() {
        if (getPrice() > 0 && getTotalRentalTime().toHours() > 0) {
            return BigDecimal.valueOf(getPrice()).multiply(BigDecimal.valueOf(getTotalRentalTime().toHours()));
        } else {
            return BigDecimal.ZERO;
        }
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        // This setter might not be necessary if totalPrice is always calculated dynamically.
    }
}