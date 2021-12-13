package org.wahlzeit.model;

public class Location {

    /**
     * The coordinate of the location.
     */
    protected Coordinate coordinate;

    /**
     * 
     * @methodtype constructor
     */
    public Location(Coordinate coordinate) throws IllegalArgumentException {
        if(coordinate == null) {
            throw new IllegalArgumentException("coordinate can not be set to null");
        }
        this.coordinate = coordinate;
        assertClassInvariants();
    }

    /**
     * 
     * @methodtype get
     */
    public Coordinate getCoordinate() {
        assertClassInvariants();
        return coordinate;
    }

    /**
     * 
     * returns true if locations contain equal coordinates
     */
    @Override
    public boolean equals(Object object) {
        assertClassInvariants();
        if(object == null || object.getClass() != Location.class) {
            return false;
        }
        Location location = (Location) object;
        return this.coordinate.equals(location.coordinate);
    }

    protected void assertClassInvariants() throws IllegalStateException {
        if(coordinate == null) {
            throw new IllegalStateException("coordinate can not be null");
        }
    }
}
