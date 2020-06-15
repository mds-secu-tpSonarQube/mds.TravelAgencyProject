package com.myschool.paradise.dao;

import com.myschool.paradise.dao.jdbc.JdbcPlaceDao;
import com.myschool.paradise.dao.jdbc.JdbcTripDao;
import com.myschool.paradise.util.ConnectionManager;

public class DaoFactory {

    private DaoFactory() {
    }

    public static PlaceDao getPlaceDao() {
        return new JdbcPlaceDao(ConnectionManager.getConnection());
    }

    public static TripDao getTripDao() {
        return new JdbcTripDao(ConnectionManager.getConnection());
    }
}