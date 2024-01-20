import java.util.*;

public class ratInAMazeBacktracking {

  static void solve(int x, int y, int maze[][], int n, int visited[][], ArrayList<String> paths, String path) {
    if (x == n - 1 && y == n - 1) {
      paths.add(path);
      return ;
    }

    visited[x][y] = 1;

    // Down
    if (isSafe(maze, x + 1, y, visited, n))
      solve(x + 1, y, maze, n, visited, paths, path + "D");
    // Left
    if (isSafe(maze, x, y - 1, visited, n))
      solve(x, y - 1, maze, n, visited, paths, path + "L");
    // Right
    if (isSafe(maze, x, y + 1, visited, n))
      solve(x, y + 1, maze, n, visited, paths, path + "R");
    // Up
    if (isSafe(maze, x - 1, y, visited, n))
      solve(x - 1, y, maze, n, visited, paths, path + "U");
    
      visited[x][y] = 0;
  }

  static boolean isSafe(int maze[][], int newx, int newy, int visited[][], int n) {
    if ((newx >= 0 && newx < n) && (newy >= 0 && newy < n) && (maze[newx][newy] == 1) && (visited[newx][newy] != 1))
      return true;
    return false;
  }

  static ArrayList<String> searchMaze(int maze[][], int n) {
    ArrayList<String> paths = new ArrayList<>();
    int visited[][] = new int[n][n];
    String path = "";

    if (maze[0][0] == 0)
      return paths;

    solve(0, 0, maze, n, visited, paths, path);
    return paths;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int maze[][] = new int[n][n];
    System.out.println("Enter 1 for safe cell and 0 for trap");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        maze[i][j] = sc.nextInt();
      }
    }
    System.out.println(searchMaze(maze, n));
  }
}
