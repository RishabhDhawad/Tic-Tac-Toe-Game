import java.util.Scanner;
// Creating a simple Tic Tac Toe game
class Main{
    public static void main(String args[]) {
        // creating a 3 x 3 board
        char[][] board = new char[3][3];
        for (int row = 0 ; row < board.length;  row++) {
            for (int col = 0 ; col < board[row].length;  col++ ) {
                board[row][col] = ' ' ;
            }
        }

        // Initially player starting with X
        char player = 'X';
        // At starting the game is not over
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver) {
            printBoard(board);
            System.out.println("Player " + player + " enter: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver) {
                    System.out.println("Player " + player + " has won: ");
                } else {
                    if (player == 'X') {
                        player = '0';
                    } else {
                        player = 'X';
                    }
                }
            } else {
                System.out.println("Invalid move... Try Again!");
            }
            // Checking the Draw condition
            if (!haveWon(board, player) && isBoardFull(board)) {
                System.out.println("Game Draw!!!");
                break;
            }
        }
        printBoard(board);
    }

    // Checking if a player has won or not
    public static boolean haveWon(char[][] board, char player) {
        // Checking the rows
        for (int row = 0; row < board.length; row++) {
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // Checking fot the Columns
        for (int col = 0 ; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // Checking for the Diagnals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    // Print the current state of the board
    public static void printBoard(char[][] board) {
        for (int row = 0 ; row < board.length; row++) {
            for ( int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    // Check if the board is full (no more possible moves can be made)
    public static boolean isBoardFull(char board[][]) {
        for (int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}