package com.myschool.paradise.dao;

import java.util.List;

import com.myschool.paradise.model.Trip;

public interface TripDao {

    Long createTrip(Trip trip);

    Trip findTripById(Long id);

    boolean removeTrip(Trip trip);
    
    List<Trip> findAllTrips();
}
