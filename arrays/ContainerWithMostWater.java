package arrays;

import java.util.*;

public class ContainerWithMostWater {

    // Implement this
    public static int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int currArea = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, currArea);

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        int[][] inputs = {
                { 1, 8, 6, 2, 5, 4, 8, 3, 7 },
                { 1, 1 },
                { 4, 3, 2, 1, 4 },
                { 1, 2, 1 },
                { 2, 3, 10, 5, 7, 8, 9 }
        };

        int[] expected = {
                49,
                1,
                16,
                2,
                36
        };

        for (int i = 0; i < inputs.length; i++) {

            int actual = maxArea(inputs[i]);

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