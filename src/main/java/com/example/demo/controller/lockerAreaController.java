package com.example.demo.controller;

import com.example.demo.model.locker;
import com.example.demo.model.lockerArea;
import com.example.demo.service.lockerAreaService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/lockerArea")
public class lockerAreaController {

    @Autowired
    private lockerAreaService lockerService;

    // 新增一個 lockerArea
    @PostMapping("/")
    public ResponseEntity<lockerArea> createLockerArea(@RequestBody lockerArea lockerArea) {
        lockerArea savedLockerArea = lockerAreaService.save(lockerArea);
        return new ResponseEntity<>(savedLockerArea, HttpStatus.CREATED);
    }

    // 獲取所有 lockerArea
    @GetMapping
    public List<lockerArea> listAllLockerArea(@RequestParam(required = false, name = "LockerArea_ID") Long LockerArea_ID) {
        if (LockerArea_ID != null) {
            return lockerAreaService.getLockerAreaByLockerAreaID(LockerArea_ID);
        } else {
            return lockerAreaService.getAllLocker();
        }
    }

    // 利用LockerArea_ID獲取單個 lockerArea
    @GetMapping("/{LockerArea_ID}")
    public Optional<lockerArea> getLockerAreaByLockerAreaID(@PathVariable(value = "LockerArea_ID") Long LockerArea_ID) {
        return lockerAreaService.findLockerAreaByLockerAreaID(LockerArea_ID);
    }

    // 更新一個 lockerArea
    @PutMapping("/{LockerArea_ID}")
    public locker updateLockerArea(@PathVariable(value = "LockerArea_ID") Long LockerArea_ID,
                               @RequestBody lockerArea lockerAreaDetails) {
        Optional<lockerArea> lockerArea = lockerAreaService.findByLockerID(LockerArea_ID);
        locker existingLockerArea = lockerArea.get();
        existingLockerArea.setLovkerAreaLocation(lockerAreaDetails.getLockerAreaLocation());
        return lockerAreaService.save(existingLockerArea);
    }

    // 利用LockerArea_ID刪除一個 locker
    @DeleteMapping("/{LockerArea_ID}")
    public void deleteLockerArea(@PathVariable(value = "LockerArea_ID") Long LockerArea_ID) {
        lockerAreaService.deleteLockerAreaByID(LockerArea_ID);
    }


}
