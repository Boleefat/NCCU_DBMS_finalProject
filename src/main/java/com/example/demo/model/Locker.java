package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "locker")
public class Locker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Locker_ID")
    private Long Locker_ID;

    @Column(name = "Size", nullable = false, length = 255)
    private int Size;

    @Column(name = "Price", nullable = false, length = 255)
    private int Price;

    @Column(name = "Status_Used", nullable = true, length = 255)
    private Boolean Status_Used;

    @Column(name = "Status_Not_Used", nullable = true, length = 255)
    private Boolean Status_Not_Used;

    @Column(name = "Status_Reserved_But_Not_Used", nullable = true, length = 255)
    private Boolean Status_Reserved_But_Not_Used;

    @OneToMany(mappedBy = "locker")
    private List<Possession_Area_Locker> possessionsC;

    public Locker(){
    }

    public Locker(Long Locker_ID, int Size, int Price, Boolean Status_Used, Boolean Status_Not_Used, Boolean Status_Reserved_But_Not_Used){
        this.Locker_ID = Locker_ID;
        this.Size = Size;
        this.Price = Price;
        this.Status_Used = Status_Used;
        this.Status_Not_Used = Status_Not_Used;
        this.Status_Reserved_But_Not_Used = Status_Reserved_But_Not_Used;
    }

    public long getLockerID(){
        return Locker_ID;
    }

    public void setLockerID(Long Locker_ID){
        this.Locker_ID = Locker_ID;
    }

    public int getSize(){
        return Size;
    }

    public void setSize(int Size){
        this.Size = Size;
    }

    public int getPrice(){
        return Price;
    }

    public void setPrice(int Price){
        this.Price = Price;
    }

    public Boolean getStatusUsed(){
        return Status_Used;
    }

    public void setStatusUsed(Boolean Status_Used){
        this.Status_Used = Status_Used;
    }

    public Boolean getStatusNotUsed(){
        return Status_Not_Used;
    }

    public void setStatusNotUsed(Boolean Status_Not_Used){
        this.Status_Not_Used = Status_Not_Used;
    }

    public Boolean getStatusReservedButNotUsed(){
        return Status_Reserved_But_Not_Used;
    }

    public void setStatusReservedButNotUsed(Boolean Status_Reserved_But_Not_Used){
        this.Status_Reserved_But_Not_Used = Status_Reserved_But_Not_Used;
    }
}