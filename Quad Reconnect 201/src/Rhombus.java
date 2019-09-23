class Rhombus extends Square{
	private double height;

	Rhombus(){
		super();
		height = 1.0;
	}

	Rhombus(double side1, double height) {
		super(side1);
		this.height = height;
	}

	private double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height = height;
	}

	double findArea() {
		return side1*height;
	}

	double findPerimeter() {
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