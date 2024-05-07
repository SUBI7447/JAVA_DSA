import java.util.Scanner;

import javax.swing.plaf.synth.SynthStyle;

public class backtracking {

    static int count = 0;

    static int len = 5;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // int nums[] = new int[10];

        // back(nums, 0);

        // for (int i = 0; i < nums.length; i++) {

        // System.out.println(nums[i]);

        // }

        // ---------------------------

        // String str = "abc";

        // subset(str, new StringBuilder(""), 0);

        // ---------------------------

        // String str = "abc";

        // permutation(str, "");

        // ---------------------------

        // char board[][] = new char[4][4];

        // for (int i = 0; i < board.length; i++) {

        // for (int j = 0; j < board.length; j++) {

        // board[i][j] = '.';

        // }

        // }

        // n_queens(board, 0);

        // ---------------------------

        // int grid[][] = new int[3][3];

        // System.out.println(moves(grid, 0, 0));

        // ---------------------------

        // int sudoku[][] = {
        // { 0, 0, 8, 0, 0, 0, 0, 0, 0 },
        // { 4, 9, 0, 1, 5, 7, 0, 0, 2 },
        // { 0, 0, 3, 0, 0, 4, 1, 9, 0 },
        // { 1, 8, 5, 0, 6, 0, 0, 2, 0 },
        // { 0, 0, 0, 0, 2, 0, 0, 6, 0 },
        // { 9, 6, 0, 4, 0, 5, 3, 0, 0 },
        // { 0, 3, 0, 0, 7, 2, 0, 0, 4 },
        // { 0, 4, 9, 0, 3, 0, 0, 5, 7 },
        // { 8, 2, 7, 0, 0, 9, 0, 1, 3 }
        // };
        // if (is_sudoku(sudoku, 0, 0)) {

        // print_sudoku(sudoku);

        // } else {
        // System.out.println("SUDOKU NOT POSSIBLE");
        // }

        // ---------------------------

        // int maze[][] = {
        // { 1, 1, 1, 1 },
        // { 0, 1, 0, 1 },
        // { 1, 1, 1, 1 },
        // { 1, 0, 1, 1 }
        // };

        // int maze2[][] = {
        // { 1, 0, 0, 0 },
        // { 0, 0, 0, 0 },
        // { 0, 0, 0, 0 },
        // { 0, 0, 0, 0 }
        // };
        // t_maze(maze, maze2, 0, 0);

        // char num[][] = { {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
        // { 'j', 'k', 'l' },
        // { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x',
        // 'y', 'z' } };

        // String digits = "236";

        // t_num(num, digits, "", 0);
        // System.out.println(count);

        int n = 3;

