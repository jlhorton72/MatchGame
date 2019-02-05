/*
 * Developer:   James Horton
 * Date:        01/28/2019
 * Assignment:  Geometric Object ex 13.5
 * File:        TestGeometricObject.java
 */
package geometricobjectcomparable;

/**
 *
 * @author jh0375800
 */
public class Hexagon extends GeometricObject
    implements Comparable<Hexagon> {
    // class fields
    private int sideSize;
    /**
     * default no-arg constructor
     */
    public Hexagon() {
    }
    /**
     * constructor for a hexagon object
     * @param sideSize 
     */
    public Hexagon(int sideSize) {
        this.sideSize = sideSize;
    } // end of constructor
    
    public int getSideSize() {
        return sideSize;
    } // end of getSideSize

    public void setSideSize(int sideSize) {
        this.sideSize = sideSize;
    } // end of setSideSize
    
    @Override
    public double getArea(){
        return sideSize * 60.0; // this is a made up area, not the actul area
    } // end of getArea
    
    @Override
    public double getPerimeter(){
        return sideSize * 6.0; 
    } // end of getPerimeter
    
    @Override
    public int compareTo(Hexagon o){
        if (this.sideSize > o.sideSize){
            return 1;       // return positive value            
        } // end of if
        else if (this.sideSize < o.sideSize){
            return -1;      // return positive value
        } // end of else if
        else
            return 0;
    } // end of compareTo
    
} // end of class Hexagon
