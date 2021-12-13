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
    public SphericCoordinate(double phi, double theta, double radius) throws IllegalStateException, IllegalArgumentException {
        if(Double.isNaN(phi) || Math.abs(phi) > Math.PI) {
            throw new IllegalArgumentException("Phi must be a value in the range of [- PI, PI], actual value is: " + phi);
        }
        if(Double.isNaN(theta) || theta < 0 || theta > Math.PI) {
            throw new IllegalArgumentException("Theta must be a value in the range of [0, PI], actual value is: " + theta);
        }
        if(Double.isNaN(radius) || radius < 0) {
            throw new IllegalArgumentException("Radius must be value >= 0, actual value is: " + radius);
        }

        this.phi = phi;
        this.theta = theta;
        this.radius = radius;

        assertClassInvariants();
    }

    @Override
    protected void doAssertClassInvariants() throws IllegalStateException {
        if (Double.isNaN(phi) || Math.abs(phi) > Math.PI) {
            throw new IllegalStateException("Phi must be a value in the range of [- PI, PI], actual value is: " + phi);
        }
        if(Double.isNaN(theta) || theta < 0 || theta > Math.PI) {
            throw new IllegalStateException("Theta must be a value in the range of [0, PI], actual value is: " + theta);
        }
        if(Double.isNaN(radius) || radius < 0) {
            throw new IllegalStateException("Radius must be value >= 0, actual value is: " + radius);
        }
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getPhi() throws IllegalStateException {
        assertClassInvariants();
        return phi;
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getTheta() throws IllegalStateException {
        assertClassInvariants();
        return theta;
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getRadius() throws IllegalStateException {
        assertClassInvariants();
        return radius;
    }

    /**
     * 
     * @return String
     */
    @Override
    public String toString() throws IllegalStateException {
        assertClassInvariants();
        return "spheric coordinate: phi=" + phi + ", theta=" + theta + ", radius=" + radius;
    }

    /**
     * 
     * @return SphericCoordinate
     */
    @Override
    public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
        assertClassInvariants();
        return this;
    }

    /**
     * 
     */
    @Override
    public double getCentralAngle(Coordinate coordinate) throws IllegalStateException, IllegalArgumentException {
        assertClassInvariants();
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate is not allowed to be null");
        }

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
    public CartesianCoordinate asCartesianCoordinate() throws ArithmeticException, IllegalStateException {
        assertClassInvariants();

        double x = radius * Math.sin(phi) * Math.cos(theta);
        double y = radius * Math.sin(phi) * Math.sin(theta);
        double z = radius * Math.cos(phi);

        assert !Double.isNaN(x);
        assert !Double.isNaN(y);
        assert !Double.isNaN(z);

        return new CartesianCoordinate(x, y, z);
    }
}
