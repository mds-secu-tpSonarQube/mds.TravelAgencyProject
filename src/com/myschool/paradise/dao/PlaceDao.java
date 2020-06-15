package com.myschool.paradise.dao;

import java.util.List;

import com.myschool.paradise.model.Place;

public interface PlaceDao {

    Long createPlace(Place place);

    Place findPlaceById(Long id);

    boolean updatePlace(Place place);

    boolean removePlace(Place place);

    List<Place> findAllPlaces();
}
