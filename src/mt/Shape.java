package mt;

import java.text.DecimalFormat;

public abstract class Shape {
	//Create member variables
	protected DecimalFormat mydf = new DecimalFormat("00.00");
	private String color;
	
	//Default constructor
	public Shape() {
		color = "red";
	}
	
	//Abstract method to return the area of the child object
	abstract double find_area();
	
	//Returns the folor of the current shape
	@Override
	public String toString() {
		return "\n******************************" +
				"\nColor: " + color;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
}
