// Given two strings s1 and s2, return true if s2 contains a of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

// Constraints:

//     1 <= s1.length, s2.length <= 104
//     s1 and s2 consist of lowercase English letters.

public class PermutationInStr {
    // Implement this
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        int count = 0;
        int l = 0;
        int r = 0;

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }
        if (count == 26)
            return true;

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            r = s2.charAt(i + s1.length()) - 'a';
            l = s2.charAt(i) - 'a';
            if (count == 26)
                return true;

            s2map[r]++;
            if (s1map[r] == s2map[r]) {
                count++;
            } else if (s1map[r] + 1 == s2map[r]) {
                count--;
            }

            s2map[l]--;
            if (s1map[l] == s2map[l]) {
                count++;
            } else if (s1map[l] - 1 == s2map[l]) {
                count--;
            }
        }

        return count == 26;
    }

    public static void main(String[] args) {

        String[] s1Inputs = {
                "ab",
                "ab",
                "adc",
                "hello",
                "a",
                "abc"
        };

        String[] s2Inputs = {
                "eidbaooo",
                "eidboaoo",
                "dcda",
                "ooolleoooleh",
                "ab",
                "bbbca"
        };

        boolean[] expected = {
                true,
                false,
                true,
                false,
                true,
                true
        };

        for (int i = 0; i < s1Inputs.length; i++) {

            boolean actual = checkInclusion(s1Inputs[i], s2Inputs[i]);

            System.out.println("s1       : " + s1Inputs[i]);
            System.out.println("s2       : " + s2Inputs[i]);
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