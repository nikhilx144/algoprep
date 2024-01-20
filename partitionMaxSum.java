public class partitionMaxSum {
  static int getPartitionMaxSum(int arr[], int index, int maxChunkSize) {
    if (index == arr.length)
      return 0;
    int maxSum = Integer.MIN_VALUE;
    int maxValInChunk = Integer.MIN_VALUE;
    int len = 0;
    for (int i = index; i < Math.min(maxChunkSize + index, arr.length); i++) {
      len++;
      maxValInChunk = Math.max(maxValInChunk, arr[i]);
      int sum = len * maxValInChunk + getPartitionMaxSum(arr, i + 1, maxChunkSize);
      maxSum = Math.max(sum, maxSum);
    }
    return maxSum;
  }

  public static void main(String args[]) {
    int arr[] = {1, 15, 7, 9, 2, 5, 10};
    int maxChunkSize = 3;
    System.out.println(getPartitionMaxSum(arr, 0, maxChunkSize));
  }
}