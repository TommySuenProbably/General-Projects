public class Trapezoid extends Parallelogram {
	private static int num_T = 0;
	private double side3;
	private double side4;
	private String key;
	
	public Trapezoid() {
		this(1.0, 1.0, 1.0, 1.0, 1.0);
	}
	
	public Trapezoid(double side1, double side2, double side3, double side4, double height) {
		super(side1, side2, height);
		this.side3 = side3;
		this.side4 = side4;
		if(this.getClass().equals(Trapezoid.class)) {
			num_T++;
			key = "T" + num_T;
		}
	}
	
	public double getSide1() {
		return side1;
	}

	private void setSide1(double side1) {
		this.side1 = side1;
	}
	
	public double getSide2() {
		return side2;
	}

	private void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public double getSide3() {
		return side3;
	}

	private void setSide3(double side3) {
		this.side3 = side3;
	}
	
	public double getSide4() {
		return side4;
	}

	private void setSide4(double side4) {
		this.side4 = side4;
	}
	
	public double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height= height;
	}
	
	public static int getNum() {
		return num_T;
	}
	
	public String getKey() {
		return key;
	}
	
	public double findArea() {
		return (side1 + side2)*height/2;
	}
	
	public double findPerimeter() {
		return side1 + side2 + side3 + side4;
	}
	
	public String toString() { //Trapezoid
		return "First Base = " + side1 + "\nSecond Base = " + side2 + "\nThird Side = " + this.side3 + "\nFourth Side = " + this.side4 + "\nHeight = " + height; 
	}
}
