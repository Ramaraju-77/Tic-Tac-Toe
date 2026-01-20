import java.util.*;

public class TicTacToeClean {
    static String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static String turn = "X";
    static String player1, player2;

    static boolean checkWin(String p) {
        int[][] wins = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for (int[] w : wins)
            if (board[w[0]].equals(p) && board[w[1]].equals(p) && board[w[2]].equals(p)) return true;
        return false;
    }

    static boolean isFull() {
        for (String cell : board) if (!cell.equals("X") && !cell.equals("O")) return false;
        return true;
    }

    static void printBoard() {
        System.out.println(" +---+---+---+");
        System.out.println(" | " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println(" +---+---+---+");
        System.out.println(" | " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println(" +---+---+---+");
        System.out.println(" | " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println(" +---+---+---+");
    }

    static void play() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Player 1 (X) name: ");
        player1 = sc.nextLine().trim();
        System.out.print("Player 2 (O) name: ");
        player2 = sc.nextLine().trim();
        if (player1.isEmpty()) player1 = "Player1";
        if (player2.isEmpty()) player2 = "Player2";

        while (true) {
            String currentPlayer = turn.equals("X") ? player1 : player2;
            printBoard();
            System.out.print(currentPlayer + " (" + turn + ") > Position (1-9): ");
            try {
                int pos = Integer.parseInt(sc.nextLine()) - 1;
                if (pos < 0 || pos > 8 || !board[pos].equals(String.valueOf(pos + 1))) {
                    System.out.println("❌ Invalid position!");
                    continue;
                }
                board[pos] = turn;
                if (checkWin(turn)) {
                    printBoard();
                    System.out.println("🏆 " + currentPlayer + " (" + turn + ") WINS!");
                    break;
                }
                if (isFull()) {
                    printBoard();
                    System.out.println("🤝 DRAW!");
                    break;
                }
                turn = turn.equals("X") ? "O" : "X";
            } catch (Exception e) {
                System.out.println("❌ Enter number 1-9!");
            }
        }
        System.out.print("Play again? (y/n): ");
        if (sc.nextLine().toLowerCase().startsWith("y")) {
            for (int i = 0; i < 9; i++) board[i] = String.valueOf(i + 1);
            turn = "X";
            play();
        }
    }

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe - Clean Board");
        play();
    }
}
