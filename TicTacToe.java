public class TicTacToe {

    //Attributes
    private char[][] board;
    private char currentPlayer;
    private int boardSize = 3;
    private int xWins;
    private int oWins;

    // Constructors for the game
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        resetBoard();
        xWins = 0;
        oWins = 0;
    }
    // Method to reset the game board
    public void resetBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '-';
            }
        }
    }
    // Method to print the current state of the game board
    public void displayBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
     // Method to make a move at the picked row and column
    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            return true;
        } else {
            System.out.println("Invalid move. Please try again.");
            return false;
        }
    }
    // Method to check if the current player has won the game
    public boolean checkWin() {
        for (int i = 0; i < boardSize; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        for (int j = 0; j < boardSize; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }
    // Method to switch the current player after each move
    public char changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
        return currentPlayer;
    }
    // Method to check if the TicTacToe board is full (a tie)
    public boolean isBoardFull() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
    // Getter method to retrieve the symbol of the current player ('X' or 'O')
    public char getCurrentPlayer() {
        return currentPlayer;
    }
}