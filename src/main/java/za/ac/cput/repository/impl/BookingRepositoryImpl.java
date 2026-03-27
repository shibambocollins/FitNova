package za.ac.cput.repository.impl;

import za.ac.cput.entity.Booking;
import za.ac.cput.repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* BookingRepositoryImpl.java - Implementation of BookingRepository
* Author: Collins Shibambo (230093183)
* */

public class BookingRepositoryImpl implements BookingRepository {

    private static BookingRepositoryImpl repo = null;
    private Map<String, Booking> bookingMap;

    private BookingRepositoryImpl() {
        bookingMap = new HashMap<>();
    }

    public static BookingRepositoryImpl getRepository() {
        if (repo == null) {
            repo = new BookingRepositoryImpl();
        }
        return repo;
    }

    @Override
    public Booking create(Booking booking) {
        if (booking == null || booking.getBookingId() == null) {
            return null;
        }
        bookingMap.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public Booking read(String bookingId) {
        return bookingMap.get(bookingId);
    }

    @Override
    public Booking save(Booking booking) {
        return null;
    }

    @Override
    public Booking findById(String s) {
        return null;
    }

    @Override
    public List<Booking> findAll() {
        return List.of();
    }

    @Override
    public Booking update(Booking booking) {
        if (booking == null || booking.getBookingId() == null) {
            return null;
        }

        bookingMap.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public boolean delete(String bookingId) {
        return bookingMap.remove(bookingId) != null;
    }

    @Override
    public List<Booking> getAll() {
        return new ArrayList<>(bookingMap.values());
    }
}
