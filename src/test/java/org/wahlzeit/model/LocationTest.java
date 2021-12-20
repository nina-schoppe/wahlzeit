package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.lang.reflect.Field;

public class LocationTest {
    
    @Test
    public void testConstructor() {
        CartesianCoordinate cartesianCoordinate = CartesianCoordinate.getCoordinate(1.1, 2.4, 5.3);
        SphericCoordinate sphericCoordinate = SphericCoordinate.getCoordinate(1.9, 2.1, 7.3);
        Location location1 = new Location(cartesianCoordinate);
        Location location2 = new Location(sphericCoordinate);
        assertEquals(cartesianCoordinate, location1.getCoordinate());
        assertEquals(sphericCoordinate, location2.getCoordinate());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNull() {
        CartesianCoordinate coordinate = null;
        new Location(coordinate);
    }

    @Test(expected = IllegalStateException.class)
    public void testAssertClassInvariants() {
        CartesianCoordinate coordinate = CartesianCoordinate.getCoordinate(0, 0, 0);
        Location location = new Location(coordinate);
        try {
            Field coordinateField = location.getClass().getDeclaredField("coordinate");
            coordinateField.setAccessible(true);
            coordinateField.set(location, null);
            location.assertClassInvariants();
        } catch(NoSuchFieldException | IllegalAccessException e) {
            // do nothing
        }
    }

    @Test
    public void testEquals() {
        Location l1 = new Location(CartesianCoordinate.getCoordinate(0, 0, 0));
        Location l2 = new Location(SphericCoordinate.getCoordinate(1, 2, 0));
        Location l3 = new Location(SphericCoordinate.getCoordinate(1, 2, 1));
        assertEquals(l1, l1);
        assertEquals(l1, l2);
        assertNotEquals(l2, l3);
    }
}
