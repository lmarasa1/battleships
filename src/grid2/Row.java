package grid2;

import java.util.ArrayList;

public class Row {

	int number;
	ArrayList <Square> theRow = new ArrayList <Square> ();
	
	public Row(int number) {
		Square tempSquare;
		for(int loop = 1; loop <= 10; loop++) {
			tempSquare = new Square(loop);
			this.theRow.add(tempSquare);
		}
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
}
