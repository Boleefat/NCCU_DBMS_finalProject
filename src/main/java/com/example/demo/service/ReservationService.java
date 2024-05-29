package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.MrtStation;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //新建一個 reservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //獲取所有 reservation
       public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    // 利用Reservation_ID 獲取單個 reservation
    public Optional<Reservation> getReservationByReservationID(int reservationID) {
        return reservationRepository.findById(reservationID);
    }

    //更新一個reservation
    public Optional<Reservation> updateReservation(int reservationID, Reservation newReservation) {
        return reservationRepository.findByID(reservationID).map(reservation -> {
                reservation.setUserID(newReservation.getUserID());
                reservation.setLockerID(newReservation.getLockerID());
                reservation.setDepositTimestamp(newReservation.getDepositTimestamp());
                reservation.setPickUpTimestamp(newReservation.getPickUpTimestamp());
                reservation.setTotalRentalTime(newReservation.getTotalRentalTime());
                reservation.setAmount(newReservation.getAmount());
                return reservationRepository.save(reservation);
        });
    }

    //刪除一個reservation
    public boolean deleteReservationByReservationID(int reservationID) {
        if (reservationRepository.existsById(reservationID)) {
            reservationRepository.deleteById(reservationID);
            return true;
        }
        return false;
    }
}