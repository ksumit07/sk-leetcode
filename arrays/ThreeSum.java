// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Example 1:

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]
// Explanation: 
// nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
// nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
// nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
// The distinct triplets are [-1,0,1] and [-1,-1,2].
// Notice that the order of the output and the order of the triplets does not matter.

// Example 2:

// Input: nums = [0,1,1]
// Output: []
// Explanation: The only possible triplet does not sum up to 0.

// Example 3:

// Input: nums = [0,0,0]
// Output: [[0,0,0]]
// Explanation: The only possible triplet sums up to 0.

// Constraints:

//     3 <= nums.length <= 3000
//     -105 <= nums[i] <= 105

package arrays;

import java.util.*;

public class ThreeSum {

    // Implement this
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                    j++;
                    k--;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {

        int[][] inputs = {
                { -1, 0, 1, 2, -1, -4 },
                { 0, 1, 1 },
                { 0, 0, 0 },
                { -2, 0, 1, 1, 2 },
                { -4, -2, -2, -2, 0, 1, 2, 2 }
        };

        List<List<List<Integer>>> expected = new ArrayList<>();

        expected.add(Arrays.asList(
                Arrays.asList(-1, -1, 2),
                Arrays.asList(-1, 0, 1)));

        expected.add(Arrays.asList());

        expected.add(Arrays.asList(
                Arrays.asList(0, 0, 0)));

        expected.add(Arrays.asList(
                Arrays.asList(-2, 0, 2),
                Arrays.asList(-2, 1, 1)));

        expected.add(Arrays.asList(
                Arrays.asList(-4, 2, 2),
                Arrays.asList(-2, 0, 2)));

        for (int i = 0; i < inputs.length; i++) {

            List<List<Integer>> actual = threeSum(inputs[i]);

            System.out.println("Input    : " + Arrays.toString(inputs[i]));
            System.out.println("Expected : " + expected.get(i));
            System.out.println("Actual   : " + actual);

            if (compareTriplets(actual, expected.get(i))) {
                System.out.println("Result   : PASS");
            } else {
                System.out.println("Result   : FAIL");
            }

            System.out.println("--------------------------------");
        }
    }

    private static boolean compareTriplets(List<List<Integer>> a, List<List<Integer>> b) {
        Set<Set<Integer>> setA = new HashSet<>();
        Set<Set<Integer>> setB = new HashSet<>();

        for (List<Integer> list : a) {
            setA.add(new HashSet<>(list));
        }

        for (List<Integer> list : b) {
            setB.add(new HashSet<>(list));
        }

        return setA.equals(setB);
    }

}
