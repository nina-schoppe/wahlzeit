package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

    private final double PHI;
    private final double THETA;
    private final double RADIUS;

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

        this.PHI = phi;
        this.THETA = theta;
        this.RADIUS = radius;

        assertClassInvariants();
    }

    @Override
    protected void doAssertClassInvariants() throws IllegalStateException {
        if (Double.isNaN(PHI) || Math.abs(PHI) > Math.PI) {
            throw new IllegalStateException("Phi must be a value in the range of [- PI, PI], actual value is: " + PHI);
        }
        if(Double.isNaN(THETA) || THETA < 0 || THETA > Math.PI) {
            throw new IllegalStateException("Theta must be a value in the range of [0, PI], actual value is: " + THETA);
        }
        if(Double.isNaN(RADIUS) || RADIUS < 0) {
            throw new IllegalStateException("Radius must be value >= 0, actual value is: " + RADIUS);
        }
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getPhi() throws IllegalStateException {
        assertClassInvariants();
        return PHI;
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getTheta() throws IllegalStateException {
        assertClassInvariants();
        return THETA;
    }

    /**
     * @methodtype get
     * 
     * @return double
     */
    public double getRadius() throws IllegalStateException {
        assertClassInvariants();
        return RADIUS;
    }

    /**
     * 
     * @return String
     */
    @Override
    public String toString() throws IllegalStateException {
        assertClassInvariants();
        return "spheric coordinate: phi=" + PHI + ", theta=" + THETA + ", radius=" + RADIUS;
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
        
        double deltaTheta = Math.abs(THETA - c.THETA);
        double phi1 = PHI;
        double phi2 = c.PHI;

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

        double x = RADIUS * Math.sin(PHI) * Math.cos(THETA);
        double y = RADIUS * Math.sin(PHI) * Math.sin(THETA);
        double z = RADIUS * Math.cos(PHI);

        assert !Double.isNaN(x);
        assert !Double.isNaN(y);
        assert !Double.isNaN(z);

        return new CartesianCoordinate(x, y, z);
    }
}
