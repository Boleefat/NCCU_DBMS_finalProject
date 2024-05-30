package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Locker;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Calendar;
import java.time.Duration;
import java.time.Instant;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // 新建一個 reservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // 獲取所有 reservation
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    // 利用Reservation_ID 獲取單個 reservation
    public Optional<Reservation> getReservationByReservationID(Long reservationID) {
        return reservationRepository.findById(reservationID);
    }

    // 更新一個reservation
    public Optional<Reservation> updateReservation(Long reservationID, Reservation newReservation) {
        return reservationRepository.findById(reservationID).map(reservation -> {
            reservation.setUser(newReservation.getUser());
            reservation.setLocker(newReservation.getLocker());
            reservation.setDepositTimestamp(newReservation.getDepositTimestamp());
            reservation.setPickUpTimestamp(newReservation.getPickUpTimestamp());
            // 不需要設置 totalRentalTime，因為它是根據 timestamp 計算的
            return reservationRepository.save(reservation);
        });
    }

    // 刪除一個reservation
    public boolean deleteReservationByReservationID(Long reservationID) {
        if (reservationRepository.existsById(reservationID)) {
            reservationRepository.deleteById(reservationID);
            return true;
        }
        return false;
    }

    // 計算總租賃時間
    public Duration calculateTotalRentalTime(Reservation reservation) {
        Calendar depositTimestamp = reservation.getDepositTimestamp();
        Calendar pickUpTimestamp = reservation.getPickUpTimestamp();

        if (pickUpTimestamp != null && depositTimestamp != null) {
            Instant depositInstant = depositTimestamp.toInstant();
            Instant pickupInstant = pickUpTimestamp.toInstant();
            return Duration.between(depositInstant, pickupInstant);
        } else {
            return Duration.ZERO;
        }
    }

    public Long calculateTotalRentalHours(Reservation reservation) {
        return calculateTotalRentalTime(reservation).toHours();
    }

    public Long calculateTotalRentalMinutes(Reservation reservation) {
        return calculateTotalRentalTime(reservation).toMinutes();
    }

    public Long calculateTotalRentalSeconds(Reservation reservation) {
        return calculateTotalRentalTime(reservation).getSeconds();
    }
}
