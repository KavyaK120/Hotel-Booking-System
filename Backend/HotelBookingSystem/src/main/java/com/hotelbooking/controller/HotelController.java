package com.hotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;


    // GET all hotels
    @GetMapping
    public List<Hotel> getAllHotels() {

        return hotelService.getAllHotels();

    }


    // GET hotel by ID
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Integer id) {

        return hotelService.getHotelById(id);

    }


    // POST - Add hotel
    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {

        return hotelService.addHotel(hotel);

    }


    // PUT - Update hotel
    @PutMapping("/{id}")
    public Hotel updateHotel(
            @PathVariable Integer id,
            @RequestBody Hotel hotel) {

        return hotelService.updateHotel(id, hotel);

    }


    // DELETE - Delete hotel
    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Integer id) {

        hotelService.deleteHotel(id);

        return "Hotel deleted successfully";

    }

}