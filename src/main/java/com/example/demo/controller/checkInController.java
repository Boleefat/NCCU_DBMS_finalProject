package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.checkInService;
import com.example.demo.model.locker;
import com.example.demo.service.userService;
import com.example.demo.service.hotelService;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/checkIn")
public class checkInController {

    @Autowired
    private userService userService;

    @Autowired
    private hotelService hotelService;

    // 新增一個 checkIn
    @PostMapping("/")
    public ResponseEntity<checkIn> createCheckIn(@RequestBody checkIn checkIn) {
        checkIn savedCheckIn = checkInService.save(checkIn);
        return new ResponseEntity<>(savedCheckIn, HttpStatus.CREATED);
    }

    // 獲取所有 checkIns
    @GetMapping
    public List<checkIn> listAllCheckIn(@RequestParam(required = false, name = "CheckIn_ID") Long CheckIn_ID) {
        if (CheckIn_ID != null) {
            return checkInService.getCheckInByCheckInID(CheckIn_ID);
        } else {
            return checkInService.getAllCheckIn();
        }
    }

    // 獲取單個 checkIn
    @GetMapping("/{CheckIn_ID}")
    public Optional<checkIn> getCheckInByCheckInID(@PathVariable(value = "CheckIn_ID") Long CheckIn_ID) {
        return CheckInService.findCheckInByCheckInID(CheckIn_ID);
    }

    // 更新一個 checkIn
    @PutMapping("/{CheckIn_ID}")
    public checkIn updateCheckIn(@PathVariable(value = "CheckIn_ID") Long CheckIn_ID,
                               @RequestBody checkIn checkInDetails) {
        Optional<checkIn> checkIn = checkInService.findByCheckInID(CheckIn_ID);
        checkIn existingcheckIn = checkIn.get();
        existingcheckIn.setUserID(checkInDetails.getUserID());
        existingcheckIn.setHotelID(checkInDetails.getHotelID());
        return checkInService.save(existingcheckIn);
    }

    // 刪除一個 checkIn
    @DeleteMapping("/{CheckIn_ID}")
    public void deleteCheckIn(@PathVariable(value = "CheckIn_ID") Long CheckIn_ID) {
        checkInService.deleteCheckInByCheckInID(CheckIn_ID);
    }

}
