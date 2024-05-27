//Author name: Yash Jain

/*
 * The class <b>TicTacToeGame</b> is the class that implements the Tic Tac Toe
 * Game. It contains the grid and tracks its progress. It automatically maintain
 * the current state of the game as players are making moves.
 *
 * 
*/
public class TicTacToeGame {
	//The board of the game, stored as a one dimension array.
	private CellValue[] board;
	private CellValue[][] matrix;

	//level records the number of rounds that have been played so far.
	private int level;

	//gameState records the current state of the game
	private GameState gameState;

	//lines is the number of lines in the grid
	private int lines;

	//columns is the number of columns in the grid
	private int columns;

	//sizeWin is the number of cell of the same type that must be aligned to win the game
	private int sizeWin;

	//default constructor, for a game of 3x3, which must align 3 cells
	//Your code here
	public TicTacToeGame() {
		this.lines = 3;
		this.columns = 3;
		this.sizeWin = 3;

		this.level = 0;
		this.gameState = GameState.PLAYING;

		this.board = new CellValue [this.lines * this.columns];
		for (int i = 0; i < this.board.length; i++) { this.board[i] = CellValue.EMPTY; }
	}

	/**
	 * constructor allowing to specify the number of lines and the number of columns
	 * for the game. 3 cells must be aligned.
	 * 
	 * @param lines   the number of lines in the game
	 * @param columns the number of columns in the game
	 */
	public TicTacToeGame(int lines, int columns) {
		// Your Code Here

		this.lines = lines;
		this.columns = columns;
		this.sizeWin = 3;

		this.level = 0;
		this.gameState = GameState.PLAYING;

		this.board = new CellValue [this.lines * this.columns];
		for (int i = 0; i < this.board.length; i++) { this.board[i] = CellValue.EMPTY; }
	}

	/**
	 * constructor allowing to specify the number of lines and the number of columns
	 * for the game, as well as the number of cells that must be aligned to win.
	 * 
	 * @param lines   the number of lines in the game
	 * @param columns the number of columns in the game
	 * @param sizeWin the number of cells that must be aligned to win.
	 */
	public TicTacToeGame(int lines, int columns, int sizeWin) {
		this.lines = lines;
		this.columns = columns;
		this.sizeWin = sizeWin;

		this.level = 0;
		this.gameState = GameState.PLAYING;

		this.board = new CellValue [this.lines * this.columns];
		for (int i = 0; i < this.board.length; i++) { this.board[i] = CellValue.EMPTY; }
	}


	/**
	 * getter for the variable lines
	 * 
	 * @return the value of lines
	*/ 

	//Your code here
	public int getLines() { return this.lines; }

	/**
	 * getter for the variable columns
	 * 
	 * @return the value of columns
	*/

	//Your code here
	public int getColumns() { return this.columns; }

	/**
	 * getter for the variable level
	 * 
	 * @return the value of level
	*/

	//Your code here
	public int getLevel() { return this.level; }

	/**
	 * getter for the variable sizeWin
	 * 
	 * @return the value of sizeWin
	*/

	//Your code here
	public int getSizeWin() { return this.sizeWin; }

	/**
	 * getter for the variable gameState
	 * 
	 * @return the value of gameState
	*/

	//Your code here
	public GameState getGameState() { return this.gameState; }

	/**
	 * returns the cellValue that is expected next, in other word, which player (X
	 * or O) should play next. This method does not modify the state of the game.
	 * 
	 * @return the value of the enum CellValue corresponding to the next expected
	 *         value.
	*/

	//Your code here
	public CellValue nextCellValue() { if (this.level % 2 == 0) { return CellValue.X; } return CellValue.O; }

	/**
	 * returns the value of the cell at index i. If the index is invalid, an error
	 * message is printed out. The behavior is then unspecified
	 * 
	 * @param i the index of the cell in the array board
	 * @return the value at index i in the variable board.
	*/

	//Your code here
	public CellValue valueAt(int i) {
		if (i > this.board.length || i < 0) { System.out.println("Invalid Cell Value..."); }

		else if (this.board[i] == CellValue.X) { return CellValue.X; }

		else if (this.board[i] == CellValue.O) { return CellValue.O; }

		return CellValue.EMPTY;
	}

