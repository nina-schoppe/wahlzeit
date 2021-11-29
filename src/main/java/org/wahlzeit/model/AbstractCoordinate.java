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

        CartesianCoordinate c1 = this.asCartesianCoordinate();
        CartesianCoordinate c2 = coordinate.asCartesianCoordinate();

        double xDistSq = Math.pow(c1.getX() - c2.getX(), 2);
        double yDistSq = Math.pow(c1.getY() - c2.getY(), 2);
        double zDistSq = Math.pow(c1.getZ() - c2.getZ(), 2);
        return Math.sqrt(xDistSq + yDistSq + zDistSq);
    }
        
    /**
     * 
     * @param Coordinate
     * @return double
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {

        SphericCoordinate c1 = this.asSphericCoordinate();
        SphericCoordinate c2 = coordinate.asSphericCoordinate();
        
        double deltaTheta = Math.abs(c1.getTheta() - c2.getTheta());
        double phi1 = c1.getPhi();
        double phi2 = c2.getPhi();

        double centralAngle = Math.acos(Math.sin(phi1) * Math.sin(phi2) + Math.cos(phi1) * Math.cos(phi2) * Math.cos(deltaTheta));

        return centralAngle;
    }
}
