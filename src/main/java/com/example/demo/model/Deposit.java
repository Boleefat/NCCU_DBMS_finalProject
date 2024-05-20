package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Calendar;

@Entity
@DiscriminatorValue("deposit")
public class Deposit extends Locker{

    @Column(name = "Deposit_ID", nullable = false)
    private Long Deposit_ID;

    @Column(name = "Total_Price", nullable = false, length = 255)
    private int Total_Price;

    @Column(name = "Deposit_Password", nullable = false, length = 255)
    private String Deposit_Password;

    public Deposit(){
    }

    public Deposit(Locker_ID IDB, LockerArea LockerArea, int Size, int Price, Boolean Status_Used, Boolean Status_Not_Used, Boolean Status_Reserved_But_Not_Used, Long Reservation_ID, Calendar Deposit_Timestamp, Calendar PickUp_Timestamp, Long Delivery_ID, Long Deposit_ID, int Total_Price, String Deposit_Password){
        super(IDB, LockerArea, Size, Price, Status_Used, Status_Not_Used, Status_Reserved_But_Not_Used, Reservation_ID, Deposit_Timestamp, PickUp_Timestamp);
        this.Deposit_ID = Deposit_ID;
        this.Total_Price = Total_Price;
        this.Deposit_Password = Deposit_Password;
    }

    public Long getDepositID(){
        return Deposit_ID;
    }

    public void setDepositID(Long Deposit_ID){
        this.Deposit_ID = Deposit_ID;
    }

    public int getTotalPrice(){
        return Total_Price;
    }

    public void setTotalPrice(int Total_Price){
        this.Total_Price = Total_Price;
    }

    public String getDepositPassword(){
        return Deposit_Password;
    }

    public void setDepositPassword(String Deposit_Password){
        this.Deposit_Password = Deposit_Password;
    }
}