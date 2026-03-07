import java.util.*;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;

        int ans = 0;
        
        while(r<s.length()){
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            ans = Math.max(ans, r-l+1);
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {

        String[] inputs = {
            "abcabcbb",
            "bbbbb",
            "pwwkew",
            "",
            "a",
            "dvdf",
            "abba"
        };

        int[] expected = {
            3,
            1,
            3,
            0,
            1,
            3,
            2
        };

        for (int i = 0; i < inputs.length; i++) {
            int actual = lengthOfLongestSubstring(inputs[i]);

            System.out.println("Input    : " + inputs[i]);
            System.out.println("Expected : " + expected[i]);
            System.out.println("Actual   : " + actual);

            if (actual == expected[i]) {
                System.out.println("Result   : PASS");
            } else {
                System.out.println("Result   : FAIL");
            }

            System.out.println("--------------------------------");
        }
    }
}