package mt;

public class Square extends Shape {
	
	//Create member variables
	private double side;
	
	//Default constructor
	public Square() {
		super();
		
		side = 2.3;
	}

	//Returns the area of the Square
	double find_area() {
		return Math.pow(side, 2);
	}
	
	//Returns contents of parent and current Square
	@Override
	public String toString() {
		return super.toString() +
				"\nSquare" +
				"\nArea: " + super.mydf.format(find_area());
	}

	/**
	 * @return the side
	 */
	public double getSide() {
		return side;
	}

	/**
	 * @param side the side to set
	 */
	public void setSide(double side) {
		this.side = side;
	}
}
