package com.example.demo.repository;

import com.example.demo.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

// 獲取所有 checkIns
@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    List<CheckIn> findAll();
}

@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Optional<CheckIn> findByCheckIn_ID(Long checkIn_ID);
}

// 刪除一個 checkIn
@Repository
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
    Optional<CheckIn> deleteById(Long checkIn_ID);
}

