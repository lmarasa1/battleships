package grid2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BattleGame {
	static ArrayList<Integer> xShots = new ArrayList<Integer>();
	static ArrayList<Integer> yShots = new ArrayList<Integer>();

	public static void main(String[] args) {

		Grid grid = new Grid();

		Ship sp1 = new Ship(5, "Aircraft Carrier", 2);
		Ship sp2 = new Ship(4, "Battle Ship", 4);
		Ship sp3 = new Ship(3, "Submarine", 6);
		Ship sp4 = new Ship(2, "Destroyer", 8);
		Ship sp5 = new Ship(1, "Patrol boat", 10);

		boolean choice = warMenu();

		insertShips(grid, sp1, sp2, sp3, sp4, sp5);

		takeShots(grid, choice, sp1, sp2, sp3, sp4, sp5);

	}

	public static boolean warMenu() {
		boolean reveal = false;

		// menu providing option choosing debug or normal mode

		int reply = JOptionPane.showConfirmDialog(null, "Would you like to play in Debug mode?", "",
				JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "You have selected debug mode....");
			reveal = true;

			return reveal;

		} else {
			JOptionPane.showMessageDialog(null, "Lets blow some ships!");
			reveal = false;
			return reveal;

		}
	}

	public static void insertShips(Grid grid, Ship sp1, Ship sp2, Ship sp3, Ship sp4, Ship sp5) {

		grid.insertShip(sp1);
		grid.insertShip(sp2);
		grid.insertShip(sp3);
		grid.insertShip(sp4);
		grid.insertShip(sp5);

	}

	public static void takeShots(Grid grid, boolean choice, Ship sp1, Ship sp2, Ship sp3, Ship sp4, Ship sp5) {

		String xAsString;
		String yAsString;
		int X;
		int Y;
		int value = 0;
		int maxValue;
		// loop ensuring max 10 turns
		int turnNumber = 10;

		for (int turn = 0; turn <= turnNumber; turn++) {

			// take a shot for each turn
			if (choice == true) {
				String output;
				output = debugDisplay(sp1, sp2, sp3, sp4, sp5);
				xAsString = JOptionPane.showInputDialog(output + "\n" + "Please enter column number");
				X = Integer.parseInt(xAsString);
				if (X <1 || X>10) {
					String outOfBounds = "ERROR - the Number you have enetered is too high or too low, please enter a number between 1 and 10";
					JOptionPane.showMessageDialog(null, outOfBounds);
					takeShots(grid,  choice, sp1, sp2,  sp3,  sp4, sp5);
				}
				xShots.add(X);

				yAsString = JOptionPane.showInputDialog(output + "\n" + "Please enter row number");
				Y = Integer.parseInt(yAsString);
				if (Y <1 || Y>10) {
					String outOfBounds = "ERROR - the Number you have enetered is too high or too low, please enter a number between 1 and 10";
					JOptionPane.showMessageDialog(null, outOfBounds);
					takeShots(grid,  choice, sp1, sp2,  sp3,  sp4, sp5);
				}
				
				xShots.add(Y);

				for (int loop = 0; loop < xShots.size(); loop++) {
					if (X == xShots.get(loop) && Y == yShots.get(loop));
						
					String alreadyFired = "Error this shot has already been fired! Take Another shot.";
					JOptionPane.showMessageDialog(null, alreadyFired);
					takeShots(grid,  choice, sp1, sp2,  sp3,  sp4, sp5);

				}

				Square target = grid.theGrid.get(Y - 1).theRow.get(X - 1);

				value += checkShot(grid, target, Y);

			} else {

				xAsString = JOptionPane.showInputDialog("Please enter column (x) number");
				X = Integer.parseInt(xAsString);
				if (X <1 || X>10) {
					String outOfBounds = "ERROR - the Number you have enetered is too high or too low, please enter a number between 1 and 10";
					JOptionPane.showMessageDialog(null, outOfBounds);
					takeShots(grid,  choice, sp1, sp2,  sp3,  sp4, sp5);
				}
				
				xShots.add(X);

				yAsString = JOptionPane.showInputDialog("Please enter row (y) number");
				Y = Integer.parseInt(yAsString);
				
				if (Y <1 || Y>10) {
					String outOfBounds = "ERROR - the Number you have enetered is too high or too low, please enter a number between 1 and 10";
					JOptionPane.showMessageDialog(null, outOfBounds);
					takeShots(grid,  choice, sp1, sp2,  sp3,  sp4, sp5);
				}
				xShots.add(Y);

				for (int loop = 0; loop < xShots.size(); loop++) {
					if (X == xShots.get(loop) && Y == yShots.get(loop));
						
					String alreadyFired = "Error this shot has already been fired!";
					JOptionPane.showMessageDialog(null, alreadyFired);
					takeShots(grid,  choice, sp1, sp2,  sp3,  sp4, sp5);
				}

				Square target = grid.theGrid.get(Y - 1).theRow.get(X - 1);

				value += checkShot(grid, target, Y);

			}

			// check for

			if (value == 30) {
				endGame(value);
			}

		}
		endGame(value);
	}

	public static String debugDisplay(Ship sp1, Ship sp2, Ship sp3, Ship sp4, Ship sp5) {

		String output;

		// Aircraft Carrier
		String sp1X, sp1Y, sp1X2, sp1Y2, sp1X3, sp1Y3, sp1X4, sp1Y4, sp1X5, sp1Y5;
		sp1X = retreiveX(0, sp1);
		sp1Y = retreiveY(0, sp1);
		sp1X2 = retreiveX(1, sp1);
		sp1Y2 = retreiveY(1, sp1);
		sp1X3 = retreiveX(2, sp1);
		sp1Y3 = retreiveY(2, sp1);
		sp1X4 = retreiveX(3, sp1);
		sp1Y4 = retreiveY(3, sp1);
		sp1X5 = retreiveX(4, sp1);
		sp1Y5 = retreiveY(4, sp1);

		// Battleship
		String sp2X, sp2Y, sp2X2, sp2Y2, sp2X3, sp2Y3, sp2X4, sp2Y4;

		sp2X = retreiveX(0, sp2);
		sp2Y = retreiveY(0, sp2);
		sp2X2 = retreiveX(1, sp2);
		sp2Y2 = retreiveY(1, sp2);
		sp2X3 = retreiveX(2, sp2);
		sp2Y3 = retreiveY(2, sp2);
		sp2X4 = retreiveX(3, sp2);
		sp2Y4 = retreiveY(3, sp2);

		// Submarine
		String sp3X, sp3Y, sp3X2, sp3Y2, sp3X3, sp3Y3;

		sp3X = retreiveX(0, sp3);
		sp3Y = retreiveY(0, sp3);
		sp3X2 = retreiveX(1, sp3);
		sp3Y2 = retreiveY(1, sp3);
		sp3X3 = retreiveX(2, sp3);
		sp3Y3 = retreiveY(2, sp3);

		// Destroyer
		String sp4X, sp4Y, sp4X2, sp4Y2;

		sp4X = retreiveX(0, sp4);
		sp4Y = retreiveY(0, sp4);
		sp4X2 = retreiveX(1, sp4);
		sp4Y2 = retreiveY(1, sp4);

		// Patrol boat
		String sp5X, sp5Y;
		sp5X = retreiveX(0, sp5);
		sp5Y = retreiveY(0, sp5);

		output = "Aircraft Carrier " + "(" + sp1X + "," + sp1Y + ") " + "(" + sp1X2 + "," + sp1Y2 + ") " + "(" + sp1X3
				+ "," + sp1Y3 + ") " + "(" + sp1X4 + "," + sp1Y4 + ") " + "(" + sp1X5 + "," + sp1Y5 + ") " + "\n"
				+ "Battleship " + "(" + sp2X + "'" + sp2Y + ")" + "(" + sp2X2 + "," + sp2Y2 + ")" + "(" + sp2X3 + ","
				+ sp2Y3 + ") " + "(" + sp2X4 + "," + sp2Y4 + ") " + "\n" + "Submarine " + "(" + sp3X + "'" + sp3Y + ") "
				+ "(" + sp3X2 + "," + sp3Y2 + ") " + "(" + sp3X3 + "," + sp3Y3 + ") " + "\n" + "Destroyer " + "(" + sp4X
				+ "'" + sp4Y + ") " + "(" + sp4X2 + "," + sp4Y2 + ") " + '\n' + "Patrol boat " + "(" + sp5X + "'" + sp5Y
				+ ")";

		return output;

	}

	public static String retreiveX(int index, Ship ship) {
		int displayedShip = ship.returnX(index);
		String resultAsString = Integer.toString(displayedShip + 1);
		return resultAsString;

	}

	public static String retreiveY(int index, Ship ship) {
		int displayedShip = ship.returnY(index);
		String resultAsString = Integer.toString(displayedShip + 1);
		return resultAsString;

	}

	public static int checkShot(Grid grid, Square target, int Y) {

		if (target.getShip() == null) {
			return 0;
		}

		int ShotValue = 0;

		if (target.getShip().getValue() == 2) { // aircraft carrier
			String output;

			ShotValue = target.getShip().getValue();

			grid.removeShip(target.getShip());

//			target.getShip().setValue(0);

			// display explosion

			output = "Aircraft Carrier has been shot! You get 2 points";

			JOptionPane.showMessageDialog(null, output);

		} else if (target.getShip().getValue() == 4) { // check for battleShip
			String output;

			int targetRow = Y - 1;

			ShotValue += target.getShip().getValue();

			grid.removeShip(target.getShip());

			output = "Battle Ship has been shot! You get 4 points";

			JOptionPane.showMessageDialog(null, output);

		} else if (target.getShip().getValue() == 6) { // submarine
			String output;

			output = "Submarine has been shot! You get 6 points";

			JOptionPane.showMessageDialog(null, output);

			int targetRow = Y - 1;

			ShotValue += target.getShip().getValue();

			grid.removeShip(target.getShip());

		} else if (target.getShip().getValue() == 8) { /// destroyer
			String output;

			output = "Destroyer has been shot! You get 8 points";

			JOptionPane.showMessageDialog(null, output);

			int targetRow = Y - 1;

			ShotValue += target.getShip().getValue();

			grid.removeShip(target.getShip());

		} else if (target.getShip().getValue() == 10) { // patrol boat
			String output;

			output = "Patrol ship has been shot! You get 10 points";

			JOptionPane.showMessageDialog(null, output);

			int targetRow = Y - 1;

			ShotValue = target.getShip().getValue();

			grid.removeShip(target.getShip());

		}

		return ShotValue;

	}

	// end game

	public static void endGame(int value) {

		String output;

		output = "Game Over! You have " + value + "points!";

		JOptionPane.showMessageDialog(null, output);

		// System.exit(0);

	}

}
