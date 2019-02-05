/*
 * Developer:   James Horton
 * Date:        01/28/2019
 * Assignment:  Geometric Object ex 13.5
 * File:        Circle.java
 */

package geometricobjectcomparable;


public class Circle extends GeometricObject
    implements Comparable<Circle>  {
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  @Override /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }

  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /* Print the circle info */
  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated() +
      " and the radius is " + radius);
  } // end of printCircle
  
  @Override
  public int compareTo(Circle o){
       if (this.radius > o.getRadius()){
            return 1;       // return positive value            
        } // end of if
        else if (this.radius < o.getRadius()){
            return -1;      // return positive value
        } // end of else if
        else
            return 0;
   } // end of compareTo
  
} // end of class
