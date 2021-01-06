package com.BookingDemo.controller;

import com.BookingDemo.repository.BookingRepository;
import com.BookingDemo.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    //To check all the environment values - not recommended over @Value annotation affects testability
    @Autowired
    private Environment env;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return bookingRepository.findByCostLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public List<HotelBooking> remove(@PathVariable long id) {
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }

    @GetMapping("/envdetails")
    public String evnDetails() {
        return env.toString();
    }
}
