public class Square extends Quadrilateral{
	private static int num_S = 0;
	protected double side1;
	private String key;
	
	public Square(){
		this(1.0);
	}
	
	public Square(double side1) {
		super();
		this.side1 = side1;
		if(this.getClass().equals(Square.class)) {
			num_S++;
			key = "S" + num_S;
		}
	}
	
	public double getSide1() {
		return side1;
	}
	
	private void setSide1(double side1) {
		this.side1 = side1;
	}
	
	public static int getNum() {
		return num_S;
	}
	
	public String getKey() {
		return key;
	}
	
	public double findArea() {
		return Math.pow(side1, 2);
	}
	
	public double findPerimeter() {
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