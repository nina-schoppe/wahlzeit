package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LandscapeTypeTest {
    
    @Test
    public void testaddSubType() {
        LandscapeType lt1 = new LandscapeType("test1");
        LandscapeType lt2 = new LandscapeType("test2");
        LandscapeType lt3 = new LandscapeType("test3");
        LandscapeType lt4 = new LandscapeType("test4");
        lt1.addSubType(lt2);
        lt1.addSubType(lt3);
        lt3.addSubType(lt4);

        assertEquals(lt2.getSuperType(), lt1);
        assertEquals(lt3.getSuperType(), lt1);
        assertEquals(lt4.getSuperType(), lt3);
        assertFalse(lt1.isSubtype());
    }

    @Test
    public void testHasInstance() {
        LandscapeType lt1 = new LandscapeType("test1");
        LandscapeType lt2 = new LandscapeType("test2");
        LandscapeType lt3 = new LandscapeType("test3");
        lt1.addSubType(lt2);
        lt1.addSubType(lt3);
        Landscape l = lt2.createInstance();

        assertTrue(lt2.hasInstance(l));
        assertTrue(lt1.hasInstance(l));
        assertFalse(lt3.hasInstance(l));
    }
}
