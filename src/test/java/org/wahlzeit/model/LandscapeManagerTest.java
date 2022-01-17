package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class LandscapeManagerTest {

    @Test
    public void testGetLandscapeType() {
        String tn1 = "test1";
        String tn2 = "test2";
        LandscapeManager lm = LandscapeManager.getInstance();
        LandscapeType lt1 = lm.getLandscapeType(tn1);
        LandscapeType lt2 = lm.getLandscapeType(tn1);
        LandscapeType lt3 = lm.getLandscapeType(tn2);

        assertEquals(lt1, lt2);
        assertNotEquals(lt2, lt3);
    }

    @Test
    public void testCreateLandscape() {
        String tn1 = "test1";
        String tn2 = "test2";
        LandscapeManager lm = LandscapeManager.getInstance();
        Landscape l1 = lm.createLandscape(tn1);
        Landscape l2 = lm.createLandscape(tn1);
        Landscape l3 = lm.createLandscape(tn2);

        assertEquals(l1.getType(), l2.getType());
        assertNotEquals(l2.getType(), l3.getType());
        assertNotEquals(l1, l2);
        assertNotEquals(l2, l3);
    }
}
