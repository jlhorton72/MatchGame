/*
 * Developer:   James Horton
 * Date:        01/28/2019
 * Assignment:  Geometric Object ex 13.5
 * File:        TestGeometricObject.java
 */
package geometricobjectcomparable;


public class TestGeometricObject {
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize two geometric objects
    GeometricObject geoObject1 = new Circle(5);
    GeometricObject geoObject2 = new Rectangle(5, 3);

    System.out.println("The two objects have the same area? " +
      equalArea(geoObject1, geoObject2));

    // Display circle
    displayGeometricObject(geoObject1);

    // Display rectangle
    displayGeometricObject(geoObject2);
    
    // add code to create a hexagon 
    Hexagon[] hexArr = new Hexagon[4];
    hexArr[0] = new Hexagon (7);
    hexArr[1] = new Hexagon (9);    
    hexArr[2] = new Hexagon(3);
    hexArr[3] = new Hexagon(6);
    
    for (Hexagon one : hexArr){
        displayGeometricObject(one);
    } // end of foreach
    
    java.util.Arrays.sort(hexArr);
    for (Hexagon one : hexArr){
        displayGeometricObject(one);
    } // end of foreach
  } // end of main

  /** A method for comparing the areas of two geometric objects */
  public static boolean equalArea(GeometricObject object1,
      GeometricObject object2) {
    return object1.getArea() == object2.getArea();
  } // end of equalArea

  /** A method for displaying a geometric object */
  public static void displayGeometricObject(GeometricObject object) {
    System.out.println();
    System.out.println("The area is " + object.getArea());
    System.out.println("The perimeter is " + object.getPerimeter());
  } // end of displayGeometricObject
  
} // end of TestGeometricObject