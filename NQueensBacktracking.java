import java.util.*;

public class NQueensBacktracking {

  static void addSolution(int board[][], List<int[][]> solutions, int n) {
    int ans[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++)
        ans[i][j] = board[i][j];
    }
    solutions.add(ans);
  }

  static void solve(int col, int board[][], List<int[][]> solutions, int n) {
    if (col == n) {
      addSolution(board, solutions, n);
      return ;
    }

    // solve 1 case and rest recursion will take care
    for (int row = 0; row < n; row++) {
      if (isSafe(board, n, row, col)) {
        board[row][col] = 1;
        solve(col + 1, board, solutions, n);
        board[row][col] = 0;
      }
    }

  }

  static List<int[][]> nQueens(int board[][], int n) {
    List<int[][]> solutions = new ArrayList<>();

    solve(0, board, solutions, n);
    return solutions;
  }

  static boolean isSafe(int board[][], int n, int row, int col) {
    // Check for same row
    for (int y = 0; y < n; y++)
      if (board[row][y] == 1) return false;

    // Check for same col
    for (int x = 0; x < n; x++)
      if (board[x][col] == 1) return false;

    // check for left diag
    int x = row, y = col;
    while (x >= 0 && y >= 0) {
      if (board[x][y] == 1) return false;
      x--; y--;
    }

    // check for right diag
    x = row; y = col;
    while (x < n && y >= 0) {
      if (board[x][y] == 1) return false;
      x++; y--;
    }
    return true;

  } 

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int board[][] = new int[n][n];
    List<int[][]> solutions = nQueens(board, n);
    for (int[][] solution : solutions) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
          if (solution[i][j] == 1) System.out.print("Q ");
          else System.out.print(solution[i][j] + " ");
        System.out.println();
      }
      System.out.println();
    }
    System.out.println("Number of solutions = " + solutions.size());
  }
}
