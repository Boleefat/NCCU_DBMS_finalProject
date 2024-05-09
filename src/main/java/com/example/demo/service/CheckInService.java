package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.CheckIn;
import com.example.demo.model.User;
import com.example.demo.repository.CheckInRepository;

public class CheckInService {

    private final CheckInRepository checkInRepository;

    public CheckInService(CheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
    }
    // 新增一個 checkIn
    public CheckIn createUser(CheckIn checkIn) {
        return CheckInRepository.save(checkIn);
    }

    // 獲取所有 checkIns
    public List<CheckIn> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    // 獲取單個 checkIn
    public Optional<CheckIn> getCheckInByCheckIn_Id(Long checkIn_ID) {
        return checkInRepository.findByCheckIn_ID(checkIn_ID);
    }


    // 更新一個 checkIn
 

    // 刪除一個 checkIn
    public void deleteCheckIn(Long CheckIn_ID) {
        checkInRepository.deleteById(CheckIn_ID);
    }
}
