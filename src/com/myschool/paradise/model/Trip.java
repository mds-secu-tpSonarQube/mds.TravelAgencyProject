package com.myschool.paradise.model;

public class Trip {

    private Long id;
    private Place departure;
    private Place destination;
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Place getDeparture() {
        return departure;
    }

    public void setDeparture(Place departure) {
        this.departure = departure;
    }

    public Place getDestination() {
        return destination;
    }

    public void setDestination(Place destination) {
        this.destination = destination;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trip trip = (Trip) o;

        if (departure != null ? !departure.equals(trip.departure) : trip.departure != null) return false;
        if (destination != null ? !destination.equals(trip.destination) : trip.destination != null) return false;
        if (id != null ? !id.equals(trip.id) : trip.id != null) return false;
        if (price != null ? !price.equals(trip.price) : trip.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

	@Override
	public String toString() {
		return "Trip [id=" + id + ", departure=" + departure + ", destination=" + destination + ", price=" + price
				+ "]";
	}
	
	public Trip() {
		super();
	}

	/**
	 * This method is only here to create Trip for testing purpose. 
	 * The fact that we define an Id locally instead of creating it with the DAO make it unusable if we work with the DB. 
	 */
	public Trip(Long id, Place departure, Place destination, Double price) {
		super();
		this.id = id;
		this.departure = departure;
		this.destination = destination;
		this.price = price;
	}
	
	
    
    
}
