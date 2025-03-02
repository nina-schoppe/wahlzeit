package org.wahlzeit.model;

import java.util.Objects;

public abstract class AbstractCoordinate implements Coordinate {
    
    protected static final double EPSILON = 0.001;

    @Override
    public abstract SphericCoordinate asSphericCoordinate() throws ArithmeticException, IllegalStateException;

    @Override
    public abstract CartesianCoordinate asCartesianCoordinate() throws ArithmeticException, IllegalStateException;

    protected void assertClassInvariants() throws IllegalStateException {
        doAssertClassInvariants();
    }

    abstract void doAssertClassInvariants() throws IllegalStateException;

    /**
     * 
     */
    @Override
    public boolean isEqual(Coordinate coordinate) throws IllegalStateException {
        assertClassInvariants();
        if(coordinate == null) {
            return false;
        }

        CartesianCoordinate c1 = this.asCartesianCoordinate();
        CartesianCoordinate c2 = coordinate.asCartesianCoordinate();
        c2.assertClassInvariants();

        return c1 == c2;
    }

    /**
     * 
     */
    @Override
    public boolean equals(Object object) throws IllegalStateException {
        if(object == null || !(object instanceof AbstractCoordinate)) {
            return false;
        }
        return this.isEqual((Coordinate) object);
    }

    /**
     * 
     */
    @Override
    public int hashCode() throws IllegalStateException {
        return asCartesianCoordinate().hashCode();
    }

    /**
     * 
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException {
        assertClassInvariants();
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate is not allowed to be null");
        }
        return asCartesianCoordinate().getCartesianDistance(coordinate);
    }
        
    /**
     * 
     * @param Coordinate
     * @return double
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException {
        assertClassInvariants();
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate is not allowed to be null");
        }
        return asSphericCoordinate().getCentralAngle(coordinate);
    }
}
