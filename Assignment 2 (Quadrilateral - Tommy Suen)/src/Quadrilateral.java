public abstract class Quadrilateral {
	private static int num_Q = 0;
	
	public Quadrilateral(){
		num_Q++;
	}
	
	public static int getnumQ() {
		return num_Q;
	}
	
	public static int getNum() {
		return num_Q;
	}
	
	abstract public double findArea();
	abstract public double findPerimeter();
	abstract String getKey();
}

