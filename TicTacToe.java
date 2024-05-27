import java.io.Console;
import java.util.Random;
import java.util.Scanner;

//Author name: Yash Jain

/**
 * The class <b>TicTacToe</b> is the class that implements the actual Tic Tac
 * Toe game, where it
 * controls the human and computer activity and prints the result of the game at
 * the end. It also
 * asks the player if he/she wants to continue playing once this game is over.
 * 
 * 
 */

public class TicTacToe {

    /**
     * <b>main</b> of the application. Creates the instance of GameController
     * and starts the game. If two parameters line and column
     * are passed, they are used.
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *             command line parameters
     */
    public static void main(String[] args) {
        StudentInfo.display();
        
        Console console = System.console();
        TicTacToeGame game;
		
		//default values used if args are not there:
        int lines = 3;
        int columns = 3;
        int win = 3;

        //change lines, columns and win based on the args values
        if (args.length >= 2) {
            lines = Integer.parseInt(args[0]);
            if (lines < 2) { System.out.println("Invalid argument, using default..."); lines = 3; }

            columns = Integer.parseInt(args[1]);
            if (columns < 2) { System.out.println("Invalid argument, using default..."); columns = 3; }
        }

        if (args.length >= 3) {
            win = Integer.parseInt(args[2]);
            if (win < 2) { System.out.println("Invalid argument, using default..."); win = 3; }
        }

        if (args.length > 3) { System.out.println("Too many arguments. Only first 3 are used."); }

        game = new TicTacToeGame(lines, columns, win);

        HumanPlayer human = new HumanPlayer();
        ComputerRandomPlayer computer = new ComputerRandomPlayer();

        Random rand = new Random();
        int startingTurn = rand.nextInt(2);

        boolean checker = true;
        boolean checker2 = true;
        boolean checker3 = true;

        System.out.println(game);

        while (checker2) {

            while (checker) {

                if (startingTurn == 0) {
                    System.out.println("Player 1's Turn: ");
                    human.play(game);
                    if (game.getGameState() != GameState.PLAYING) { checker3 = false; break; }
                    System.out.println("Player 2's Turn: ");
                    computer.play(game);
                    if (game.getGameState() != GameState.PLAYING) { checker3 = false; break; }
                }
    
                else {
                    System.out.println("Player 2's Turn: ");
                    computer.play(game);
                    if (game.getGameState() != GameState.PLAYING) { checker3 = false; break; }
                    System.out.println("Player 1's Turn: ");
                    human.play(game);
                    if (game.getGameState() != GameState.PLAYING) { checker3 = false; break; }
                }
            }
    
            while (game.getGameState() != GameState.PLAYING && checker3 == false) {
                //ask if users wants to continune
    
                System.out.println(game);
                System.out.println("Result: " + game.getGameState());
    
                Scanner sc = new Scanner (System.in);
                char userAnswer;
    
                System.out.println("Would you like to play again? ");
                userAnswer = sc.next().charAt(0);
    
                if (userAnswer == 'y') { checker3 = true; checker2 = true; game = new TicTacToeGame(lines, columns, win); startingTurn = rand.nextInt(2); }
    
                else if (userAnswer == 'n') { checker2 = false; checker3 = true; }
    
                else { System.out.println("Please enter a y or n"); }
            }
        }
    }
}