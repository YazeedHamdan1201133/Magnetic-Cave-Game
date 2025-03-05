import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class MagneticCave {
	
    private static char[][] board; // a 2D array representing the game board. 
    private int currentPlayer; //  to store the current player's turn.
    private static boolean gameEnded; // to indicate whether the game has ended.

    public static void main(String[] args) {
    	MagneticCave game = new MagneticCave();
        game.playGame();
    }

    public MagneticCave() {
        board = new char[9][9];  
        currentPlayer = 1;
        gameEnded = false;
        initializeBoard();
    }

    private void initializeBoard() { // This method to create the initial state ( empty board ) 
    	//and placing the starting pieces for each player.
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                board[i][j] = '_';
            }
        }
      
        for (int i = 1; i < 9; i++) { // the first and the last columns only are able to start play in
            board[i][1] = 'P';
            board[i][8] = 'P';
        }
    }

    private void printBoard() { // this method to print the board at the console 
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (board[i][j] == 'P') {
                    System.out.print("_ ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean makeMove(int row, int col) { //method is used to make a move by a player, placing their piece on the board.
    	if (row < 1 || row >= 9 || col < 1 || col >= 9 || board[row][col] != 'P') {
            return false;
        }

        char symbol = currentPlayer == 2 ? 'W' : 'B';
        board[row][col] = symbol;

        // Update the cells next to the stone in the same row to be playable
        if (col - 1 >= 0 && board[row][col - 1] == '_') {
            board[row][col - 1] = 'P';
        }
        if (col + 1 < 8 && board[row][col + 1] == '_') {
            board[row][col + 1] = 'P';
        }

        return true;
    }
    private boolean makeMove2(int row, int col) { 
       	if (row < 1 || row >= 9 || col < 1 || col >= 9 || board[row][col] != 'P') {
            return false;
        }

        char symbol = currentPlayer == 2 ? 'B' : 'W';
        board[row][col] = symbol;

        // Update the cells next to the stone in the same row to be playable
        if (col - 1 >= 0 && board[row][col - 1] == '_') {
            board[row][col - 1] = 'P';
        }
        if (col + 1 < 8 && board[row][col + 1] == '_') {
            board[row][col + 1] = 'P';
        }

        return true;
    }

    private boolean checkWin(int row, int col) {
    	//method checks if a player has won the game 
        char symbol = board[row][col];

        // Check horizontal 
        int count = 1;
        int j = col - 1;
        while (j >= 0 && board[row][j] == symbol) {
            count++;
            j--;
        }
        j = col + 1;
        while (j <= 8 && board[row][j] == symbol) {
            count++;
            j++;
        } // if the player get 5 bricks horizontally will win
        if (count >= 5) {
            return true;  
        }

        // Check vertical
        count = 1;
        int i = row - 1;
        while (i >= 0 && board[i][col] == symbol) {
            count++;
            i--;
        }
        i = row + 1;
        while (i <= 8 && board[i][col] == symbol) {
            count++;
            i++;
        } // if the player get 5 bricks vertically will win
        if (count >= 5) {
            return true;
        }

        // Check diagonal 
        count = 1;
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0 && board[i][j] == symbol) {
            count++;
            i--;
            j--;
        }
        i = row + 1;
        j = col + 1;
        while (i <= 8 && j < 8 && board[i][j] == symbol) {
            count++;
            i++;
            j++;
        } 
        if (count >= 5) {
            return true;
        }

        // Check diagonal 
        count = 1;
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < 8 && board[i][j] == symbol) {
            count++;
            i--;
            j++;
        }
        i = row + 1;
        j = col - 1;
        while (i <= 8 && j >= 0 && board[i][j] == symbol) {
            count++;
            i++;
            j--;
        }
        return count >= 5;
    }
    
    public void playGame() { 
  // method starts the game and allows the user to choose the game mode (Player vs. Player or Player vs. AI).
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t-------------------------");
        System.out.println("\t\t    Magnetic Cave Game");
        System.out.println("\t\t-------------------------");
     
        System.out.println("1. Player vs. Player");
        System.out.println("\tIn this mode first player will play with Black, Player 2 with White");
        System.out.println("\t--------------------------------------------------------------------");
        System.out.println("2. Player vs. AI (MiniMax)");
        System.out.println("\t--------------------------------------------------------------------");
        System.out.println("3. Exit Game"); 
        System.out.println("\t--------------------------------------------------------------------");
        System.out.println("Please Select the mode:");
       
        
       // scanner.nextLine(); 
        int mode = 0;
       
        try {
        	mode = scanner.nextInt();
          
            scanner.nextLine(); 
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid number.");
            scanner.nextLine(); 
            
        }

        switch(mode) {
            case 1:  
                playPlayerVsPlayer(scanner);
                break;
            case 2:
                System.out.println("Please choose your position:");
                System.out.println("1. First Player (Black)");
                System.out.println("2. Second Player (White)");
                int playerPosition = scanner.nextInt();
                scanner.nextLine(); 
      

                if (playerPosition == 1) {
                    currentPlayer = 1;
                    playPlayerVsAI(scanner);
                } else {
                    currentPlayer = 2;
                    playAIVsPlayer(scanner);
                }
                break;
            case 3:
                System.out.println("Exiting the game.");
                break;
            default:
            	System.out.println("\tPlease choose one mode to start the game or 3 to Exit !!");
            	System.out.println();
            	System.out.println();
            	playGame();
            	break;
        }

        scanner.close();
    }

    private void playPlayerVsPlayer(Scanner scanner) {
        //printBoard();
        while (!gameEnded) {
            System.out.println("Current board:");           
            printBoard();
        	System.out.println("Player " + currentPlayer + ", enter your move (row and column):");

            int row = 0;
            int col = 0;
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid row and column numbers.");
                scanner.nextLine(); 
                continue;
            }

            if (makeMove(row, col)) {
                if (checkWin(row, col)) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                        System.out.println("The game is a draw!");
                        gameEnded = true;
                } else {
                    currentPlayer = currentPlayer == 1 ? 2 : 1; // Switch to the other player
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }

            printBoard();
        }
    }
    private boolean isBoardFull() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (board[i][j] == 'P') {
                    return false; // If any empty cell is found, the board is not full
                }
            }
        }
        return true; // All cells are occupied, the board is full
    }
    private void playPlayerVsAI(Scanner scanner) {  
    	// This method implemented when the user choose to start playing with (Black)
        printBoard();

        while (!gameEnded) {
            if (currentPlayer == 1) {
                System.out.println("Player 1, enter your move (row and column):");
               
                int row = 0;
                int col = 0;
                try {
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    scanner.nextLine(); 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter valid row and column numbers.");
                    scanner.nextLine(); 
                    continue;
                }
                if (makeMove(row, col)) {
                    if (checkWin(row, col)) {
                        System.out.println("Player 1 wins!");
                        gameEnded = true;
                    
                    }
                else if (isBoardFull()) {
                    System.out.println("The game is a draw!");
                    gameEnded = true;
                    }
                    else {
                        currentPlayer = 2; // Switch to AI player
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
                printBoard();
            } else {
                System.out.println("AI's turn:");
                int[] aiMove = getAIMove(6);                                              // Depth = 5
                if (aiMove != null) {
                    makeMove(aiMove[0], aiMove[1]);
                    if (checkWin(aiMove[0], aiMove[1])) {
                        System.out.println("AI wins!");
                        gameEnded = true;
                    } else {
                        currentPlayer = 1; // Switch to player 1
                    }
                }
                printBoard();
            }
        }
    }

    private void playAIVsPlayer(Scanner scanner) {
    	// This method implemented when the user choose to  play with (white)
        printBoard();

        while (!gameEnded) {                   
            if (currentPlayer == 1) {
                System.out.println("Player 2 enter your move (row and column):");
                int row = 0;
                int col = 0;
                try {
                    row = scanner.nextInt();
                    col = scanner.nextInt();
                    scanner.nextLine(); 
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter valid row and column numbers.");
                    scanner.nextLine(); 
                    continue;
                }
                if (makeMove2(row, col)) {
                    if (checkWin(row, col)) {
                        System.out.println("Player 2  wins!");
                        gameEnded = true;
                    
                } else if (isBoardFull()) {
                    System.out.println("The game is a draw!");
                    gameEnded = true;
                    }
                    else {
                        currentPlayer = 2;
                        
                        // (Represent the Ai player )Switch to AI player
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
                printBoard();
            } else {
                System.out.println("AI's turn:");
                int[] aiMove = getAIMove(5);                                                 // Depth 5
                if (aiMove != null) {
                    makeMove2(aiMove[0], aiMove[1]);
                    if (checkWin(aiMove[0], aiMove[1])) {
                        System.out.println("AI wins!");
                        gameEnded = true;
                    } else {
                        currentPlayer = 1; // Switch to player 1
                    }
                }
                printBoard();
            }
        }
    }

    public int[] getAIMove(int depth) { // This method is responsible for determining the best move for the AI player using the Minimax algorithm
        List<int[]> possibleMoves = generateMoves();
        if (possibleMoves.isEmpty()) {
            gameEnded = true;
            return null;
        }

        int[] bestMove = possibleMoves.get(0);
        int bestScore = Integer.MIN_VALUE;
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;

        for (int[] move : possibleMoves) {
            int row = move[0];
            int col = move[1];
            board[row][col] = 'W';
            int score = minimax(depth - 1, alpha, beta, false);
            board[row][col] = 'P';

            if (score > bestScore) {
                bestScore = score;
                bestMove = move;
            }

            alpha = Math.max(alpha, bestScore);
            if (beta <= alpha) {
                break; // beta cut-off
            }
        }
        return bestMove;
    }

    private List<int[]> generateMoves() { // This method is responsible for generating a list of possible moves for the current state of the game
        List<int[]> moves = new ArrayList<>();

        for (int row = 1; row < 9; row++) {
            for (int col = 1; col < 9; col++) {
                if (board[row][col] == 'P') {
                    moves.add(new int[]{row, col});
                }
            }
        }

        return moves;
    }

    
    private int Evaluation() {
        int score = 0;
        int weights[] = {1, 10, 50, 1000, 10000}; 
        
        int dr[] = {-1, 0, 1, 1}; // directions to look for (up, right, down, diagonal right)
        int dc[] = {1, 1, 1, 0}; // directions to look for (up, right, down, diagonal right)

        for (int row = 1; row < 9; row++) {
            for (int col = 1; col < 9; col++) {
                if (board[row][col] == 'W' || board[row][col] == 'B') {
                    for (int dir = 0; dir < 4; dir++) {
                        int whitePieces = 0;
                        int blackPieces = 0;

                        for (int dist = 0; dist < 4; dist++) {
                            int r = row + dr[dir] * dist;
                            int c = col + dc[dir] * dist;

                            if (r >= 1 && r < 9 && c >= 1 && c < 9) {
                                if (board[r][c] == 'W') whitePieces++;
                                else if (board[r][c] == 'B') blackPieces++;
                            }
                        }

                        if (whitePieces > 0 && blackPieces > 0) continue; // Ignore mixed sequences
                        if (whitePieces > 0) score += weights[whitePieces];
                        else if (blackPieces > 0) score -= weights[blackPieces];
                    }
                }
            }
        }

        return score;
    }
    
    private int minimax(int depth, int alpha, int beta, boolean isMaximizingPlayer) { // MiniMax algorithm 
        if (depth == 0 || gameEnded) {
            return Evaluation();
        }

        List<int[]> possibleMoves = generateMoves();
        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int[] move : possibleMoves) {
                int row = move[0];
                int col = move[1];
                board[row][col] = 'W';
                int score = minimax(depth - 1, alpha, beta, false);
                board[row][col] = 'P';
                bestScore = Math.max(bestScore, score);
                alpha = Math.max(alpha, bestScore);
                if (beta <= alpha) {
                    break; // Beta cutoff
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int[] move : possibleMoves) {
                int row = move[0];
                int col = move[1];
                board[row][col] = 'B';
                int score = minimax(depth - 1, alpha, beta, true);
                board[row][col] = 'P';
                bestScore = Math.min(bestScore, score);
                beta = Math.min(beta, bestScore);
                if (beta <= alpha) {
                    break; 
                }
            }
            return bestScore;
        }
    }
}