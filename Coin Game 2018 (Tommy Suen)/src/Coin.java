/* ===========================================================================
 * "The (Absolutely Amazing) Coin Game"
 * BY: Tommy Suen
 * Date: 25/10/2018
 * Java, Eclipse Photon
 * ===========================================================================
 * P (Problem):
 * This program solves the 'coin game' by finding the # of ways the winner can
 * win. Essentially, there are two players and a set # of coins. This game is 
 * turn-based. Every turn, a player may take 1, 2, or 4 coins. Whoever gets 
 * the last coin wins.
 * 
 * e.g. Player 1: 'ALICE' & Player 2: 'BOB' & # of Coins: 3
 * 		
 * 		ALICE takes 1 coin. BOB takes 2. BOB wins.
 * 		ALICE takes 2 coins. BOB takes 1. BOB wins.
 * 
 * Therefore, Bob has 2 ways of winning.
 * ---------------------------------------------------------------------------
 * I (Input):
 * 
 * answer - (String) input variable to hold general input to proposed ?s
 * player1 - (String) input variable for the name of the first player
 * player2 - (String) input variable for the name of the second player
 * game_coins - (integer) input variable for number of coins (0 < x <= 30)
 * ---------------------------------------------------------------------------
 * O (Output):
 * 
 * Whenever an object of class "Game" is created, the method, "description", 
 * will output a description of the game as detailed above. After confirming
 * the user's comprehension, the program prompts the user for player and coin
 * information. If the input is invalid, the corresponding responses will be 
 * output until the information becomes usable. When the input is valid, the
 * program will calculate and output the results and the winner. Then, it 
 * will ask whether the user wishes to try again. If input is not "exit or 
 * "no", the program will output another prompt for player and coin info and 
 * result and ask again whether the user wishes to continue. If not, the 
 * program will output a farewell message.
 * 
 * 1) Description (method) when object is created 
 * 2) Ask for player and coin info
 * 		a. Error messages for invalid input
 * 3) Results
 * 4) Ask permission to continue
 * 		a. "exit" OR "no" - farewell message
 * 		b. else, go back to 2)
 * ---------------------------------------------------------------------------
 * P (Process):
 * 
 * "wins" method of class "Game" ***See method for more details***
 * I) If the # of coins is less than zero, return a lose 
 * 		a. To catch any negatives that manage to get through
 * II) If the coins are (0 - 2) OR (0 <= x < 3), return a win 
 * 		a. (4) also, but it is included in another case
 * 
 * ***The following was created on the basis that whichever gets (3) coins 
 * will lose since there is no option to win. Smart players will try to keep 
 * the # of coins as product of (3) on the opponent's turn to win.******
 * 
 * III) If the # of coins mod (3) is (1), which is (4) or (a product of (3) + 
 * 		1), to play smart there are two options;
 * 		a. the player will take one coin OR
 * 		b. the player will take four coins...
 * 		...so that # of coins becomes a product of (3).
 * IV) If the # of coins mod (3) is (2), which is (a product of (3) + 2), the 
 * 	   player will take two coins so that the # of coins is a product of (3).
 * Else) Create recursive calls/branches where the player takes 1, 2 or 4 
 * 		 coins and play out the paths.
 * 
 * Return the # of win strategies. The winner will be Player 1 if the # of 
 * coins mod (3) is (2) because the the first player can take the advantage. 
 * Otherwise, Player 2 will play smart and control the game.
 * ===========================================================================
 */ 

// ***************************************************************************
// "Coin" Class
// BY: Tommy Suen
// Date: 25/10/2018
// Java, Eclipse Photon
// ***************************************************************************
// <Class>
// This class is a layout and structure  of "The (Absolutely Amazing) Coin 
// Game." Specific details can found in the method comments.
// ***************************************************************************
public class Coin {	
	/**"main" method:
	 * This procedural method is called automatically and is used to organize 
	 * the calling of other methods defined in the "Coin" class.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param args <type String>
	 * @throws none
	 * @return void
	 */
	public static void main(String[] args) {
		Coin bag = new Coin();
		
		bag.gameplay();
	} //End of "main" method
	
	/**"gameplay" method:
	 * This procedural method is a layout of the sequence of the game. In this
	 * method, permission is given to play the game and modify values locally,
	 * as explained below. The do while loop puts the user through the game 
	 * and continues for further iteration depending on their reply. In the
	 * loop, the user inputs player and coin information. After, the info is 
	 * processed and the results are printed. The program prompts the user on 
	 * whether they wish to continue; if "no" or "exit", a farewell message is
	 * displayed; else, the user will input new information.
	 * 
	 * List of Local Variables:
	 * "ticket" - object of class "Game" that allows access its methods. 
	 * Nested method is a mutator; it allows the program to locally call this 
	 * version of the method and modify values. Otherwise, the original method 
	 * will deny access to mutate private values.
	 * "answer" - (String) input variable for general input from user
	 * 
	 * @param none
	 * @throws none	
	 * @return void
	 */
	private void gameplay() {
		Game ticket = new Game() {
			protected void setInfo() {
				player1 = getPlayer(1);
				player2 = getPlayer(2);
				game_coins = getCoins();
			}
		};
				
		String answer;
		
		do{
			ticket.setInfo();
			ticket.result(ticket.getWins(), ticket.winner());
			answer = ticket.answer().replaceAll("\\s+","");
			System.out.println();
		}while(!answer.equalsIgnoreCase("exit") && !answer.equalsIgnoreCase("no"));
		ticket.farewell();
	} //End "gameplay"
} //End "Coin"
