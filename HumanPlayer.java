//Author name: Yash Jain

/**
 * The class <b>HumanPlayer</b> is the class that controls the human's plays.
 * 
 * 
 */

import java.util.*;

public class HumanPlayer implements Player {
	//read a position to play from the console and call 
	// game.play(position): if the level was advanced after the call, then finish, otherwise repeat and get another position

	public void play (TicTacToeGame game) {

		Scanner sc = new Scanner(System.in);

		boolean checker = true;
		
		while (checker) {
			System.out.println(game);
			int playerChoice = sc.nextInt();

			if (playerChoice < 1 || playerChoice > game.getLines()*game.getColumns()) { System.out.println("Invalid cell value. The values must be between 1 and " + game.getLines()*game.getColumns()); }

			else if (game.valueAt(playerChoice - 1) != CellValue.EMPTY) { System.out.println("This cell has already been played.");}

			else { game.play(playerChoice - 1); checker = false; }
		}
	}
}