        int chess[][] = new int[n][n];

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {

                chess[i][j] = 0;

            }
        }

        chess[0][0] = 1;

        if (knight(chess, 0, 0)) {

            System.out.println("POOSSIBLE------------------------------------------------");

            printchess(chess);

        } else {
            System.out.println("NOT POSSIBLE----------------------------------------------");
        }

    }

    public static boolean is_safe_to_place_left_down(int chess[][], int row, int col) {
        if (row == chess.length - 1 || col <= 1) {
            return false;
        }
        if (chess[row + 1][col - 2] != 0) {
            return false;
        }
        return true;
    }

    public static boolean is_safe_to_place_left_up(int chess[][], int row, int col) {
        if (row == 0 || col <= 1) {
            return false;
        }
        if (chess[row - 1][col - 2] != 0) {
            return false;
        }
        return true;
    }

    public static boolean is_safe_to_place_right_down(int chess[][], int row, int col) {
        if (row == chess.length - 1 || col >= chess.length - 2) {
            return false;
        }
        if (chess[row + 1][col + 2] != 0) {
            return false;
        }
        return true;
    }

    public static boolean is_safe_to_place_right_up(int chess[][], int row, int col) {
        if (row == 0 || col >= chess.length - 2) {
            return false;
        }
        if (chess[row - 1][col + 2] != 0) {
            return false;
        }
        return true;
    }

    public static boolean is_safe_to_place_upper_right(int chess[][], int row, int col) {
        if (row <= 1 || col == chess.length - 1) {
            return false;
        } else if (chess[row - 2][col + 1] != 0) {
            return false;
        }
        return true;
    }

    public static boolean is_safe_to_place_upper_left(int chess[][], int row, int col) {
        if (row <= 1 || col == 0) {
            return false;
        }
        if (chess[row - 2][col - 1] != 0) {
            return false;
        }
        return true;
    }

    public static boolean is_safe_to_place_lower_right(int chess[][], int row, int col) {
        if (row >= chess.length - 2 || col == chess.length - 1) {
            return false;
        }
        if (chess[row + 2][col + 1] != 0) {
            return false;
        }
        return true;
    }

    public static boolean is_safe_to_place_lower_left(int chess[][], int row, int col) {
        if (row >= chess.length - 2 || col == 0) {
            return false;
        }
        if (chess[row + 2][col - 1] != 0) {
            return false;
        }
        return true;
    }

    public static void printchess(int chess[][]) {

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {

                System.out.print(chess[i][j] + "   ");

            }
            System.out.println();
        }
    }

    public static boolean knight(int chess[][], int row, int col) {

        if (count == len) {

            return true;

        }

        if (is_safe_to_place_upper_right(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT UPPER RIGHT (" + row + ")(" + col + ")");

            chess[row][col] = ++count;

            printchess(chess);

            knight(chess, row - 2, col + 1);

        }
        if (is_safe_to_place_upper_left(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT UPPER LEFT (" + row + ")(" + col + ")");
            chess[row][col] = ++count;

            printchess(chess);

            knight(chess, row - 2, col - 1);

        }
        if (is_safe_to_place_lower_right(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT LOWER RIGHT (" + row + ")(" + col + ")");
            chess[row][col] = ++count;

            printchess(chess);

            knight(chess, row + 2, col + 1);

        }
        if (is_safe_to_place_lower_left(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT LOWER LEFT (" + row + ")(" + col + ")");
            chess[row][col] = ++count;

            printchess(chess);
            knight(chess, row + 2, col - 1);

        }
        if (is_safe_to_place_left_up(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT LEFT UP (" + row + ")(" + col + ")");
            chess[row][col] = ++count;
            printchess(chess);

            knight(chess, row - 1, col - 2);

        }
        if (is_safe_to_place_left_down(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT LEFT DOWN (" + row + ")(" + col + ")");

            chess[row][col] = ++count;
            printchess(chess);

            knight(chess, row + 1, col - 2);

        }
        if (is_safe_to_place_right_up(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT RIGHT UP (" + row + ")(" + col + ")");

            chess[row][col] = ++count;
            printchess(chess);

            knight(chess, row - 1, col + 2);

        }
        if (is_safe_to_place_right_down(chess, row, col) && count != len) {

            System.out.println("SUCCESS AT RIGHT DOWN (" + row + ")(" + col + ")");

            chess[row][col] = ++count;
            printchess(chess);

            knight(chess, row + 1, col + 2);

        }

        System.out.println("BACKING AT (" + row + ")(" + col + ")");

        chess[row][col] = 0;

        if (count != len) {

            count--;
        }

        System.out.println("COUNT : " + count);

        printchess(chess);

        return false;

    }

    public static void t_num(char num[][], String digits, String ans, int n) {

        if (n == digits.length()) {

            System.out.println(ans);
            count++;
            return;

        }

        for (int i = 0; i < num[Integer.parseInt(digits.substring(n, n + 1)) - 1].length; i++) {

            ans = ans + num[Integer.parseInt(digits.substring(n, n + 1)) - 1][i];

            t_num(num, digits, ans, n + 1);

            ans = ans.substring(0, ans.length() - 1);

        }

    }

    public static void t_maze(int maze[][], int ans[][], int row, int col) {

        System.out.println("ON " + "(" + row + ")(" + col + ")");

        if (row == maze.length - 1 && col == maze.length - 1) {

            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans.length; j++) {

                    System.out.print(ans[i][j] + " ");

                }
                System.out.println();

            }

            System.out.println();
            return;

        }

        if (row != 0 && maze[row - 1][col] != 0 && ans[row - 1][col] != 1) {

            System.out.println("GOING UP");
            ans[row][col] = 1;
            t_maze(maze, ans, row - 1, col);

        }
        System.out.println("UNABLE TO GO UP");
        if (row != maze.length - 1 && maze[row + 1][col] != 0 && ans[row + 1][col] != 1) {

            System.out.println("GOING DOWN");
            ans[row][col] = 1;
            t_maze(maze, ans, row + 1, col);

        }
        System.out.println("UNABLE TO GO DOWN");
        if (col != 0 && maze[row][col - 1] != 0 && ans[row][col - 1] != 1) {

            System.out.println("GOING LEFT");
            ans[row][col] = 1;
            t_maze(maze, ans, row, col - 1);

        }
        System.out.println("UNABLE TO GO LEFT");
        if (col != maze.length - 1 && maze[row][col + 1] != 0 && ans[row][col + 1] != 1) {

            System.out.println("GOING RIGHT");
            ans[row][col] = 1;
            t_maze(maze, ans, row, col + 1);

        }
        System.out.println("UNABLE TO  GO RIGHT");

        maze[row][col] = 0;
        System.out.println("SET " + "(" + row + ")(" + col + ") AS 0");
        System.out.println();

    }

    public static void print_sudoku(int su[][]) {

        for (int i = 0; i < su.length; i++) {

            for (int j = 0; j < su.length; j++) {

                System.out.print(su[i][j] + " ");

            }
            System.out.println(" ");

        }

    }

    public static boolean is_sudoku(int su[][], int row, int col) {

        if (row == 9) {
            return true;

        }

        int next_row = row;
        int next_col = col + 1;

        if (next_col == 9) {
            next_row = row + 1;
            next_col = 0;

        }

        if (su[row][col] != 0) {
            return is_sudoku(su, next_row, next_col);

        }

        for (int i = 1; i <= 9; i++) {

            if (is_allowed(su, row, col, i)) {

                su[row][col] = i;
                if (is_sudoku(su, next_row, next_col)) {
                    return true;

                }

                su[row][col] = 0;

            }

        }

        return false;

    }

    public static boolean is_allowed(int su[][], int row, int col, int num) {

        for (int i = 0; i < su.length; i++) {

            if (su[row][i] == num) {
                return false;

            }

        }
        for (int i = 0; i < su.length; i++) {

            if (su[i][col] == num) {
                return false;

            }

        }

        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {

            for (int j = sc; j < sc + 3; j++) {

                if (su[i][j] == num) {
                    return false;

                }

            }
        }
        return true;

    }

    public static int moves(int grid[][], int x, int y) {

        if (x == grid[1].length - 1 || y == grid.length - 1) {

            return 1;

        } else if (x == grid[1].length || y == grid.length) {
            return 0;

        }

        return moves(grid, x + 1, y) + moves(grid, x, y + 1);

    }

    public static void n_queens(char board[][], int row) {

        if (row == board.length) {

            print_board(board);
            return;

        }

        for (int i = 0; i < board.length; i++) {

            if (is_safe(board, i, row)) {

                board[row][i] = 'Q';
                n_queens(board, row + 1);
                board[row][i] = '.';

            }

        }

    }

    // ---------------------------------------------------------------- FOR ROOK

    // public static boolean upperleft(char board[][], int x, int y) {

    // return (board[y - 2][x - 1] == 'Q') ? false : true;

    // }

    // public static boolean upperright(char board[][], int x, int y) {

    // return (board[y - 2][x + 1] == 'Q') ? false : true;

    // }

    // public static boolean lowerleft(char board[][], int x, int y) {

    // return (board[y - 1][x - 2] == 'Q') ? false : true;

    // }

    // public static boolean lowerright(char board[][], int x, int y) {

    // return (board[y - 1][x + 2] == 'Q') ? false : true;

    // }

    // ---------------------------------------------------------------- FOR ROOK

    public static boolean is_safe(char board[][], int x, int y) {

        // ---------------------------------------------------------------- FOR ROOK

        // if (y == 0) {
        // return true;

        // } else if (y == 1) {

        // if (2 <= x && x <= board.length - 3) {
        // return (lowerright(board, x, y) && lowerleft(board, x, y));

        // } else {

        // if (x <= 1) {
        // return lowerright(board, x, y);

        // }
        // if (x >= board.length - 2) {
        // return lowerleft(board, x, y);

        // }
        // }
        // } else {
        // if (x == 0) {

        // return (upperright(board, x, y) && lowerright(board, x, y));

        // } else if (x == board.length - 1) {

        // return (upperleft(board, x, y) && lowerleft(board, x, y));

        // } else if (x == 1) {

        // return (upperleft(board, x, y) && upperright(board, x, y) &&
        // lowerright(board, x, y));

        // } else if (x == board.length - 2) {

        // return (upperleft(board, x, y) && upperright(board, x, y) && lowerleft(board,
        // x, y));

        // } else {

        // return (upperleft(board, x, y) && upperright(board, x, y) && lowerleft(board,
        // x, y)
        // && lowerright(board, x, y));

        // }

        // }
        // return true;

        // ---------------------------------------------------------------- FOR ROOK

        for (int i = y - 1; i >= 0; i--) {

            if (board[i][x] == 'Q') {

                return false;

            }

        }

        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {

                return false;

            }

        }
        for (int i = y - 1, j = x + 1; i >= 0 && j < board.length; i--, j++) {

            if (board[i][j] == 'Q') {

                return false;

            }

        }

        return true;
    }

    public static void print_board(char board[][]) {
        count++;
        System.out.println("CHESS BOARD NUM : " + count);

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {

                System.out.print(board[i][j] + " ");

            }
            System.out.println();

        }

    }

    public static void permutation(String str, String ans) {

        if (0 == str.length()) {

            System.out.println(ans);
            return;

        }
        for (int i = 0; i < str.length(); i++) {

            char choice = str.charAt(i);

            String str2 = str.substring(0, i) + str.substring(i + 1, str.length());

            permutation(str2, ans + choice);

        }

    }

    public static void subset(String str, StringBuilder ans, int n) {

        if (n == str.length()) {

            if (ans.length() == 0) {

                System.out.println("NULL");

            } else {

                System.out.println(ans);
                ans.deleteCharAt(ans.length() - 1);

            }
            return;
        }

        subset(str, ans.append(str.charAt(n)), n + 1);

        subset(str, ans, n + 1);

    }

    public static void back(int nums[], int n) {

        if (n == nums.length) {
            return;

        }

        nums[n] = n * 4;

        back(nums, n + 1);

        nums[n] = nums[n] + 4;
    }

}
