package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double EPSILON = 0.0001;

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
        this.x = x;
        this.y = y;
        this.z = z;
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
        return new SphericCoordinate(phi, theta, radius);
    }
}
