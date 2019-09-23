class Trapezoid extends Parallelogram {
	private double side3;
	private double side4;
	
	Trapezoid() {
		super();
		side3 = 1.0;
		side4 = 1.0;
	}
	
	Trapezoid(double side1, double side2, double side3, double side4, double height) {
		super(side1, side2, height);
		this.side3 = side3;
		this.side4 = side4;
	}
	
	protected double findArea() {
		return (side1 + side2)*height/2;
	}
	
	protected double findPerimeter() {
		return side1 + side2 + side3 + side4;
	}
	
	public String toString() { //Trapezoid
		return "First Base = " + side1 + "\nSecond Base = " + side2 + "\nThird Side = " + this.side3 + "\nFourth Side = " + this.side4 + "\nHeight = " + height; 
	}
}
