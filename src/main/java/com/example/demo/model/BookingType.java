package com.example.demo.model;

// contains each type of item to be booked 

public enum BookingType {
    POOL("POOL"), SAUNA("SAUNA"), GYM("GYM"), BIKE("BIKE");

    private final String name;

    private BookingType(String value) {
        name = value;
    }

    @Override
    public String toString() {
        return name;
    }
}
    

