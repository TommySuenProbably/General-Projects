// ***************************************************************************
// "Game" Class
// BY: Tommy Suen
// Date: 25/10/2018
// Java, Eclipse Photon
// ***************************************************************************
// <Class>
// This subclass holds the calculations, mechanics and results of the actual 
// game. The constructor is set to always start with the game description. The 
// main bulk is accessor methods that allow private information and 
// calculations, with a mechanic method that actually computes the number of 
// wins (see description of mechanic in method commenting).
//
// <List Of Identifiers>
// Let "game_coins" = (integer) variable to store the number of coins
// Let "player1" = (String) variable to hold the name of the first player
// Let "player2" = (String) variable to hold the name of the second player
// ***************************************************************************
class Game extends Information{
	protected int game_coins;
	protected String player1, player2;
	
    /** Default Constructor method prints out the description method from 
     * superclass "Information" every time an object of class "Game" is 
     * created.
     */
	protected Game() {
		description();
	} //End of "Game" (default constructor)
	
	/**"setInfo" method:
	 * This procedural method is the original copy. If anything tries to call 
	 * the accessor version, the default will be this method. It tells the 
	 * user their request to change the information has been denied.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws none
	 * @return void
	 */
	protected void setInfo() {
		System.out.println("Sorry, level of authoriztion is too low.");
	} //End of "setInfo" method
	
	/**"coin_number" method:
	 * This functional accessor method returns the private value of 
	 * "game_coins," which is otherwise inaccessible.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws none
	 * @return integer
	 */
	protected int coin_number(){
		return game_coins;
	} //End of "coin_number" method
	
	/**"wins" method:
	 * This functional method returns the # of ways the winner will win. It 
	 * is based on the main principle of mod (3). Whoever gets (3) coins or
	 * a product will lose since there is no option to win. If there are (3)
	 * coins, the player can only take one or two coins. No matter what, the 
	 * the other will be able to win based on the decision since the other 
	 * cannot take three and must yield the last coin. If the # of coins is 
	 * a product of (3), smart players will keep the # of coins such. No
	 * matter what the opponent does, take 1, 2 or 4 coins, the smart player 
	 * will be able to counter and keep it as a product of (3). If so on the
	 * opponent's turn, the main player wins.
	 * 
	 * Here the possible outcomes and how to handle them: 
	 * ***win = (+1), loss = (0)***
	 * I) If the # of coins is less than zero, return a lose 
	 * 		a. To catch any negatives that manage to get through
	 * II) If the coins are (0 - 2) OR (0 <= x < 3), return a win 
	 * 		a. (4) also, but it is included in another case
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
	 * Return the # of win strategies.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param "coins" (integer)
	 * @throws none
	 * @return integer
	 */
	private int wins(int coins) {
		if(coins < 0)
			return 0;
		else if(coins < 3 && coins >= 0)
			return 1;
		else if (coins % 3 == 1)
			return wins(coins - 1) + wins(coins - 4);
		else if (coins % 3 == 2)
			return wins(coins - 2);
		return wins(coins - 4) + wins(coins - 2) + wins(coins - 1);
	} //End of "wins" method
	
	/**"winner" method:
	 * This functional method returns the name of the winner. The winner is 
	 * determined based on the main principle of mod 3. If the # of coins mod
	 * (3) is two, Player 1 will have the ability to control the game and must 
	 * win. Otherwise, Player 2 is given the initiative and win so long as he 
	 * plays smart, which he has to.
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws none
	 * @return String
	 */
	protected String winner() {
		return (game_coins % 3 == 2) ? player1 : player2;
	} //End of "winner" method
	
	/**"getWins" method:
	 * This functional accessor method returns the result of the "wins" method
	 * , which is a private method that holds the secret formula to obtain the 
	 * number of wins, which also accesses a private variable, "game_coins."
	 * 
	 * List of Local Variables: None
	 * 
	 * @param none
	 * @throws none
	 * @return integer
	 */
	protected int getWins() {
		return wins(game_coins);
	} //End of "getWins" method
} //End of "Game" class
