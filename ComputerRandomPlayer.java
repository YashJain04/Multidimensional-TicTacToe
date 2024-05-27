//Author name: Yash Jain

/**
 * The class <b>ComputerRandomPlayer</b> is the class that controls the computer's plays.
 * 
 * 
 */

import java.util.*;

public class ComputerRandomPlayer implements Player {
	//generate random position at an empty cell!!
	//call game.play(position)

	public void play (TicTacToeGame game) {

		boolean checker = true;

		while (checker) {
			Random rand = new Random();

			int maxValue = game.getLines() * game.getColumns();
			int computerChoice = rand.nextInt(maxValue); //Generate values from 0 - # of cells

			if (game.valueAt(computerChoice) == CellValue.EMPTY) { game.play(computerChoice); checker = false; }
		}
	}
}

//Method #2 Using Array... Check Out For Future Assignment
// TicTacToeGame game;
// 	int boardSize = game.getLines() * game.getColumns();
// 	int [] emptyCells = new int [game.getLines() * game.getColumns()];
// 	int [] copyEmptyCells = new int [(game.getLines() * game.getColumns()) - 1];
// 	int counter = 0;

// 	for (int i = 0; i < boardSize; i++) {
// 		if (game.valueAt(i) == CellValue.EMPTY) { emptyCells[counter] = i; counter ++; }
// 	}

// 	Random generator = new Random();
// 	int computerCall;
// 	int computerChoice;
	
// 	while (copyEmptyCells.length != 0) {

// 		for (int i = 0; i < boardSize; i++) {
// 			if (game.valueAt(i) == CellValue.EMPTY) { emptyCells[counter] = i; counter ++; }
// 		}

// 		computerCall = generator.nextInt(emptyCells.length);
// 		computerChoice = emptyCells[computerCall]; 

// 		// now go to the game board and place the "X" or "O" at index computerChoice on the board
// 		// once thats done...



// 	}


// 	}