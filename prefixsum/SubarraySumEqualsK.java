// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2

// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2

 

// Constraints:

//     1 <= nums.length <= 2 * 104
//     -1000 <= nums[i] <= 1000
//     -107 <= k <= 107


package prefixsum;

import java.util.*;

public class SubarraySumEqualsK {

    // Implement this
    public static int subarraySum(int[] nums, int k) {

        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixsum = 0;
        map.put(0, 1);
        for(int i=0; i<nums.length; i++){
            prefixsum += nums[i];
            if(map.containsKey(prefixsum - k)){
                ans += map.get(prefixsum - k);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum, 0) + 1);
        }
        
        return ans;
    }

    public static void main(String[] args) {

        int[][] inputs = {
                { 1, 1, 1 },
                { 1, 2, 3 },
                { 1, -1, 0 },
                { 3, 4, 7, 2, -3, 1, 4, 2 },
                { 1, 2, 1, 2, 1 }
        };

        int[] kValues = {
                2,
                3,
                0,
                7,
                3
        };

        int[] expected = {
                2,
                2,
                3,
                4,
                4
        };

        for (int i = 0; i < inputs.length; i++) {

            int actual = subarraySum(inputs[i], kValues[i]);

            System.out.println("nums     : " + Arrays.toString(inputs[i]));
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
