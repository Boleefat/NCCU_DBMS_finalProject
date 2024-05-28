package com.example.demo.service;

import com.example.demo.model.User;
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
       public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // 利用Reservation_ID 獲取單個 reservation
    public Optional<Reservation> getReservationByReservationID(int reservation_ID) {
        return reservationRepository.findById(reservation_ID);
    }

    //更新一個reservation
    public Reservation updateReservation(int reservation_ID, Reservation reservationDetails) {
        return reservationRepository.findById(reservation_ID)
            .map(reservation -> {
                reservation.setUserID(reservationDetails.getUserID());
                reservation.setLockerID(reservationDetails.getLockerID());
                reservation.setDepositTimestamp(reservationDetails.getDepositTimestamp());
                reservation.setPickUpTimestamp(reservationDetails.getPickUpTimestamp());
                reservation.setTotalRentalTime(reservationDetails.getTotalRentalTime());
                reservation.setAmount(reservationDetails.getAmount());
            })
            .orElseThrow(() -> new RuntimeException("Reservation not found with id " + reservation_ID));
    }

    //刪除一個reservation
    public void deleteReservationByReservationID(int reservation_ID) {
        reservationRepository.deleteById(reservation_ID);
    }
}