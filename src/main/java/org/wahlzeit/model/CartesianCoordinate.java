package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

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
    public SphericCoordinate asSphericCoordinate() {
        double radius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        double theta = Math.acos(z / radius);
        double phi;
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
