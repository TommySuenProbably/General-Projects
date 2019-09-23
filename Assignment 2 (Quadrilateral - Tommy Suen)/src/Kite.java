public class Kite extends Square{
	private static int num_K = 0;
	private double side2;
	private double diagonal1;
	private double diagonal2;
	private String key;

	public Kite(){
		this(1.0, 1.0, 1.0, 1.0);
	}

	public Kite(double side1, double side2, double diagonal1, double diagonal2) {
		super(side1);
		this.side2 = side2;
		this.diagonal1 = diagonal1;
		this.diagonal2 = diagonal2;
		if(this.getClass().equals(Kite.class)) {
			num_K++;
			key = "K" + num_K;
		}
	}

	public double getSide2() {
		return side2;
	}

	private void setSide2(double side2) {
		this.side2 = side2;
	}
	
	public double getDiagonal1() {
		return diagonal1;
	}
	
	private void setDiagonal1(double diagonal1) {
		this.diagonal1 = diagonal1;
	}
	
	public double getDiagonal2() {
		return diagonal2;
	}
	
	private void setDiagonal2(double diagonal2) {
		this.diagonal2 = diagonal2;
	}
	
	public static int getNum() {
		return num_K;
	}
	
	public String getKey() {
		return key;
	}

	public double findArea() {
		return diagonal1*diagonal2;
	}

	public double findPerimeter() {
		return 2*side1 + 2*side2; 
	}

	public boolean equals(Object obj) { 
		if(this == obj) 
			return true; 
		if(obj == null || obj.getClass()!= this.getClass()) 
			return false; 

		Kite k = (Kite) obj; 

		return (k.side1 == this.side1 && k.side2 == this.side2 && k.diagonal1 == this.diagonal1 && k.diagonal2 == this.diagonal2); 
	} 

	public String toString() { 
		return "First Side = " + side1 + "\nSecond Side = " + side2 + "\nFirst Diagonal = " + this.diagonal1 + "\nSecond diagonal = " + this.diagonal2;
	}
}
