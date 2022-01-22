package grid2;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Grid {

	ArrayList <Row> theGrid = new ArrayList <Row> ();
	
	public Grid() {
		for(int loop = 1; loop <= 10; loop++) {
			Row tempRow;
			tempRow = new Row(loop);
			this.theGrid.add(tempRow);
		}
	}
	
	public void insertShip(Ship ship) {
		Random random = new Random();
		
		ship.setHorizontal(random.nextInt(2) == 0 ? true : false);
		
		// choose whether vertical or not
		int horizontalStep = ship.getHorizontalChoice();
		int verticalStep = ship.getVerticalChoice();
		
		//if vertical start row number = grid size - ship number of boxes.
		int startRowNumber = random.nextInt(theGrid.size() - ship.numOfBox * verticalStep);
		
		
		// what does this do? Get the whole row?
		ArrayList<Square> startRow = theGrid.get(startRowNumber).theRow;
		
		// if horizontal start square number = row size -ship number of boxes 
		
		int startSquareNumber = random.nextInt(startRow.size() - ship.numOfBox * horizontalStep);
		
		// loop through boxes
		for (int box = 0; box < ship.numOfBox; box++) {
			int row = startRowNumber + box * verticalStep;
			int square = startSquareNumber + box * horizontalStep;
			if (theGrid.get(row).theRow.get(square).getShip() != null) {
				insertShip(ship);
				return;
			}
			
		}
		
		// set the first square of ship to startRow and start start number
		ship.setSquare(startSquareNumber);
		ship.setRow(startRowNumber);
		

		
		//loop and insert ships
		for (int box = 0; box <ship.numOfBox; box++) {
			int row = startRowNumber + box * verticalStep;
			int square = startSquareNumber + box * horizontalStep;
			theGrid.get(row).theRow.get(square).setShip(ship);
			
			// store positions in an tracker arraylist
			
			ship.storeTracker(square, row);
			
		}
	}
	
	public void removeShip(Ship ship) {
		
		
		int targetRow = ship.getRow();
		int targetSquare = ship.getSquare();
		int horizontalChoice = ship.getHorizontalChoice();
		int verticalChoice = ship.getVerticalChoice();
		
		JOptionPane.showMessageDialog(null, "" + (targetSquare +1) + (targetRow +1) + horizontalChoice + verticalChoice);
		
		for (int box = 0; box < ship.numOfBox; box++) {
			int row = targetRow + box * verticalChoice;
			int square = targetSquare + box * horizontalChoice;
			theGrid.get(row).theRow.get(square).setShip(null);
			
			String output;
			output = "removing box"  + (square +1)+ (row+1);
			JOptionPane.showMessageDialog(null, output);
			
		}
		
		
	}
	
    
	


}
