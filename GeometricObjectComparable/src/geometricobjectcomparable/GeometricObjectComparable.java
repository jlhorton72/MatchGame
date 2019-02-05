/*
 * Developer:   James Horton
 * Date:        01/28/2019
 * Assignment:  Geometric Object ex 13.5
 * File:        GeometricObjectComparable.java
 */
package geometricobjectcomparable;

import static geometricobjectcomparable.GeometricObject.getMax;

/**
 *
 * @author jh0375800
 */
public class GeometricObjectComparable 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        GeometricObject geoObject1 = new Circle(5);
        GeometricObject geoObject2 = new Circle(18);
        
        GeometricObject geoObject3 = new Rectangle(5, 7);
        GeometricObject geoObject4 = new Rectangle(7, 10);
        
        getMax(geoObject1, geoObject2);
        getMax(geoObject2, geoObject1);
        getMax(geoObject3, geoObject4);
        getMax(geoObject4, geoObject3);
        
        getMax(geoObject1, geoObject4);
    } // end of main
    
    
  
    
    
    
} // end of class
