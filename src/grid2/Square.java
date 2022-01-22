package grid2;

public class Square {
	int number;
	boolean shipOn;
	int value;
	boolean firedAt;
	Ship ship;
	
	public Square(int number) {
		setNumber(number);
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	public void setShipOn(boolean shipOn) {
		this.shipOn = shipOn;
	}
	
	public boolean getShipOn () {
		return shipOn;
	}
	
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public Ship getShip() {
		return this.ship;
	}
	
	public void setValue (int value) {
		this.value = value;
	}
	
	public int getValue () {
		return value;
	}
	
	
	public void setFiredAt(boolean firedAt) {
		this.firedAt = firedAt;
	}
	
	public boolean getFiredAt () {
		return firedAt;
	}
	
}

