package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

public class LocationTest {
    
    @Test
    public void testConstructor() {
        CartesianCoordinate cartesianCoordinate = new CartesianCoordinate(1.1, 2.4, 5.3);
        SphericCoordinate sphericCoordinate = new SphericCoordinate(1.9, 2.1, 7.3);
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
        CartesianCoordinate coordinate = new CartesianCoordinate(0, 0, 0);
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
}
