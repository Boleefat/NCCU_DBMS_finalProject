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
    public List<Hotel> listAllHotel(@RequestParam(required = false, name = "hotel_id") Long HotelID) {
        return hotelService.getAllHotel();
    }

    // 獲取單個 hotel
    @GetMapping("/{hotel_id}")
    public Optional<Hotel> getHotelByHotelID(@PathVariable("hotel_id") Long HotelID) {
        return hotelService.getHotelByHotelID(HotelID);
    }

    // 更新一個 mrtStation
    @PutMapping("/{hotel_id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable("hotel_id") Long hotelID, @RequestBody Hotel hotel) {
        Optional<Hotel> updatedHotel = hotelService.updateHotel(hotelID, hotel);
        return updatedHotel.map(ResponseEntity::ok)
                                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 刪除一個 mrtStation
    @DeleteMapping("/{station_id}")
    public ResponseEntity<Void> deleteStation(@PathVariable("station_id") Long stationID) {
        if (mrtStationService.deleteStationByStationID(stationID)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
