package com.myschool.paradise.dao.jdbc;

import com.myschool.paradise.dao.DaoFactory;
import com.myschool.paradise.dao.TripDao;
import com.myschool.paradise.model.Place;
import com.myschool.paradise.model.Trip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTripDao extends JdbcDao implements TripDao {


    public JdbcTripDao(Connection connection) {
        super(connection);
    }

    @Override
    public Long createTrip(Trip trip) {
        try (PreparedStatement statement = getConnection().prepareStatement("INSERT INTO " +
                "trips(departure, destination, price) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, trip.getDeparture().getId());
            statement.setLong(2, trip.getDestination().getId());
            statement.setDouble(3, trip.getPrice());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long id = resultSet.getLong(1);
            getConnection().commit();
            return id;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to insert this trip: " + trip, e);
        }
    }

    @Override
    public Trip findTripById(Long id) {
        try (PreparedStatement statement = getConnection().prepareStatement("SELECT " +
                "trip.id, departure.id, departure.name, destination.id, destination.name, trip.price " +
                "FROM trips trip " +
                "JOIN places departure ON departure.id = trip.departure " +
                "JOIN places destination ON destination.id = trip.destination " +
                "WHERE trip.id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Trip trip = new Trip();
                trip.setId(resultSet.getLong(1));

                Place departure = new Place();
                departure.setId(resultSet.getLong(2));
                departure.setName(resultSet.getString(3));
                trip.setDeparture(departure);

                Place destination = new Place();
                destination.setId(resultSet.getLong(4));
                destination.setName(resultSet.getString(5));
                trip.setDestination(destination);

                trip.setPrice(resultSet.getDouble(6));
                return trip;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to find trip with id: " + id, e);
        }
    }

    @Override
    public boolean removeTrip(Trip trip) {
        try (PreparedStatement statement = getConnection().prepareStatement("DELETE FROM trips WHERE id = ?")) {
            statement.setLong(1, trip.getId());
            boolean result = statement.executeUpdate() > 0;
            getConnection().commit();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to delete this trip: " + trip, e);
        }
    }

	@Override
	public List<Trip> findAllTrips() {
        try (PreparedStatement statement = getConnection().prepareStatement("SELECT id, departure, destination, price FROM trips")) {
            List<Trip> trips = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                trips.add(toTrip(resultSet));
            }
            return trips;
        } catch (SQLException e) {
            throw new RuntimeException("Unable to find all places");
        }
    }

    private Trip toTrip(ResultSet resultSet) throws SQLException {
    	Place placeDeparture = DaoFactory.getPlaceDao().findPlaceById(resultSet.getLong("departure"));
    	Place placeDestination = DaoFactory.getPlaceDao().findPlaceById(resultSet.getLong("destination"));
    	
    	Trip trip = new Trip();
    	trip.setId(resultSet.getLong("id"));
    	trip.setDeparture(placeDeparture);
    	trip.setDestination(placeDestination);
    	trip.setPrice(resultSet.getDouble("price"));
    	
    	return trip;
    }
}
