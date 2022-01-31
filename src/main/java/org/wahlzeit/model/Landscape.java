package org.wahlzeit.model;

/**
 * LandscapeObject / LandscapeObjectType collaboration
 * Collaboration Type:
 * Binds: LandscapeType
 * Role: Base Object
 * 
 * LandscapePhoto / Landscape Collaboration
 * Collaboration Type:
 * Binds: LandscapePhoto
 * Role: Service
 * 
 * LandscapeManager / Landscape Collaboration
 * Collaboration Type:
 * Binds: Landscape Manager
 * Role: Element
 */
public class Landscape {

    private static int numberOfInstances = 0;
    
    private final LandscapeType landscapeType;
    private final int id;

    // constructor thet creates a Landscape instance
    public Landscape(LandscapeType landscapeType) {
        if(landscapeType == null) {
            throw new IllegalArgumentException("Landscape type must not be null.");
        }

        this.landscapeType = landscapeType;
        id = ++numberOfInstances;
    }

    public LandscapeType getType() {
        return landscapeType;
    }

    public int getId() {
        return id;
    }

}
