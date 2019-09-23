import java.io.*;
import java.util.ArrayList;

public class Driver {
	private static ArrayList<Quadrilateral> aria = new ArrayList<Quadrilateral>();
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		Driver dave = new Driver();

		dave.greeting();
		dave.menu();
		dave.farewell();
	}

	private void greeting() {
		System.out.println("Welcome to the Quadrilateral Factory!!! Here, we make an assortment of 4-sided shapes!!");
	}

	private void menu() {
		boolean exit = false, answer;
		String tag = "", key = "";
		int option, num = -1;

		while(!exit){
			System.out.print("What would you like to do? <Enter the # associated with the option>\n(1) Create a shape\n(2) View individual shapes\n(3) Get 'Quadrilateral' statistics\n(4) Exit\nANSWER: ");
			do {
				option = intput();
				if(option > 4)
					System.out.println("Hmmm, not a valid option.. --> ");
			} while(option > 4);
			switch(option) {
				case 1:
					if(aria.size() == 20) {
						System.out.println("Sorry, the quadilateral factory has reached max capacity. (MAX: 20)");
						break;
					}
					aria.add(creation());
					System.out.println("Tag of shape: " + aria.get(aria.size() - 1).getKey());
					break;

				case 2:
					if(aria == null || aria.size() == 0) 
						System.out.println("\nSorry, no shapes in the catalouge...");
					else {
						do{
							do {
								if(key.equals("")) {
									do {
										key = "";
										System.out.print("\nWhich shape would you like to access? <Enter the tag number> ");
										tag = stringput();
										for(int i = 0; i < aria.size(); i++) {
											if(tag.equals(aria.get(i).getKey().toLowerCase())) {
												num = i;
												key = aria.get(i).getKey();
												break;
											}
										}
										if(key.equals(""))
											System.out.println("Sorry, that tag has no shape associated...");
									} while(key.equals(""));
								}
								System.out.println("\nWhat would you like to know about Shape " + tag +"?");
								System.out.print("(1) Basic Properties\n(2) Area\n(3) Perimeter\n(4) Nevermind... Nothing...\nANSWER: ");
								do {
									option = intput();
									if(option > 4)
										System.out.println("Hmmm, not a valid option.. --> ");
								} while(option > 4);

								if(aria.get(num).getClass() == Square.class)
									System.out.println("\nSQUARE");
								if(aria.get(num).getClass() == Rectangle.class)
									System.out.println("\nRECTANGLE");
								if(aria.get(num).getClass() == Parallelogram.class)
									System.out.println("\nPARALLELOGRAM");
								if(aria.get(num).getClass() == Rhombus.class)
									System.out.println("\nRHOMBUS");
								if(aria.get(num).getClass() == Trapezoid.class)
									System.out.println("\nTRAPEZOID");
								if(aria.get(num).getClass() == Kite.class)
									System.out.println("\nKITE");

								if(option == 1)
									System.out.println(aria.get(num).toString());
								else if (option == 2)
									System.out.println("AREA: " + aria.get(num).findArea());
								else if (option == 3)
									System.out.println("PERIMETER: " + aria.get(num).findPerimeter());
								else if (option == 4) {
									System.out.println("Okay...");
									break;
								}
								System.out.print("\nWhat else would you like to do?");
							}while(!exit);
							System.out.print("\nWould you like to view another shape? <Yes/No> ");
							answer = answer();
							if(answer)
								key = "";
						}while(answer);
					}
					break;

				case 3:
					if(Quadrilateral.getNum() <= 0)
						System.out.println("\nCurrently, there are no quadrilaterals. Therefore, there is nothing to report on.");
					else {
						System.out.println("\nQUADRILATERALS: " + Quadrilateral.getNum());
						System.out.println("SQUARE: " + Square.getNum());
						System.out.println("RECTANGLE: " + Rectangle.getNum());
						System.out.println("PARALLELOGRAM: " + Parallelogram.getNum());
						System.out.println("RHOMBUS: " + Rhombus.getNum());
						System.out.println("TRAPEZOID: " + Trapezoid.getNum());
						System.out.println("KITE: " + Kite.getNum());
					}
					break;
				
				case 4:
					exit = true;
					break;
					
				default:
					System.out.println("Hmmmmm..... Something went wrong.......");
					break;
			}
			System.out.println();
		}
	}

	private void shapeMenu() {
		System.out.println("\nFour-sided Shapes Allowed:\n(1) Squares\n(2) Rectangles\n(3) Parallelograms\n(4) Rhombuses\n(5) Trapezoids\n(6) Kites");
	}

	private String stringput() {
		Boolean key = true;
		String s = "";

		while(key){
			try {
				s = br.readLine().toLowerCase().replaceAll("\\s+","");
				key = false;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return s;
	}

	private double doubleput() {
		double d = -1;
		boolean key = true;

		while(key){
			try {
				d = Double.parseDouble(br.readLine());
				key = (d < 0);
				if(key)
					System.out.print("Interesting, but no negative dimensions please. --> ");
			}
			catch(Exception e) {
				System.out.print("Sorry, not valid input --> ");
			}
		}
		return d;
	} 

	private int intput() {
		int i = -1;
		boolean key = true;

		while(key){
			try {
				i = Integer.parseInt(br.readLine());
				key = (i < 1 || i > 7);
				if(key)
					System.out.print("Not a valid menu option --> ");
			}
			catch(Exception e) {
				System.out.print("Sorry, not valid input --> ");
			}
		}
		return i;
	}

	private Quadrilateral creation() {
		Boolean property;

		shapeMenu();
		System.out.print("Would you like the shape to be customized (Default: unit shape [parameters: 1.0])? <Yes/No> ");
		property = answer();
		System.out.print("Please enter what you would like to make (# associated to option): ");
		switch(intput()) {
			case 1:
				return createSquare(property);

			case 2:
				return createRectangle(property);

			case 3:
				return createParallelogram(property);

			case 4:
				return createRhombus(property);

			case 5:
				return createTrapezoid(property);

			case 6:
				return createKite(property);

			default:
				System.out.println("Hmmmmm..... Something went wrong.......");
				return null;
		}
	}

	private Square createSquare(boolean property) {
		Square s;
		if(property) {
			System.out.print("Please enter the side length: ");
			s = new Square(doubleput());
		}
		else
			s = new Square();
		return s;
	}

	private Rectangle createRectangle(boolean property) {
		Rectangle r;

		double width, length;

		if(property) {
			System.out.print("Please enter the width: ");
			width = doubleput();
			System.out.print("Please enter the length: ");
			length = doubleput();
			r = new Rectangle(width, length);
		}
		else
			r = new Rectangle();
		return r;
	}

	private Parallelogram createParallelogram(boolean property) {
		Parallelogram p;

		double width, length, height;

		if(property) {
			System.out.print("Please enter the width: ");
			width = doubleput();
			System.out.print("Please enter the length: ");
			length = doubleput();
			System.out.print("Please enter the height: ");
			height = doubleput();
			p = new Parallelogram(width, length, height);
		}
		else
			p = new Parallelogram();
		return p;
	}

	private Rhombus createRhombus(boolean property) {
		Rhombus r;

		double side, height;

		if(property) {
			System.out.print("Please enter the side length: ");
			side = doubleput();
			System.out.print("Please enter the height: ");
			height = doubleput();
			r = new Rhombus(side, height);
		}
		else
			r = new Rhombus();
		return r;
	}

	private Trapezoid createTrapezoid(boolean property) {
		Trapezoid t;

		double base1, base2, side3, side4, height;

		if(property) {
			System.out.print("Please enter the first base length: ");
			base1 = doubleput();
			System.out.print("Please enter the second base length: ");
			base2 = doubleput();
			System.out.print("Please enter the third side length: ");
			side3 = doubleput();
			System.out.print("Please enter the fourth side length: ");
			side4 = doubleput();
			System.out.print("Please enter the height: ");
			height = doubleput();
			t = new Trapezoid(base1, base2, side3, side4, height);
		}
		else
			t = new Trapezoid();
		return t;
	}

	private Kite createKite(boolean property) {
		Kite k;

		double side1, side2, diagonal1, diagonal2;

		if(property) {
			System.out.print("Please enter the first side length: ");
			side1 = doubleput();
			System.out.print("Please enter the second side length: ");
			side2 = doubleput();
			System.out.print("Please enter the first diagonal length: ");
			diagonal1 = doubleput();
			System.out.print("Please enter the second diagonal length: ");
			diagonal2 = doubleput();
			k = new Kite(side1, side2, diagonal1, diagonal2);
		}
		else
			k = new Kite();
		return k;
	}

	private boolean answer() {
		Boolean retry;
		String answer;
		
		do{
			answer = stringput();
			retry = !(answer.equals("yes") || answer.equals("no"));
			if(retry)
				System.out.print("Sorry, that's not an appropriate answer... <Yes/No> --> ");
			else
				return answer.equals("yes");
		}while(retry);
		return false;
	}

	private void farewell() {
		System.out.println("Thanks for coming!! Don't forget, you'll always be the #1 VIP member at the 'Quadrilateral Factory'!!!!");
	}
}
