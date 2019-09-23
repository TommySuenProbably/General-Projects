public class Parallelogram extends Rectangle{
	private static int num_P = 0;
	protected double height;
	private String key;

	public Parallelogram(){
		this(1.0, 1.0, 1.0);
	}

	public Parallelogram(double side1, double side2, double height) {
		super(side1, side2);
		this.height = height;
		if(this.getClass().equals(Parallelogram.class)) {
			num_P++;
			key = "P" + num_P;
		}
	}

	public double getHeight() {
		return height;
	}

	private void setSide2(double height) {
		this.height= height;
	}
	
	public static int getNum() {
		return num_P;
	}
	
	public String getKey() {
		return key;
	}

	public double findArea() {
		return side1*height;
	}

	public double findPerimeter() {
		return 2*side1 + 2*side2;
	}

	public boolean equals(Object o) {
		if(o instanceof Parallelogram) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 

		}
		return false;
	}

	public String toString() { 
		return "Length = " + this.side1 + "\nWidth = " + this.side2 + "\nHeight = " + this.height;
	}
}
