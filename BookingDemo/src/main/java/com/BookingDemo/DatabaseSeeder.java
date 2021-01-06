package com.BookingDemo;

import com.BookingDemo.model.HotelBooking;
import com.BookingDemo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {
        List<HotelBooking> bookings = new ArrayList<HotelBooking>();

        bookings.add(new HotelBooking("Marriot", 200.50, 3));
        bookings.add(new HotelBooking("Ibis", 90, 4));
        bookings.add(new HotelBooking("Novotel", 140.75, 1));

        bookingRepository.saveAll(bookings);
    }
}
