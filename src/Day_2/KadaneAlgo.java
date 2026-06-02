package Day_2;

/**
 * Question link -: <a href="https://leetcode.com/problems/maximum-subarray/description/">...</a>
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Example 1:
 *
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */

/*
Intuition-:
At any index, we have two choices:

Extend the current subarray by including the current element.
Start a new subarray from the current element.

The crucial observation is:

A negative running sum can never contribute to a maximum subarray in the future.

If the current sum becomes negative, carrying it forward will only decrease the sum of any upcoming subarray. Therefore, we discard it and start fresh from the next element.

Kadane's Algorithm maintains a running sum of the current subarray and continuously tracks the maximum sum seen so far. Whenever the running sum becomes negative, it is reset to 0, effectively starting a new subarray.

Example
Current Sum = -5
Next Element = 10

Extend Current Subarray: -5 + 10 = 5
Start New Subarray: 10

Starting a new subarray gives a better result, so the negative prefix -5 is discarded.

By applying this idea to every element, we can find the maximum subarray sum in a single traversal of the array.
 */
public class KadaneAlgo {

    static int maxSubArray(int[] nums) {
        int sum = 0,
            maxSum = Integer.MIN_VALUE;

        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) sum = 0;
        }
        return maxSum ;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
