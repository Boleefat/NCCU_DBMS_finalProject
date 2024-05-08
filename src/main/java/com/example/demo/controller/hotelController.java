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
    private hotelService hotelService;

    // 新增一個 hotel
    @PostMapping("/")
    public ResponseEntity<hotel> createHotel(@RequestBody hotel hotel) {
        hotel savedHotel = hotelService.save(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    // 獲取所有 hotels
    @GetMapping
    public List<hotel> listAllHotel(@RequestParam(required = false, name = "Hotel_ID") Long Hotel_ID) {
        if (Hotel_ID != null) {
            return hotelService.getHotelByHotelID(Hotel_ID);
        } else {
            return hotelService.getAllHotel();
        }
    }

    // 獲取單個 hotel
    @GetMapping("/{Hotel_ID}")
    public Optional<hotel> getHotelByHotelID(@PathVariable(value = "Hotel_ID") Long Hotel_ID) {
        return hotelService.findHotelByHotelID(Hotel_ID);
    }

    // 更新一個 hotel
    @PutMapping("/{Hotel_ID}")
    public hotel updateHotel(@PathVariable(value = "Hotel_ID") Long Hotel_ID,
                               @RequestBody hotel hotelDetails) {
        Optional<hotel> hotel = hotelService.findByhotelID(Hotel_ID);
        hotel existinghotel = hotel.get();
        existinghotel.setSize(hotelDetails.getHotelName());
        existinghotel.setPrice(hotelDetails.getLatestPickUpTime());
        existinghotel.setStatusUsed(hotelDetails.getPickUpFee());
        return hotelService.save(existinghotel);
    }

    // 刪除一個 hotel
    @DeleteMapping("/{Hotel_ID}")
    public void deleteHotel(@PathVariable(value = "Hotel_ID") Long Hotel_ID) {
        hotelService.deleteHotelByHotelID(Hotel_ID);
    }

}
