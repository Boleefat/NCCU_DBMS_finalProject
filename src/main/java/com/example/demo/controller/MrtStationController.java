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
    public List<MrtStation> listAllmrtStation(@RequestParam(required = false, name = "station_id") Long StationID) {
        return mrtStationService.getAllStation();
    }

    // 獲取單個 mrtStation
    @GetMapping("/{station_id}")
    public Optional<MrtStation> getStationByStationID(@PathVariable("station_id") Long StationID) {
        return mrtStationService.getStationByStationID(StationID);
    }

    // 更新一個 mrtStation
    @PutMapping("/{station_id}")
    public MrtStation updateMrtStation(@PathVariable("station_id") Long StationID, @RequestBody MrtStation mrtStation) {
        return mrtStationService.updateMrtStation(StationID, mrtStation)
    }

    // 刪除一個 mrtStation
    @DeleteMapping("/{station_id}")
    public void deleteStation(@PathVariable("station_id") Long StationID) {
        mrtStationService.deleteStationByStationID(StationID);
    }



}
