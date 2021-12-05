package org.wahlzeit.model;

import java.util.Objects;

public abstract class AbstractCoordinate implements Coordinate {
    
    private final double EPSILON = 0.001;

    @Override
    public abstract SphericCoordinate asSphericCoordinate() throws ArithmeticException;

    @Override
    public abstract CartesianCoordinate asCartesianCoordinate() throws ArithmeticException;

    /**
     * 
     */
    @Override
    public boolean isEqual(Coordinate coordinate) {
        if(coordinate == null) {
            return false;
        }

        CartesianCoordinate c1 = this.asCartesianCoordinate();
        CartesianCoordinate c2 = coordinate.asCartesianCoordinate();

        boolean xEqual = Math.abs(c1.getX() - c2.getX()) <= EPSILON;
        boolean yEqual = Math.abs(c1.getY() - c2.getY()) <= EPSILON;
        boolean zEqual = Math.abs(c1.getZ() - c2.getZ()) <= EPSILON;
        return xEqual && yEqual && zEqual;
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object object) {
        if(object == null || !(object instanceof AbstractCoordinate)) {
            return false;
        }
        return this.isEqual((Coordinate) object);
    }

    /**
     * 
     */
    @Override
    public int hashCode() {
        CartesianCoordinate cartesianCoordinate = this.asCartesianCoordinate();
        return Objects.hash(cartesianCoordinate.getX(), cartesianCoordinate.getY(), cartesianCoordinate.getZ());
    }

    /**
     * 
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {
        return asCartesianCoordinate().getCartesianDistance(coordinate);
    }
        
    /**
     * 
     * @param Coordinate
     * @return double
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {
        return asSphericCoordinate().getCentralAngle(coordinate);
    }
}
