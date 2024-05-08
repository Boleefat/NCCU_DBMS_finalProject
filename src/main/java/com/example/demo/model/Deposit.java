package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "deposit")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Locker_ID")
    private Long Locker_ID;

    @Column(name = "Deposit_ID", nullable = false, length = 255)
    private Long Deposit_ID;

    @Column(name = "Total_Price", nullable = false, length = 255)
    private int Total_Price ;

    @Column(name = "Deposit_Password", nullable = false, length = 255)
    private String Deposit_Password ;

    public Deposit(){
    }

    public Deposit(Long Locker_ID, Long Deposit_ID, int Total_Price, String Deposit_Password){
        this.Locker_ID = Locker_ID;
        this.Deposit_ID = Deposit_ID;
        this.Total_Price = Total_Price;
        this.Deposit_Password = Deposit_Password;
    }

    public long getLockerID(){
        return Locker_ID;
    }

    public void setLockerID(Long Locker_ID){
        this.Locker_ID = Locker_ID;
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