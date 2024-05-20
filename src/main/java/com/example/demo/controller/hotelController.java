package com.example.demo.controller;

import com.example.demo.model.hotel;
import com.example.demo.service.hotelService;

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
@RequestMapping("/api/hotel")
public class hotelController {


    @Autowired
    private HotelService hotelService;

    // 新增一個 hotel
    @PostMapping("/")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        return new ResponseEntity<Hotel>(createdHotel, HttpStatus.CREATED);
    }

    // 獲取所有 hotels
    @GetMapping
    public List<Hotel> listAllHotel(@RequestParam(required = false, name = "Hotel_ID") Long Hotel_ID) {
        return hotelService.getAllHotel();
    }

    // 獲取單個 hotel
    @GetMapping("/{Hotel_ID}")
    public Optional<Hotel> getHotelByHotelID(@PathVariable(value = "Hotel_ID") Long Hotel_ID) {
        return hotelService.getHotelByHotelID(Hotel_ID);
    }

    // 更新一個 hotel
    @PutMapping("/{Hotel_ID}")
    public hotel updateHotel(@PathVariable("Hotel_ID") Long Hotel_ID, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(Hotel_ID, hotel);
    }

    // 刪除一個 hotel
    @DeleteMapping("/{Hotel_ID}")
    public void deleteHotel(@PathVariable("Hotel_ID") Long Hotel_ID) {
        hotelService.deleteHotelByHotelID(Hotel_ID);
    }

}
