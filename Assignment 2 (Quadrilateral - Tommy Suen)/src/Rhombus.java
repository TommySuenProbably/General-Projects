public class Rhombus extends Square{
	private static int num_Rh = 0;
	private double height;
	private String key;

	public Rhombus(){
		this(1.0, 1.0);
	}

	public Rhombus(double side1, double height) {
		super(side1);
		this.height = height;
		if(this.getClass().equals(Rhombus.class)) {
			num_Rh++;
			key = "Rh" + num_Rh;
		}
	}

	public double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height = height;
	}
	
	public static int getNum() {
		return num_Rh;
	}
	
	public String getKey() {
		return key;
	}

	public double findArea() {
		return side1*height;
	}

	public double findPerimeter() {
		return 4*side1;
	}

	public boolean equals(Object o) {
		if(o instanceof Rhombus) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

		}
		return false;
	}

	public String toString() { 
		return "Side = " + this.side1 + "\nHeight = " + this.height;
	}
}