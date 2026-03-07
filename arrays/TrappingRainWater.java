// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Example 1:

// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9

// Constraints:

//     n == height.length
//     1 <= n <= 2 * 104
//     0 <= height[i] <= 105

package arrays;

import java.util.Arrays;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int n = height.length;
        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = height[0];
        R[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            L[i] = Math.max(height[i], L[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            R[i] = Math.max(height[i], R[i + 1]);
        }
        int w = 0;
        for (int i = 0; i < n; i++) {
            w += Math.min(L[i], R[i]) - height[i];
        }

        return w;
    }

    public static void main(String[] args) {

        int[][] inputs = {
            {0,1,0,2,1,0,1,3,2,1,2,1},
            {4,2,0,3,2,5},
            {1,0,1},
            {3,0,2,0,4},
            {0,0,0,0}
        };

        int[] expected = {
            6,
            9,
            1,
            7,
            0
        };

        for (int i = 0; i < inputs.length; i++) {

            int actual = trap(inputs[i]);

            System.out.println("Input    : " + Arrays.toString(inputs[i]));
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
