package org.wahlzeit.model;

import java.sql.*;

public class LandscapePhoto extends Photo {

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
    
}
