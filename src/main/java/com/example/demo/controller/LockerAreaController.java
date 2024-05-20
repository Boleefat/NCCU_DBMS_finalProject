package com.example.demo.controller;

import com.example.demo.model.Locker;
import com.example.demo.model.LockerArea;
import com.example.demo.service.LockerAreaService;

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
public class LockerAreaController {

    @Autowired
    private LockerAreaService lockerService;

    // 新增一個 lockerArea   lockerAreaService.createLockerArea(lockerArea)
    @PostMapping("/")
    public ResponseEntity<LockerArea> createLockerArea(@RequestBody LockerArea lockerArea) {
        LockerArea createdLockerArea = lockerAreaService.createLockerArea(lockerArea);
        return new ResponseEntity<LockerArea>(createdLockerArea, HttpStatus.CREATED);
    }

    // 獲取所有 lockerArea   lockerAreaService.getAllLockerArea()
    @GetMapping
    public List<LockerArea> listAllLockerArea(@RequestParam(required = false, name = "lockerArea_id") Long LockerAreaID) {
        return lockerAreaService.getAllLockerArea();
    }

    // 利用LockerArea_ID獲取單個 lockerArea   lockerAreaService.getLockerAreaByLockerAreaID(LockerArea_ID)
    @GetMapping("/{lockerArea_id}")
    public Optional<LockerArea> getLockerAreaByLockerAreaID(@PathVariable("lockerArea_id") Long LockerAreaID) {
        return lockerAreaService.getLockerAreaByLockerAreaID(LockerAreaID);
    }

    // 更新一個 lockerArea
    @PutMapping("/{lockerArea_id}")   lockerAreaService.updateLockerArea(LockerAreaID, LockerArea)
    public LockerArea updateLockerArea(@PathVariable("lockerArea_id") Long LockerAreaID, @RequestBody LockerArea lockerArea) {
        return lockerAreaService.updateLockerArea(LockerAreaID, lockerArea);
    }

    // 利用LockerArea_ID刪除一個 locker   lockerAreaService.deleteLockerAreaByLockerAreaID(LockerArea_ID)
    @DeleteMapping("/{lockerArea_id}")
    public void deleteLockerArea(@PathVariable("lockerArea_id") Long LockerAreaID) {
        lockerAreaService.deleteLockerAreaByLockerAreaID(LockerAreaID);
    }


}
