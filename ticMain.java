import java.util.Scanner;
public class ticMain {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (!game.checkWin() && !game.isBoardFull()) {
            System.out.println("Current Board:");
            game.displayBoard();
            System.out.println("Current Player: " + game.getCurrentPlayer());
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                game.changePlayer();
            }
        }

        System.out.println("Game Over!");
        game.displayBoard();

        if (game.checkWin()) {
            System.out.println("\nPlayer " + game.changePlayer() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}