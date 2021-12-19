package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {

    private final double EPSILON = 0.001;

    /**
     * The x, y, z components of the CartesianCoordinate
     */
    private final double X;
    private final double Y;
    private final double Z;

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

        this.X = x;
        this.Y = y;
        this.Z = z;

        assertClassInvariants();
    }

    protected void doAssertClassInvariants() throws IllegalStateException {
        if(Double.isNaN(X)) {
            throw new IllegalStateException("x is NaN");
        }
        if(Double.isNaN(Y)) {
            throw new IllegalStateException("y is NaN");
        }
        if(Double.isNaN(Z)) {
            throw new IllegalStateException("z is NaN");
        }
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getX() throws IllegalStateException {
        assertClassInvariants();
        return X;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getY() throws IllegalStateException {
        assertClassInvariants();
        return Y;
    }

    /**
	 * 
	 * @methodtype get
	 */
    public double getZ() throws IllegalStateException {
        assertClassInvariants();
        return Z;
    }

    /**
     * 
     */
    @Override
    public String toString() throws IllegalStateException {
        assertClassInvariants();
        return "cartesian coordinate: x=" + X + ", y=" + Y + ", z=" + Z;
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

        double xDistSq = Math.pow(X - c.X, 2);
        double yDistSq = Math.pow(Y - c.Y, 2);
        double zDistSq = Math.pow(Z - c.Z, 2);
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
        double radius = Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2) + Math.pow(Z, 2));

        if(radius <= EPSILON) {
            return new SphericCoordinate(0, 0, 0);
        }

        double theta = Math.acos(Z / radius);
        if(X > 0) {
            phi = Math.atan(Y / X);
        } else if(X < 0) {
            phi = Math.atan(Y / X) + Math.PI;
        } else {
            phi = Math.PI / 2;
        }

        assert !Double.isNaN(phi) && Math.abs(phi) <= Math.PI;
        assert !Double.isNaN(theta) && theta >= 0 && theta <= Math.PI;
        assert !Double.isNaN(radius) && radius >= 0;

        return new SphericCoordinate(phi, theta, radius);
    }
}
