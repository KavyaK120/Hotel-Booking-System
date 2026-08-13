package com.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}