package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double EPSILON = 0.001;

    /**
     * The x, y, z components of the CartesianCoordinate
     */
    private double x;
    private double y;
    private double z;

    /**
     * 
     * @methodtype constructor
     */
    public CartesianCoordinate(double x, double y, double z) throws IllegalStateException, IllegalArgumentException {
        if(Double.isNaN(x)) {
            throw new IllegalArgumentException("x is NaN");
        }
        if(Double.isNaN(y)) {
            throw new IllegalArgumentException("y is NaN");
        }
        if(Double.isNaN(z)) {
            throw new IllegalArgumentException("z is NaN");
        }

        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    protected void doAssertClassInvariants() throws IllegalStateException {
        if(Double.isNaN(x)) {
            throw new IllegalStateException("x is NaN");
        }
        if(Double.isNaN(y)) {
            throw new IllegalStateException("y is NaN");
        }
        if(Double.isNaN(z)) {
            throw new IllegalStateException("z is NaN");
        }
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getX() throws IllegalStateException {
        assertClassInvariants();
        return x;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getY() throws IllegalStateException {
        assertClassInvariants();
        return y;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getZ() throws IllegalStateException {
        assertClassInvariants();
        return z;
    }

    /**
     * 
     */
    @Override
    public String toString() throws IllegalStateException {
        assertClassInvariants();
        return "cartesian coordinate: x=" + x + ", y=" + y + ", z=" + z;
    }

    /**
     * 
     * @return
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
        assertClassInvariants();
        return this;
    }

    /**
     * 
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) throws IllegalStateException, IllegalArgumentException {
        assertClassInvariants();
        if(coordinate == null) {
            throw new IllegalArgumentException("Coordinate is not allowed to be null");
        }

        assert coordinate != null;

        CartesianCoordinate c = coordinate.asCartesianCoordinate();

        double xDistSq = Math.pow(x - c.x, 2);
        double yDistSq = Math.pow(y - c.y, 2);
        double zDistSq = Math.pow(z - c.z, 2);
        double dist = Math.sqrt(xDistSq + yDistSq + zDistSq);

        assert !Double.isNaN(dist);
        assert dist >= 0;

        return dist;
    }

    /**
     * 
     * @return
     */
    @Override
    public SphericCoordinate asSphericCoordinate() throws ArithmeticException, IllegalStateException {
        assertClassInvariants();

        double phi;
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));

        if(radius <= EPSILON) {
            return new SphericCoordinate(0, 0, 0);
        }

        double theta = Math.acos(z / radius);
        if(x > 0) {
            phi = Math.atan(y / x);
        } else if(x < 0) {
            phi = Math.atan(y / x) + Math.PI;
        } else {
            phi = Math.PI / 2;
        }

        assert !Double.isNaN(phi) && Math.abs(phi) <= Math.PI;
        assert !Double.isNaN(theta) && theta >= 0 && theta <= Math.PI;
        assert !Double.isNaN(radius) && radius >= 0;

        return new SphericCoordinate(phi, theta, radius);
    }
}
