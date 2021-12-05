package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

    private double phi;
    private double theta;
    private double radius;

    /**
     * @methodtype constructor
     * 
     * @param phi
     * @param theta
     * @param radius
     */
    public SphericCoordinate(double phi, double theta, double radius) {
        assert !Double.isNaN(phi) && Math.abs(phi) <= Math.PI;
        assert !Double.isNaN(theta) && theta >= 0 && theta <= Math.PI;
        assert !Double.isNaN(radius) && radius >= 0;

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariants();
    }

    private void assertClassInvariants() {
        assert !Double.isNaN(phi) && Math.abs(phi) <= Math.PI;
        assert !Double.isNaN(theta) && theta >= 0 && theta <= Math.PI;
        assert !Double.isNaN(radius) && radius >= 0;
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getPhi() {
        return phi;
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getTheta() {
        return theta;
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getRadius() {
        return radius;
    }

    /**
     * 
     * @return String
     */
    @Override
    public String toString() {
        assertClassInvariants();
        return "spheric coordinate: phi=" + phi + ", theta=" + theta + ", radius=" + radius;
    }

    /**
     * 
     * @return SphericCoordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() {
        return this;
    }

    /**
     * 
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) {

        assert coordinate != null;

        SphericCoordinate c = coordinate.asSphericCoordinate();
        
        double deltaTheta = Math.abs(theta - c.theta);
        double phi1 = phi;
        double phi2 = c.phi;

        double centralAngle = Math.acos(Math.sin(phi1) * Math.sin(phi2) + Math.cos(phi1) * Math.cos(phi2) * Math.cos(deltaTheta));

        assert !Double.isNaN(centralAngle);
        assert centralAngle >= 0 && centralAngle <= 2 * Math.PI;

        return centralAngle;
    }

    /**
     * 
     * @return
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() throws ArithmeticException {
        double x = radius * Math.sin(phi) * Math.cos(theta);
        double y = radius * Math.sin(phi) * Math.sin(theta);
        double z = radius * Math.cos(phi);

        assert !Double.isNaN(x);
        assert !Double.isNaN(y);
        assert !Double.isNaN(z);

        return new CartesianCoordinate(x, y, z);
    }
}
