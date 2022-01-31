package org.wahlzeit.model;

import java.sql.*;

/**
 * LandscapePhoto / Landscape Collaboration
 * Role: client
 */
public class LandscapePhoto extends Photo {

    private Landscape landscape;

    // LandscapePhotos constructors which instantiate LandscapePhotos

    /**
	 * 
	 * @methodtype constructor
	 */
    public LandscapePhoto() {
        super();
    }

    /**
	 * 
	 * @methodtype constructor
	 */
    public LandscapePhoto(Landscape landscape) {
        super();
        this.landscape = landscape;
    }

    /**
	 * 
	 * @methodtype constructor
	 */
    public LandscapePhoto(PhotoId myId) throws IllegalArgumentException {
        super(myId);
    }

    /**
	 * 
	 * @methodtype constructor
	 */
    public LandscapePhoto(Location location) {
        super(location);
    }

    /**
	 * 
	 * @methodtype constructor
	 */
    public LandscapePhoto(PhotoId myId, Location location) throws IllegalArgumentException {
        super(myId, location);
    }

    /**
	 * 
	 * @methodtype constructor
	 */
    public LandscapePhoto(ResultSet rset) throws SQLException, IllegalArgumentException {
        super(rset);
    }
    
    public void setLandscape(Landscape landscape) {
        this.landscape = landscape;
    }
    
}
