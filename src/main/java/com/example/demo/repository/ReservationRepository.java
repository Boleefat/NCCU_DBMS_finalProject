package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.User;
// import com.example.demo.model.Reservation;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
<<<<<<< HEAD
    Optional<Reservation> findByUser_Id(Long userId);
    Optional<Reservation> findByReservation_Id(Long reservationId);
=======
    List<Reservation> findByUser_ID(Long user_ID);
    Optional<Reservation> findById(Long reservationID);
>>>>>>> daaf4d25f8b1895ca1c2e772b55e6bc2462a58f3
}
