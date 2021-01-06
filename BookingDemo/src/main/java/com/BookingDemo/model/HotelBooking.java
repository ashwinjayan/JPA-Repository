package com.BookingDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "hotel_booking")
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private double cost;
    private int days;

    public HotelBooking(String name, double cost, int days) {
        this.name = name;
        this.cost = cost;
        this.days = days;
    }

    public HotelBooking() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public long getId() {
        return id;
    }
}
