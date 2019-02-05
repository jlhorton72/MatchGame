/*
 * Developer:   James Horton
 * Date:        01/28/2019
 * Assignment:  Geometric Object ex 13.5
 * File:        Rectangle.java
 */
package geometricobjectcomparable;

public class Rectangle extends GeometricObject 
    implements Comparable<Rectangle> {
  private double width;
  private double height;

  public Rectangle() {
  }

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /** Return width */
  public double getWidth() {
    return width;
  }

  /** Set a new width */
  public void setWidth(double width) {
    this.width = width;
  }

  /** Return height */
  public double getHeight() {
    return height;
  }

  /** Set a new height */
  public void setHeight(double height) {
    this.height = height;
  }

  @Override /** Return area */
  public double getArea() {
    return width * height;
  }

  @Override /** Return perimeter */
  public double getPerimeter() {
    return 2 * (width + height);
  }
  
  @Override
  public int compareTo(Rectangle o){
      if (this.getArea() > o.getArea()){
          return 1;       // return positive value            
      } // end of if
      else if (this.getArea() < o.getArea()){
          return -1;      // return positive value
      } // end of else if
      else
          return 0;
  } // end of compareTov
  
} // end of class