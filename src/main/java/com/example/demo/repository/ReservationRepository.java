package com.example.demo.repository;

import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // 根据用户ID查找预约
    List<Reservation> findByUser_UserId(Long userId);

    // 根据锁定器ID查找预约
    List<Reservation> findByLocker_LockerId(Long lockerId);

    // 根据酒店ID查找预约
    List<Reservation> findByHotel_HotelId(Long hotelId);

    // 根据交付ID查找预约
    Optional<Reservation> findByDeliveryID(Long deliveryId);
}
