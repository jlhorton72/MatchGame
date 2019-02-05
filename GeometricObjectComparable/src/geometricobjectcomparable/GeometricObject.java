/*
 * Developer:   James Horton
 * Date:        01/28/2019
 * Assignment:  Geometric Object ex 13.5
 * File:        GeometricObject.java
 */
package geometricobjectcomparable;

/**
 *
 * @author jh0375800
 */

  public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /** Construct a default geometric object */
    protected GeometricObject() {
      dateCreated = new java.util.Date();
    }

    /** Construct a geometric object with color and filled value */
    protected GeometricObject(String color, boolean filled) {
      dateCreated = new java.util.Date();
      this.color = color;
      this.filled = filled;
    }

    /** Return color */
    public String getColor() {
      return color;
    }

    /** Set a new color */
    public void setColor(String color) {
      this.color = color;
    }

    /** Return filled. Since filled is boolean,
     *  the get method is named isFilled */
    public boolean isFilled() {
      return filled;
    }

    /** Set a new filled */
    public void setFilled(boolean filled) {
      this.filled = filled;
    }

    /** Get dateCreated */
    public java.util.Date getDateCreated() {
      return dateCreated;
    }

    @Override
    public String toString() {
      return "created on " + dateCreated + "\ncolor: " + color +
        " and filled: " + filled;
    }

    /** Abstract method getArea */
    public abstract double getArea();

    /** Abstract method getPerimeter */
    public abstract double getPerimeter();
    
    /** Static method to find max */
    public static void getMax(GeometricObject first, GeometricObject second){
        double areaOne = first.getArea();
        double areaTwo = second.getArea();
        if (areaOne < areaTwo)
            System.out.println("The second one is larger");
        if (areaTwo < areaOne)
            System.out.println("The first one is larger");           
    } // end of getMax
    
} // end of class

