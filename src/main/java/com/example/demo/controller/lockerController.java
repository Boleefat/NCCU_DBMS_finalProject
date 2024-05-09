package com.example.demo.controller;

import com.example.demo.model.Locker;
import com.example.demo.service.LockerService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locker")
public class lockerController {

    @Autowired
    private LockerService lockerService;

    // 新增一個 locker
    @PostMapping("/")
    public ResponseEntity<Locker> createLocker(@RequestBody Locker locker) {
        Locker savedLocker = lockerService.save(locker);
        return new ResponseEntity<>(savedLocker, HttpStatus.CREATED);
    }

    // 獲取所有 lockers
    @GetMapping
    public List<Locker> listAllLocker(@RequestParam(required = false, name = "Locker_ID") Long Locker_ID) {
        if (Locker_ID != null) {
            return lockerService.getLockerByLockerID(Locker_ID);
        } else {
            return lockerService.getAllLocker();
        }
    }

    // 利用Locker_ID獲取單個locker
    @GetMapping("/{Locker_ID}")
    public Optional<locker> getLockerByLockerID(@PathVariable(value = "Locker_ID") Long Locker_ID) {
        return lockerService.findLockerByLockerID(Locker_ID);
    }

    // 更新一個 locker
    @PutMapping("/{Locker_ID}")
    public locker updateLocker(@PathVariable(value = "Locker_ID") Long Locker_ID,
                               @RequestBody locker lockerDetails) {
        Optional<locker> locker = lockerService.findByLockerID(Locker_ID);
        locker existingLocker = locker.get();
        existingLocker.setSize(lockerDetails.getSize());
        existingLocker.setPrice(lockerDetails.getPrice());
        existingLocker.setStatusUsed(lockerDetails.getStatusUsed());
        existingLocker.setStatusNotUsed(lockerDetails.getStatusNotUsed());
        existingLocker.setStatusReservedButNotUsed(lockerDetails.getStatusReservedButNotUsed());
        return lockerService.save(existingLocker);
    }

    // 利用Locker_ID刪除一個 locker
    @DeleteMapping("/{Locker_ID}")
    public void deleteLocker(@PathVariable(value = "Locker_ID") Long Locker_ID) {
        lockerService.deleteLockerByLockerID(Locker_ID);
    }
}
