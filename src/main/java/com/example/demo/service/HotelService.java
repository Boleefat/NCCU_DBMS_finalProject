package com.example.demo.service;

import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }

    public Optional<Hotel> getHotelById(Long hotelID) {
        return hotelRepository.findById(hotelID);
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public void deleteHotel(Long hotelID) {
        hotelRepository.deleteById(hotelID);
    }
}