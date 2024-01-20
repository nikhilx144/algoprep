import java.util.*;

public class recursiveSubsets {
    public static List<List<Character>> subsets(char[] letters) {
        List<List<Character>> ans = new ArrayList<>();
        helper(letters , 0, new ArrayList<Character>() , ans);
        return ans;
    }
    static void helper(char letters[],int ci,List<Character> subset,List<List<Character>> ans) {
        if(ci == letters.length) {
            ans.add(new ArrayList<>(subset));
            return ;
        }
        
        // Include
        subset.add(letters[ci]);
        helper(letters, ci + 1, subset, ans);
        
        // Exclude
        subset.remove(subset.size() - 1);
        helper(letters, ci + 1, subset, ans);

        return ;
    }

    public static void main(String[] args) {
      char[] letters = {'a', 'b', 'c'};
      List<List<Character>> subsets = subsets(letters);
      System.out.println("Subsets:");
      for (List<Character> subset : subsets) {
          System.out.println(subset);
      }
    }
}
/* 
Time Complexity : O(2^N)
Space Complexity : O(N)
*/