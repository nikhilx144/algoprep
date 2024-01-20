import java.util.*;

class LongestSubstringWithDistinctChars {
    static String longestSubstringWithDistinctChars(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, maxLen = 0, maxStart = 0;
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);   
            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }
        return str.substring(maxStart, maxStart + maxLen);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(longestSubstringWithDistinctChars(s));
    }
}
