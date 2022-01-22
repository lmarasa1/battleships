package grid2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Ship {

	int numOfBox;
	String name;
	boolean isHorizontal;
	int value;
	int row;
	int square;

	ArrayList<Integer> xSquareCoordinates = new ArrayList <Integer>();
	ArrayList<Integer> yRowCoordinates = new ArrayList <Integer>();
	

	
    public Ship() {}// end constructor 1

	public Ship(int box, String name, int value) {
		this.numOfBox= box;
		this.name=name;
		this.value = value;
		
		isHorizontal = generateAnswer();
	}
	
	
	private boolean generateAnswer(){
		
		int num;
		Random numberGenerator= new Random();
		num = numberGenerator.nextInt(2);
		
		if(num > 0){
		
			return true;
			
		}
		
		else return false;
			
	}// end generateAnswer
	
	
	public boolean getHorizontal() {
		return isHorizontal;
	}
	
	public void setHorizontal(boolean horizontal) {
		isHorizontal = horizontal;
	}
	
	
	public int getValue() {
		return value;
	}
	
	public void setSquare(int square) {
		this.square = square;
	}
	
	public int getSquare() {
		return square;
		
	}
	
	public int getNumOfBox() {
		return numOfBox;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	public int getRow() {
		return row;
	}
	
	public int getHorizontalChoice() {
		
		return isHorizontal ? 1 : 0;
		
	}
	
    public int getVerticalChoice() {
		
		return isHorizontal ? 0 : 1;
		
	}
    
 // store x(row ) and y (row) coordinates in their respective arrayLists
    public void storeTracker(int square, int row) {
    	
    	
    	xSquareCoordinates.add(square);
    	yRowCoordinates.add(row);
    	
    }
	
	// return an x (square) element from xCoordinate
    public int returnX(int position) {
    	
    	int xCoordinate = xSquareCoordinates.get(position);
    	return xCoordinate;
    }
	
    // return a y (row) coordinate from yCoordinate
    public int returnY(int position) {
    	int yCoordinate = yRowCoordinates.get(position);
    	return yCoordinate;
    }
	
	

	
	
	
	
	
	
}// end of class
