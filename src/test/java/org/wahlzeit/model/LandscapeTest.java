package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LandscapeTest {

    @Test
    public void testConstructor() {
        LandscapeType lt1 = new LandscapeType("test1");
        LandscapeType lt2 = new LandscapeType("test2");
        Landscape l1 = new Landscape(lt1);
        Landscape l2 = new Landscape(lt1);
        Landscape l3 = new Landscape(lt2);

        assert l1.getId() == 1;
        assert l2.getId() == 2;
        assert l3.getId() == 3;

        assertEquals(l1.getType(), lt1);
        assertEquals(l2.getType(), lt1);
        assertEquals(l3.getType(), lt2);
    }
}
