package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;

public class LandscapeType {
    
  private LandscapeType superType;
  private final HashSet<LandscapeType> subTypes;
  private final String typeName;

  /**
   * @Methodtype constructor
   */
  public LandscapeType(String typeName) {
    if(typeName == null) {
      throw new IllegalArgumentException("Type name must not be null.");
    }
    this.typeName = typeName;
    subTypes = new HashSet<LandscapeType>();
  }
    
  /**
   * 
   * @return
   */
  public Landscape createInstance() {
    return new Landscape(this);
  }

  public String getTypeName() {
    return typeName;
  }

  /**
    * @Methodtype get
   */
  public LandscapeType getSuperType() {
    return superType;
  }

  /**
   * @Methodtype set
   */
  public void setSuperType(LandscapeType landscapeType) {
    superType = landscapeType;
  }

  public Iterator<LandscapeType> getSubTypeIterator() {
    return subTypes.iterator();
  }
    
  /**
   * 
   * @param landscapeType
   */
  public void addSubType(LandscapeType landscapeType) {
    assert(landscapeType != null) : "tried to set sub-type to null";
    landscapeType.setSuperType(this);
    subTypes.add(landscapeType);
  }

  /**
   * 
   * @param landscape
   * @return
   */
  public boolean hasInstance(Landscape landscape) {
    assert (landscape != null) : "asked about null object";
    if (landscape.getType() == this) {
    return true;
    }
    for (LandscapeType type : subTypes) {
      if (type.hasInstance(landscape)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * 
   * @return
   */
  public boolean isSubtype() {
    return superType != null;
  }
}
