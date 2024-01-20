import java.util.Scanner;

public class toBinaryRecursion {
  public static String toBinary(int decimal, String res) {
    if (decimal == 0)
      return res;
    res = decimal % 2 + res;
    return toBinary(decimal / 2, res);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String binary = toBinary(233, "");
  }
}
