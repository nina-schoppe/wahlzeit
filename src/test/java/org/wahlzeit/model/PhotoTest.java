package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class PhotoTest {

    @Test
    public void testConstructor() {
        CartesianCoordinate cartesianCoordinate1 = new CartesianCoordinate(0.5, 7.8, 1.9);
        CartesianCoordinate cartesianCoordinate2 = new CartesianCoordinate(0.5, 3, 7.2);
        Location location1 = new Location(cartesianCoordinate1);
        Location location2 = new Location(cartesianCoordinate2);
        Photo photo1 = new Photo(location1);
        Photo photo2 = new Photo(location2);
        assertNotEquals(photo1.getId(), photo2.getId());
        assertEquals(location1, photo1.getLocation());
        assertEquals(location2, photo2.getLocation());
        assertNotEquals(photo1.getLocation(), photo2.getLocation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullId() {
        PhotoId id = null;
        new Photo(id);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorNullRset() {
        ResultSet rset = null;
        try {
            new Photo(rset);
        } catch (SQLException e) {
           // do nothing
        }
    }

    @Test
    public void testSetLocation() {
        Photo photo = new Photo();
        Location location = new Location(new CartesianCoordinate(1, 1, 1));
        assertNull(photo.getLocation());
        photo.setLocation(location);
        assertEquals(location, photo.getLocation());
    }
}
