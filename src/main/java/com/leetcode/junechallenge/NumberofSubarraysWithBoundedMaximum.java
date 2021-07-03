package com.leetcode.junechallenge;


import javax.swing.plaf.basic.BasicIconFactory;
import java.io.*;

/*
Given an integer array nums and two integers left and right, return the number of contiguous non-empty subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,1,4,3], left = 2, right = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
Example 2:

Input: nums = [2,9,2,5,6], left = 2, right = 8
Output: 7


Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= left <= right <= 109
 */
public class NumberofSubarraysWithBoundedMaximum {

    public static void main(String[] args) throws IOException {
        NumberofSubarraysWithBoundedMaximum obj = new NumberofSubarraysWithBoundedMaximum();
        File file = new File("C:\\Users\\tjajodia\\Desktop\\Self\\Project\\Competitive Programming\\src\\main\\java\\com\\leetcode\\junechallenge\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        String[] result = line.split("\\s+");
        int n = result.length;
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(result[i]);
        }
        int ans = obj.numSubarrayBoundedMaxX(ints, 1, 50000);
        System.out.println(ans);
    }

    public int numSubarrayBoundedMaxX(int[] nums, int left, int right) {

        int n = nums.length;
        long consecutiveInRange = 0;
        long consecutiveOutOfRange = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {

            if (nums[i] <= right) {
                consecutiveInRange++;
            } else {
                count += (consecutiveInRange * (consecutiveInRange + 1)) / 2;
                consecutiveInRange = 0;
            }

            if (nums[i] < left) {
                consecutiveOutOfRange++;
            } else {
                count -= (consecutiveOutOfRange * (consecutiveOutOfRange + 1)) / 2;
                consecutiveOutOfRange = 0;
            }
        }

        count += (consecutiveInRange * (consecutiveInRange + 1)) / 2;
        count -= (consecutiveOutOfRange * (consecutiveOutOfRange + 1)) / 2;
        return (int) count;
    }
}
