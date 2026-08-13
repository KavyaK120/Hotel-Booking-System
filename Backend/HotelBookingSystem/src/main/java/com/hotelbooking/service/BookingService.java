package com.hotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Booking;
import com.hotelbooking.repository.BookingRepository;

import jakarta.persistence.EntityManager;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private EntityManager entityManager;


    // ==========================================
    // CREATE BOOKING
    // ==========================================

    public Booking createBooking(Booking booking) {

        booking.setBookingStatus("CONFIRMED");

        Booking savedBooking =
                bookingRepository.save(booking);

        return savedBooking;
    }


    // ==========================================
    // GET ALL BOOKINGS
    // ==========================================

    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();
    }


    // ==========================================
    // GET BOOKINGS BY USER
    // ==========================================

    public List<Booking> getBookingsByUserId(Integer userId) {

        return bookingRepository.findByUserId(userId);
    }


    // ==========================================
    // CANCEL BOOKING
    // ==========================================

    public Booking cancelBooking(Integer bookingId) {

        Booking booking =
                bookingRepository.findById(bookingId)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Booking not found"
                        )
                );

        booking.setBookingStatus("CANCELLED");

        return bookingRepository.save(booking);
    }

}