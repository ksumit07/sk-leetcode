// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

// Example 1:

// Input: s = "ABAB", k = 2
// Output: 4
// Explanation: Replace the two 'A's with two 'B's or vice versa.

// Example 2:

// Input: s = "AABABBA", k = 1
// Output: 4
// Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
// There may exists other ways to achieve this answer too.

 

// Constraints:

//     1 <= s.length <= 105
//     s consists of only uppercase English letters.
//     0 <= k <= s.length

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    // Implement this
    public static int characterReplacement(String s, int k) {

        int l = 0;
        int r = 0;
        int[] freq = new int[26];
        int ans = 0;
        int maxFreq = 0;

        while(r < s.length()){
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r)-'A']);
            while((r-l+1)-maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }

        return ans;
    }

    public static void main(String[] args) {

        String[] inputs = {
            "ABAB",
            "AABABBA",
            "AAAA",
            "ABCDE",
            "BAAAB",
            "ABBB"
        };

        int[] kValues = {
            2,
            1,
            2,
            1,
            2,
            2
        };

        int[] expected = {
            4,
            4,
            4,
            2,
            5,
            4
        };

        for (int i = 0; i < inputs.length; i++) {

            int actual = characterReplacement(inputs[i], kValues[i]);

            System.out.println("Input    : " + inputs[i]);
            System.out.println("k        : " + kValues[i]);
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