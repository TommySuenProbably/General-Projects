class Rectangle extends Square{
	protected double side2;

	Rectangle(){
		this(1.0, 1.0);
	}

	Rectangle(double side1, double side2) {
		super(side1);
		this.side2 = side2;
	}

	private double getSide2() {
		return side2;
	}

	private void setSide2(double side2) {
		this.side2 = side2;
	}

	double findArea() {
		return side1*side2;
	}

	double findPerimeter() {
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
