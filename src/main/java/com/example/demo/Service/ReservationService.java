package com.example.demo.Service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Repos.ReservationRepo;
import com.example.demo.domain.Reservation;


@Service
public class ReservationService {

    private final ReservationRepo reservationRepo;

    // constructor 
    public ReservationService(final ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    // get all 
    public List<Reservation> findAll() {
        return reservationRepo.findAll();
    }

    // get one reservation 
    public Reservation get(final Long id) {
        return reservationRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // create a reservation 
    public Long create(final Reservation reservation) {
        return reservationRepo.save(reservation).getId();
    }

    // update the reservation 
    public void update(final Long id, final Reservation reservation) {
        final Reservation existingReservation = reservationRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        reservationRepo.save(existingReservation);
    }

    // delete a reservation 
    public void delete(final Long id) {
        reservationRepo.deleteById(id);
    }
}
