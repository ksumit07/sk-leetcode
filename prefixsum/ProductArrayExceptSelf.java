// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

// You must write an algorithm that runs in O(n) time and without using the division operation.

 

// Example 1:

// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]

// Example 2:

// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]

 

// Constraints:

//     2 <= nums.length <= 105
//     -30 <= nums[i] <= 30
//     The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

package prefixsum;

import java.util.Arrays;

public class ProductArrayExceptSelf {
    // Implement this
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        l[0] = 1;
        r[nums.length - 1] = 1;
        for(int i=1; i<nums.length; i++){
            l[i] = l[i-1] * nums[i-1];
        }
        for(int i=nums.length -2; i>=0; i--){
            r[i] = r[i+1] * nums[i+1];
        }
        for(int i=0; i<nums.length; i++){
            ans[i] = l[i] * r[i];
        }
        return ans;
    }

    public static void main(String[] args) {

        int[][] inputs = {
            {1,2,3,4},
            {-1,1,0,-3,3},
            {2,3,4,5},
            {0,0},
            {5,1,2}
        };

        int[][] expected = {
            {24,12,8,6},
            {0,0,9,0,0},
            {60,40,30,24},
            {0,0},
            {2,10,5}
        };

        for (int i = 0; i < inputs.length; i++) {

            int[] actual = productExceptSelf(inputs[i]);

            System.out.println("nums     : " + Arrays.toString(inputs[i]));
            System.out.println("Expected : " + Arrays.toString(expected[i]));
            System.out.println("Actual   : " + Arrays.toString(actual));

            if (Arrays.equals(actual, expected[i])) {
                System.out.println("Result   : PASS");
            } else {
                System.out.println("Result   : FAIL");
            }

            System.out.println("--------------------------------");
        }
    }
}
