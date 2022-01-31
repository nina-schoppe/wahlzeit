package org.wahlzeit.model;

import java.util.HashMap;

/**
 * LandscapeManager / Landscape Collaboration
 * Binds: Landscape
 * Role: Manager
 */
public class LandscapeManager {

    protected static final LandscapeManager instance = new LandscapeManager();
    private final HashMap<Integer, Landscape> landscapes = new HashMap<>();
    private final HashMap<String, LandscapeType> landscapeTypes = new HashMap<>();

    public static LandscapeManager getInstance() {
        return instance;
    }

    /**
     * 
     * @param typeName
     * @return
     */
    public Landscape createLandscape(String typeName) {
        if(typeName == null) {
            throw new IllegalArgumentException("Type name must not be null.");
        }

        LandscapeType landscapeType = getLandscapeType(typeName);
        Landscape result = landscapeType.createInstance();
        landscapes.put(result.getId(), result);
        return result;
    }

    /**
     * 
     * @param typeName
     */
    private void addLandscapeType(String typeName) {
        landscapeTypes.put(typeName, new LandscapeType(typeName));
    }

    /**
     * 
     * @param typeName
     * @return
     */
    public LandscapeType getLandscapeType(String typeName) {
        if(!landscapeTypes.containsKey(typeName)) {
            addLandscapeType(typeName);
        }
        return landscapeTypes.get(typeName);
    }
}
