// ***************************************************************************
// "Information" Class
// BY: Tommy Suen
// Date: 25/10/2018
// Java, Eclipse Photon
// ***************************************************************************
// <Class>
// This class is the superclass that deals with all information. The "Game" 
// subclass deals with specific information pertaining the game calculations,
// however, this class holds information such as the description, greeting and 
// farewell messages and general processing of any input. This deals with 
// exceptions, responses and general information.
//
// <List Of Identifiers>
// Let "br" = object of class "BufferedReader" to access its methods
// ***************************************************************************

import java.io.*;
import java.util.concurrent.TimeUnit;

class Information {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	/**"description" method:
	 * This procedural method outputs the rules of "The (Absolutely Amazing) 
	 * Coin Game", an example of how to play and route the wins, and 
	 * confirms whether the user understands or not. Time delays were used to 
	 * slow down the pace of the information, hence the need for the try and 
	 * catch. After the instructions, the method will prompt for answer. 
	 * Using switch-case, the method will determine and output an appropriate 
	 * response.
	 * 
	 * List of Local Variables: 
	 * "e" - (Exception) variable to catch any exception, especially time
	 * 
	 * @param none
	 * @throws "e" (Exception)
	 * @return void
	 */
	protected void description() {
		try{
			System.out.println("Welcome! This program solves the 'coin game.' Essentially, there are two players and a set # of coins.");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("This game is turn-based. Every turn, a player may take 1, 2, or 4 coins. Whoever gets the last coin wins.");
			TimeUnit.SECONDS.sleep(3);
			System.out.println("\n\te.g. Player 1: 'ALICE' & Player 2: 'BOB' & # of Coins: 3");
			System.out.println("\n\t    ALICE takes 1 coin. BOB takes 2. BOB wins.");
			System.out.println("\t    ALICE takes 2 coins. BOB takes 1. BOB wins.");
			System.out.println("\n\t    Therefore, Bob has 2 ways of winning.");
			TimeUnit.SECONDS.sleep(4);
			System.out.print("\nThis program finds the # of ways the winner... well, can win. Understand? ");
		}
		catch (Exception e) {
			System.out.println("Something's interrupted the explanation... ");
		}
		
		switch(stringput().toLowerCase().replaceAll("\\s+","")) {
			case "yeah":
			case "yes":
				System.out.print("Great! ");
				break;
				
			default:
				System.out.print("No? Too bad!! ");
		}	
	} //End of "description" method
	
	/**"getCoins" method:
	 * This functional method uses the private method "intput" to receive
	 * and process appropriate values for a # of coins. The method prompts
	 * the user to input a # of coins. If valid, "intput" will return that 
	 * value and this method will return the value to the requester.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws none
	 * @return integer
	 */
	protected int getCoins() {
		System.out.print("How many coins are in the bag? (Max: 30) ");
		return intput();
	} //End of "getCoins" method
	
	/**"intput" method:
	 * This functional method returns integer input from the user. This 
	 * method handles any integer input, namely the # of coins possible;
	 * this method will continue to ask for input until it becomes 
	 * appropriate. Appropriate values are greater than (0) and no greater
	 * than (30), the max coins possible. If input is invalid, "key" will 
	 * trigger a corresponding response to the problem. The loop will be 
	 * broken once "key" becomes false and "intput" will return "i."
	 * 
	 * List of Local Variables: 
	 * "i" - (integer) variable to hold integer values
	 * "key" - (boolean) variable to access special responses and get out 
	 * of the loop
	 * 
	 * @param none
	 * @throws "e" (Exception)
	 * @return integer
	 */
	private int intput() {
		int i = -1;
		boolean key = true;
		
		while(key){
			try {
				i = Integer.parseInt(br.readLine());
				key = (i <= 0 || i > 30);
				if(key)
					System.out.print("Not a valid coin number --> ");
			}
			catch(Exception e) {
				System.out.print("Sorry, not valid input --> ");
			}
		}
		return i;
	} //End of "intput" method
	
	/**"stringput" method:
	 * This functional method returns integer input from the user. This 
	 * This functional method returns string input from the user. There is
	 * loop in this case; if an exception occurs, the program will 
	 * immediately trace the problem back to its source and end the 
	 * program. Otherwise, it will simply return String input. "Return null"
	 * is simply insurance if the program manages to get pass the try and 
	 * catch.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws "e" (Exception)
	 * @return String
	 */
	private String stringput() {
		try {
			return br.readLine();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	} //End of "stringput" method
	
	/**"getPlayer" method:
	 * This functional method prompts the user for player information. The
	 * parameter is the number assigned to a specific player and offers 
	 * reusability. This method returns the "stringput" method, which filters
	 * all string input. If the input is appropriate, the "stringput" will 
	 * return the input and this method will return that player info to the
	 * requester.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param "i" (integer)
	 * @throws none
	 * @return String
	 */
	protected String getPlayer(int i) {
		System.out.print("What is Player " + i + "'s name? ");
		return stringput();
	} //End of "getPlayer" method
	
	/**"result" method:
	 * This procedural method prints the results. Based on parameters such 
	 * as number of wins and the name of the winner, the method will print 
	 * out the appropriate congratulations. If the number of wins is greater
	 * than one, the sentence will be pluralized.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param "numberOfWins" (integer), "winner" (String)
	 * @throws none
	 * @return void
	 */
	protected void result(int numberOfWins, String winner) {
		System.out.print("The winner is " + winner + "!!! (S)he can win in " + numberOfWins + " different way");
		if(numberOfWins > 1)
			System.out.print("s");
		System.out.println(".");
	} //End of "result" method
	
	/**"answer" method:
	 * This functional method prompts the user for an response as to whether 
	 * they wish to continue to play the game. This method returns the 
	 * "stringput" method, which handles string input. When no exception is
	 * triggered, "stringput" will return an appropriate response and this 
	 * method will return that to the requester.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws none
	 * @return String
	 */
	protected String answer() {
		System.out.print("Would you like to try again? <Type 'exit' to leave> ");
		return stringput();
	} //End of "answer" method
	
	/**"farewell" method:
	 * This procedural method simply outputs a farewell message.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws none
	 * @return void
	 */
	protected void farewell() {
		System.out.println("Thanks for coming!! Come back soon!!!!");
	} //End of "farewell" method
} //End of "Information" class
