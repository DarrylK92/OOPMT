package mt;

public class Circle extends Shape {
	
	//Create member variables
	private double radius;
	
	//Default constructor
	public Circle() {
		super();
		
		radius = 1;
	}

	//Returns the area of the Circle
	double find_area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	//Returns contents of parent and current Circle
	@Override
	public String toString() {
		return super.toString() +
				"\nCircle" +
				"\nArea: " + super.mydf.format(find_area());
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
}
