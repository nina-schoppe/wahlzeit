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
    public CartesianCoordinate(double x, double y, double z) {
        assert !Double.isNaN(x);
        assert !Double.isNaN(y);
        assert !Double.isNaN(z);

        this.x = x;
        this.y = y;
        this.z = z;

        assertClassInvariants();
    }

    private void assertClassInvariants() {
        assert !Double.isNaN(this.x);
        assert !Double.isNaN(this.y);
        assert !Double.isNaN(this.z);
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getX() {
        return x;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getY() {
        return y;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getZ() {
        return z;
    }

    /**
     * 
     */
    @Override
    public String toString() {
        return "cartesian coordinate: x=" + x + ", y=" + y + ", z=" + z;
    }

    /**
     * 
     * @return
     */
    @Override
    public CartesianCoordinate asCartesianCoordinate() {
        return this;
    }

    /**
     * 
     */
    @Override
    public double getCartesianDistance(Coordinate coordinate) {

        assert coordinate != null;

        CartesianCoordinate c = coordinate.asCartesianCoordinate();

        double xDistSq = Math.pow(x - c.x, 2);
        double yDistSq = Math.pow(y - c.y, 2);
        double zDistSq = Math.pow(z - c.z, 2);
        double dist = Math.sqrt(xDistSq + yDistSq + zDistSq);

        assert !Double.isNaN(dist);

        return dist;
    }

    /**
     * 
     * @return
     */
    @Override
    public SphericCoordinate asSphericCoordinate() throws ArithmeticException {
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

        assert !Double.isNaN(radius) && radius >= 0;
        assert !Double.isNaN(phi);
        assert !Double.isNaN(theta);

        return new SphericCoordinate(phi, theta, radius);
    }
}
