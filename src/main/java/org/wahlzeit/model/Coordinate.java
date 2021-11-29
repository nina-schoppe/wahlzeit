package org.wahlzeit.model;

public interface Coordinate {
    public CartesianCoordinate asCartesianCoordinate() throws ArithmeticException;
    public double getCartesianDistance(Coordinate coordinate);
    public SphericCoordinate asSphericCoordinate() throws ArithmeticException;
    public double getCentralAngle(Coordinate coordinate);
    public boolean isEqual(Coordinate coordinate);
}
