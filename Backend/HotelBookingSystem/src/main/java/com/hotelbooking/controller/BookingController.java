package com.hotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    // ==========================================
    // GET ALL BOOKINGS
    // ==========================================

    @GetMapping
    public List<Booking> getAllBookings() {

        return bookingService.getAllBookings();

    }


    // ==========================================
    // GET BOOKINGS BY USER
    // ==========================================

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(
            @PathVariable Integer userId) {

        return bookingService.getBookingsByUserId(userId);

    }


    // ==========================================
    // CREATE BOOKING
    // ==========================================

    @PostMapping
    public Booking createBooking(
            @RequestBody Booking booking) {

        return bookingService.createBooking(booking);

    }


    // ==========================================
    // CANCEL BOOKING
    // ==========================================

    @DeleteMapping("/{id}")
    public Booking cancelBooking(
            @PathVariable Integer id) {

        return bookingService.cancelBooking(id);

    }

}