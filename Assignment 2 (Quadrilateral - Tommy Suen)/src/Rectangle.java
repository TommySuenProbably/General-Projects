public class Rectangle extends Square{
	private static int num_R = 0;
	protected double side2;
	private String key;

	public Rectangle(){
		this(1.0, 1.0);
	}

	public Rectangle(double side1, double side2) {
		super(side1);
		this.side2 = side2;
		if(this.getClass().equals(Rectangle.class)) {
			num_R++;
			key = "R" + num_R;
		}
	}

	public double getSide2() {
		return side2;
	}

	private void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public static int getNum() {
		return num_R;
	}
	
	public String getKey() {
		return key;
	}

	public double findArea() {
		return side1*side2;
	}

	public double findPerimeter() {
		return 2*side1 + 2*side2;
	}

	public boolean equals(Object obj) { 
		if(this == obj) 
			return true; 
		if(obj == null || obj.getClass()!= this.getClass()) 
			return false; 

		Rectangle regi = (Rectangle) obj; 

		return (regi.side1 == this.side1 && regi.side2 == this.side2); 
	} 

	public String toString() { 
		return "Length = " + this.side1 + "\nWidth = " + this.side2;
	}
}
