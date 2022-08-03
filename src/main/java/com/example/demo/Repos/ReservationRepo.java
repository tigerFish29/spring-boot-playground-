package com.example.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Reservation;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    
}
