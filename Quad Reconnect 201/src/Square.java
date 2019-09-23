class Square extends Quadrilateral{
	protected double side1;
	
	Square(){
		this(1.0);
	}
	
	Square(double side1) {
		super();
		this.side1 = side1;
	}
	
	private double getSide1() {
		return side1;
	}
	
	private void setSide1(double side1) {
		this.side1 = side1;
	}
	
	double findArea() {
		return Math.pow(side1, 2);
	}
	
	double findPerimeter() {
		return 4*side1;
	}
	
	public boolean equals(Object obj) 
	{ 
		if(this == obj) 
			return true; 
		if(obj == null || obj.getClass()!= this.getClass()) 
			return false; 

		Square squirt = (Square) obj; 

		return (squirt.side1 == this.side1); 
	} 
	
	public String toString() { 
		return "Side = " + this.side1;
	}
}