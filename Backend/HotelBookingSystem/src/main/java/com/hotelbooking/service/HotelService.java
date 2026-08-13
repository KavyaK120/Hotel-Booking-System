package com.hotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    // Get all hotels
    public List<Hotel> getAllHotels() {

        return hotelRepository.findAll();

    }


    // Get hotel by ID
    public Hotel getHotelById(Integer id) {

        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

    }


    // Add hotel
    public Hotel addHotel(Hotel hotel) {

        return hotelRepository.save(hotel);

    }


    // Update hotel
    public Hotel updateHotel(Integer id, Hotel hotel) {

        Hotel existingHotel = hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setDescription(hotel.getDescription());
        existingHotel.setPrice(hotel.getPrice());
        existingHotel.setRating(hotel.getRating());
        existingHotel.setImage(hotel.getImage());

        return hotelRepository.save(existingHotel);

    }


    // Delete hotel
    public void deleteHotel(Integer id) {

        hotelRepository.deleteById(id);

    }

}