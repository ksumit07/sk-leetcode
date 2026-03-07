// Given two strings s and t of lengths m and n respectively, return the minimum window of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// Example 1:

// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:

// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:

// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.

// Constraints:

//     m == s.length
//     n == t.length
//     1 <= m, n <= 105
//     s and t consist of uppercase and lowercase English letters.

import java.util.*;

public class MinWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int l = 0;
        int r = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int counter = map.size();
        int begin = 0;
        int len = Integer.MAX_VALUE;

        while (r < s.length()) {
            Character charToAdd = s.charAt(r);
            if (map.containsKey(charToAdd)) {
                map.put(charToAdd, map.get(charToAdd) - 1);
                if (map.get(charToAdd) == 0) {
                    counter--;
                }
            }
            r++;
            while (counter == 0) {
                Character charToRemove = s.charAt(l);
                if (map.containsKey(charToRemove)) {
                    map.put(charToRemove, map.get(charToRemove) + 1);
                    if (map.get(charToRemove) > 0) {
                        counter++;
                    }
                }
                if (r - l < len) {
                    len = r - l;
                    begin = l;
                }
                l++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(begin, begin + len);
    }

    public static void main(String[] args) {

        String[] sInputs = {
                "ADOBECODEBANC",
                "a",
                "a",
                "aa",
                "aaflslflsldkalskaaa"
        };

        String[] tInputs = {
                "ABC",
                "a",
                "aa",
                "aa",
                "aaa"
        };

        String[] expected = {
                "BANC",
                "a",
                "",
                "aa",
                "aaa"
        };

        for (int i = 0; i < sInputs.length; i++) {

            String actual = minWindow(sInputs[i], tInputs[i]);

            System.out.println("s        : " + sInputs[i]);
            System.out.println("t        : " + tInputs[i]);
            System.out.println("Expected : " + expected[i]);
            System.out.println("Actual   : " + actual);

            if (Objects.equals(actual, expected[i])) {
                System.out.println("Result   : PASS");
            } else {
                System.out.println("Result   : FAIL");
            }

            System.out.println("--------------------------------");
        }
    }
}
