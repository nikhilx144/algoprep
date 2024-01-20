import java.util.*;
public class recursiveArrayRev {
  static void getRev(int arr[], int left, int right) {
    if (left >= right)
      return ;
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    getRev(arr, left + 1, right - 1);
  }

  static void getRev(int arr[], int i) {
    int n = arr.length;
    if (i >= n / 2)
      return ;
    int temp = arr[i];
    arr[i] = arr[n - i - 1];
    arr[n - i - 1] = temp;
    getRev(arr, i + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
    arr[i] = sc.nextInt();
    getRev(arr, 0);
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }
}
