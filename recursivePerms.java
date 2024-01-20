import java.util.*;

public class recursivePerms {

  static void swap(int arr[], int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  static void solve(int arr[], ArrayList<int[]> perms, int index) {
    // Base case
    if (index >= arr.length) {
      perms.add(Arrays.copyOf(arr, arr.length));
      return ;
    }

    for (int j = index; j < arr.length; j++) {
      swap(arr, index, j);
      solve(arr, perms, index + 1);
      // Backtrack i.e. neutralize the effect
      swap(arr, index, j);
    }
  }

  static ArrayList<int[]> permute(int arr[]) {
    ArrayList<int[]> perms = new ArrayList<>();
    int index = 0;
    
    solve(arr, perms, index);

    return perms;
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    ArrayList<int[]> perms = permute(arr);
    for (int perm[] : perms)
      System.out.println(Arrays.toString(perm));
  }
}
