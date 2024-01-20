import java.util.*;
public class recursiveMergeSort {
  public static void recursiveMergeSortFunc(int arr[], int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      recursiveMergeSortFunc(arr, left, mid);
      recursiveMergeSortFunc(arr, mid + 1, right);
      merge(arr, left, mid, right);
    }
  }

  public static void merge(int arr[], int left, int mid, int right) {
    int i = left, j = mid + 1, k = 0;
    int temp[] = new int[right - left + 1];

    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j])
        temp[k++] = arr[i++];
      else
        temp[k++] = arr[j++];  
    }

    while (i <= mid) {
      temp[k++] = arr[i++];
    }
    
    while (j <= right) {
      temp[k++] = arr[j++];  
    }
    
    for (int pos = left; pos <= right; pos++) {
      arr[pos] = temp[pos - left];
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); 
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)
    arr[i] = sc.nextInt();
    recursiveMergeSortFunc(arr, 0, n - 1);
    for (int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");
  }
}
