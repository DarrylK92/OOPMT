package mt;

public class Cube extends Shape implements ComputeVolume {
	
	//Create member variables
	private double length, width, height;
	
	//Default constructor
	public Cube() {
		super();
		
		length = 2;
		width = 2;
		height = 2;
	}

	//Returns the surface area of the Cube
	double find_area() {
		return (2 * Math.pow(length, 2)) + 
				(2 * Math.pow(width, 2)) + 
				(2 * Math.pow(height, 2));
	}

	//Returns the volume of the Cube
	public double find_Volume() {
		return length * width * height;
	}
	
	//Returns contents of parent and current Cube
	@Override
	public String toString() {
		return super.toString() +
				"\nCube" +
				"\nSurface area: " + super.mydf.format(find_area()) +
				"\nVolume: " + super.mydf.format(find_Volume());
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
}
