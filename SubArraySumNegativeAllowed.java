import java.util.*;

public class SubArraySumNegativeAllowed {
  static int subArraySumNegativeAllowed(int arr[], int k) {
    int i = 0, count = 0, currentSum = 0, n = arr.length;
    HashMap<Integer, Integer> hm = new HashMap<>();
    while (i < n) {
      currentSum += arr[i];
      i++;
      if (currentSum == k || hm.containsKey(currentSum - k))
        count ++;
      hm.put(currentSum, hm.getOrDefault(currentSum, 0) + 1);
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    int k = sc.nextInt();
    System.out.println(subArraySumNegativeAllowed(arr, k));
  }
}
