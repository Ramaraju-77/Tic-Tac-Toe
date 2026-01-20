import java.util.*;

public class TicTacToeConsole {
    static char[] board = {'1','2','3','4','5','6','7','8','9'};
    static char turn = 'X';

    static boolean checkWin(char p) {
        return (board[0]==p && board[1]==p && board[2]==p) ||
               (board[3]==p && board[4]==p && board[5]==p) ||
               (board[6]==p && board[7]==p && board[8]==p) ||
               (board[0]==p && board[3]==p && board[6]==p) ||
               (board[1]==p && board[4]==p && board[7]==p) ||
               (board[2]==p && board[5]==p && board[8]==p) ||
               (board[0]==p && board[4]==p && board[8]==p) ||
               (board[2]==p && board[4]==p && board[6]==p);
    }

    static boolean isFull() {
        for (int i=0; i<9; i++) if (board[i]!='X' && board[i]!='O') return false;
        return true;
    }

    static void printBoard() {
        System.out.println("\n  |---|---|---|");
        System.out.println("  | " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("  |---|---|---|");
        System.out.println("  | " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("  |---|---|---|");
        System.out.println("  | " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("  |---|---|---|\n");
    }

    static void play() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printBoard();
            System.out.print(turn + "'s turn! Enter position (1-9): ");
            int pos;
            try {
                pos = sc.nextInt() - 1;
                if (pos < 0 || pos > 8 || board[pos] != (char)('1' + pos)) {
                    System.out.println("❌ Invalid move! Try again.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("❌ Enter number 1-9!");
                sc.next();
                continue;
            }
            board[pos] = turn;
            if (checkWin(turn)) {
                printBoard();
                System.out.println("🎉 " + turn + " WINS!");
                break;
            }
            if (isFull()) {
                printBoard();
                System.out.println("🤝 DRAW!");
                break;
            }
            turn = (turn == 'X') ? 'O' : 'X';
        }
        System.out.print("New game? (y/n): ");
        if (sc.next().toLowerCase().startsWith("y")) {
            for (int i=0; i<9; i++) board[i] = (char)('1' + i);
            turn = 'X';
            play();
        }
    }

    public static void main(String[] args) {
        System.out.println("🕹️ Tic Tac Toe Console Edition");
        play();
    }
}
