import java.util.*;
public class recursivePalindrome {
  static boolean recursiveIsPalindrome(String str, int index) {
    int n = str.length();
    if (index >= n / 2)
      return true;
    if (str.charAt(index) != str.charAt(n - index - 1)) 
      return false;
    return recursiveIsPalindrome(str, index + 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(recursiveIsPalindrome(str, 0));
  }
}
