import java.util.*;

class stringPermMatch {
    static boolean hasPerm(String str1, String str2) {
        if (str2.length() < str1.length())
            return false;
        int i = 0, j = str1.length() - 1;
        HashMap<Character, Integer> hm1 = new HashMap<>();
        for (char c : str1.toCharArray())
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        while (j < str2.length()) {
            HashMap<Character, Integer> hm2 = new HashMap<>();
            String substr2 = str2.substring(i, j + 1);
            for (char c : substr2.toCharArray())
                hm2.put(c, hm2.getOrDefault(c, 0) + 1);
            if (hm2.equals(hm1))
                return true;
            else {
                i++;
                j++;
            }
        }
        return false;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(hasPerm(s1, s2));
    }
}