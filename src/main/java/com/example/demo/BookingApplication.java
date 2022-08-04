package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.Repos.ReservationRepo;
import com.example.demo.Repos.UserRepo;
import com.example.demo.domain.Reservation;
import com.example.demo.domain.User;

import com.example.demo.model.BookingType;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;


@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	
	}

	@Bean 
	public CommandLineRunner runner(ReservationRepo reservationRepo, UserRepo userRepository) {
        return args -> {
			User user = userRepository.save(new User());
			Date date = new Date();
			LocalDate localdate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Reservation reservation = Reservation.builder()
			    .reservationDate(localdate)
				
				.startTime(LocalTime.of(12, 30))
				.endTime(LocalTime.of(13, 40))
				.user(user)
				.bookingType(BookingType.POOL)
				.build();
			System.out.println("Running the command line runner debug ...............");

				reservationRepo.save(reservation);
		};
	}
	
	

}
