package com.example.demo.controller;
import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

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
    public List<Hotel> listAllHotel(@RequestParam(required = false, name = "hotel_id") int HotelID) {
        return hotelService.getAllHotel();
    }

    // 獲取單個 hotel
    @GetMapping("/{hotel_id}")
    public Optional<Hotel> getHotelByHotelID(@PathVariable("hotel_id") int HotelID) {
        return hotelService.getHotelByHotelID(HotelID);
    }

    // 更新一個 hotel
    @PutMapping("/{hotel_id}")
    public Hotel updateHotel(@PathVariable("hotel_id") int HotelID, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(HotelID, hotel);
    }

    // 刪除一個 hotel
    @DeleteMapping("/{hotel_id}")
    public void deleteHotel(@PathVariable("hotel_id") int HotelID) {
        hotelService.deleteHotelByHotelID(HotelID);
    }

}
