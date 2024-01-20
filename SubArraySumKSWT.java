import java.util.*;

public class SubArraySumKSWT{
  static void subArraySum(int arr[], int k) {
    int i = 0, j = 0, sum = 0;
    while (i <= j && j < arr.length) {
      // Expansion
      sum += arr[j];
      j++;
      // Contraction
      while (sum > k && i < j) {
        sum -= arr[i];
        i++;
      }
      // sum = k
      if (sum == k) {
        System.err.println(i + ", " + (j - 1));
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    int k = sc.nextInt();
    subArraySum(arr, k);
  }
}
