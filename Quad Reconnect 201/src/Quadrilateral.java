abstract class Quadrilateral {
	private static int numQ = 0;
	
	Quadrilateral(){
		numQ++;
	}
	
	public static int getnumQ() {
		return numQ;
	}
	
	abstract double findArea();
	abstract double findPerimeter();
}

