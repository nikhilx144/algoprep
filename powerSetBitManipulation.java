import java.util.*;

public class powerSetBitManipulation {
  static ArrayList<String> getPowerSet(String str) {
    int n = str.length();
    ArrayList<String> res = new ArrayList<>();
    for (int i = 0; i < (1 << n); i++) {
      String subString = "";
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0)
          subString += str.charAt(j);
      }
      res.add(subString);
    }
    return res;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(getPowerSet(str));
  }
}
