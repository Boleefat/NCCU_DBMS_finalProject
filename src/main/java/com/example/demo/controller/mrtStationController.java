package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.mrtStation;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/mrtStation")
public class MrtStationController {

    @Autowired
    private MrtStationService mrtStationService;

    // 新增一個 mrtStation
    @PostMapping("/")
    public ResponseEntity<MrtStation> createMrtStation(@RequestBody MrtStation mrtStation) {
        MrtStation createdMrtStation = mrtStationService.createMrtStation(mrtStation);
        return new ResponseEntity<MrtStation>(createdMrtStation, HttpStatus.CREATED);
    }

    // 獲取所有 mrtStation
    @GetMapping
    public List<MrtStation> listAllmrtStation(@RequestParam(required = false, name = "Station_ID") Long Station_ID) {
        return mrtStationService.getAllStation();
    }

    // 獲取單個 mrtStation
    @GetMapping("/{Station_ID}")
    public Optional<MrtStation> getStationByStationID(@PathVariable("Station_ID") Long Station_ID) {
        return mrtStationService.getStationByStationID(Station_ID);
    }

    // 更新一個 mrtStation
    @PutMapping("/{Station_ID}")
    public MrtStation updateMrtStation(@PathVariable("Station_ID") Long Station_ID, @RequestBody MrtStation mrtStation) {
        return mrtStationService.updateMrtStation(Station_ID, mrtStation)
    }

    // 刪除一個 mrtStation
    @DeleteMapping("/{Station_ID}")
    public void deleteStation(@PathVariable("Station_ID") Long Station_ID) {
        mrtStationService.deleteStationByStationID(Station_ID);
    }



}