   	/*
	 * This method is called by the next player to play at the cell  at index i.
	 * If the index is invalid, an error message is printed out. The behaviour is then unspecified
	 * If the chosen cell is not empty, an error message is printed out. The behaviour is then unspecified
	 * If the move is valide, the board is updated, as well as the state of the game.
	 * To faciliate testing, it is acceptable to keep playing after a game is already won. 
	 * If that is the case, the a message should be printed out and the move recorded. 
	 * The winner of the game is the player who won first
	 * @param i
	 *  the index of the cell in the array board that has been selected by the next player
  	*/

	//Your code here
	public void play(int i) {
		if (valueAt(i) != CellValue.EMPTY) { System.out.println("Cell value is not empty:" + i); }
		else { this.board[i] = nextCellValue(); level++; if (gameState == GameState.PLAYING) { setGameState(i); } }
	}

   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set.
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (the the game was playing). Therefore, it only needs to
	* check if playing at index i has concluded the game
	****************************** 
	*So check if the required number of sizeWin cells are formed to win.
	******************************
    *  the index of the cell in the array board that has just
    * been set
  	*/


	//Your code here
	private void setGameState(int index){	
		matrix = new CellValue [this.lines][this.columns];

		for (int i = 0; i < this.lines; i++) { for (int j = 0; j < this.columns; j++) { matrix[i][j] = this.board[i * this.columns + j]; } }

		for (int i = 0; i < this.lines; i++) {
			for (int j = 0; j < this.columns; j++) {
				if (matrix[i][j] != CellValue.EMPTY) {
					checkWinner1(i, j, true); //row
					checkWinner1(i, j, false); //column
					checkWinner2(i, j, true); //diagonal 1
					checkWinner2(i, j, false); //diagonal 2
				}
			}
		}

		if (!(gameState == GameState.XWIN) || (gameState == GameState.OWIN)) { if (level == this.lines*this.columns) { gameState = GameState.DRAW; } }
	}

	void checkWinner1(int row, int col, boolean value) {
		boolean winner = false;
		int variable = sizeWin - 1; //check the amount of cells
		int counter = 0;

		if (value) {
			for (int i = 1; i < sizeWin; i++) { if (col + variable < this.columns && matrix[row][col] == matrix[row][col + i]) { counter += 1; if (counter == variable) break; } }
			if (counter == variable) winner = true;
		}

		else {
			for (int i = 1; i < sizeWin; i++) { if (row + variable < this.lines && matrix[row][col] == matrix[row + i][col]) { counter += 1; if (counter == variable) break; } }
			if (counter == variable) winner = true;
		}

		if (winner) {
			if (board[row*this.columns + col] == CellValue.X) { gameState = GameState.XWIN; }
			else if (board[row*this.columns + col] == CellValue.O) { gameState = GameState.OWIN; }
		}
	}

	void checkWinner2(int row, int col, boolean value) {

		boolean winner = false;
		int variable = sizeWin - 1; //check the amount of cells
		int counter = 0;

		if (value) {
			for (int i = 1; i < sizeWin; i++) { if (col + variable < this.columns && row + variable < this.lines && matrix[row][col] == matrix[row + i][col + i]) { counter += 1; if (counter == variable) break; } }
			if (counter == variable) winner = true;
		}

		else {
			for (int i = 1; i < sizeWin; i++) { if (col - variable >= 0 && row + variable < this.lines && matrix[row][col] == matrix[row + i][col - i]) { counter += 1; if (counter == variable) break; } }
			if (counter == variable) winner = true;
		}

		if (winner) {
			if (board[row * columns + col] == CellValue.X) { gameState = GameState.XWIN; }
			else if (board[row * columns + col] == CellValue.O) { gameState = GameState.OWIN; }
		}
	}

	final String NEW_LINE = System.getProperty("line.separator");
	// returns the OS dependent line separator

   /**
	 * Returns a String representation of the game matching
	 * the example provided in the assignment's description
	 *
   	 * @return
     *  String representation of the game
  	*/

	public String toString(){
        // your code here
        // use NEW_LINE defined above rather than \n
        
        String s = "";

        matrix = new CellValue[lines][columns];
        int c = 0;
        for (int i = 0; i < lines; i++) { for (int j = 0; j < columns; j++) { matrix[i][j] = board[c]; c += 1; } }

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (j != columns - 1) { s += " " + (matrix[i][j].name() == "EMPTY" ? " " : matrix[i][j].name()) + " |"; }
                else { s += " " + (matrix[i][j].name() == "EMPTY" ? " " : matrix[i][j].name()); }
            }

            if (i != lines - 1) { s += NEW_LINE; for (int x = 0; x < columns * 3 + columns - 1; x++) { s += "-"; } s += NEW_LINE; }
        }
        return s + NEW_LINE;
    }
}	