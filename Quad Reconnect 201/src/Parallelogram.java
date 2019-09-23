class Parallelogram extends Rectangle{
	protected double height;

	Parallelogram(){
		this(1.0, 1.0, 1.0);
	}

	Parallelogram(double side1, double side2, double height) {
		super(side1, side2);
		this.height = height;
	}

	private double getHeight() {
		return height;
	}

	private void setSide2(double height) {
		this.height= height;
	}

	double findArea() {
		return side1*height;
	}

	double findPerimeter() {
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
