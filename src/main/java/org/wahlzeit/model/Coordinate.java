package org.wahlzeit.model;

public interface Coordinate {
    public CartesianCoordinate asCartesianCoordinate() throws ArithmeticException, IllegalStateException;
    public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException;
    public SphericCoordinate asSphericCoordinate() throws ArithmeticException, IllegalStateException;
    public double getCentralAngle(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException;
    public boolean isEqual(Coordinate coordinate) throws IllegalStateException;
}
