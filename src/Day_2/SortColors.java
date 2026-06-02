package Day_2;

/**
 * Question link -: <a href="https://leetcode.com/problems/sort-colors/description/">...</a>
 *Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */

/*
Intuition:
Since the array contains only three distinct values (0, 1, and 2),
instead of comparing and swapping elements, we can simply count the
frequency of each color in one traversal.

After obtaining the counts of 0s, 1s, and 2s, we overwrite the array:
- Place all 0s first.
- Then place all 1s.
- Finally place all 2s.

This works because the final sorted order is completely determined by
the frequency of each color.

Example:
[2, 0, 2, 1, 1, 0]

Count:
0 -> 2 times
1 -> 2 times
2 -> 2 times

Rebuild array:
[0, 0, 1, 1, 2, 2]

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class SortColors {
    static void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0, index = 0;
        for (int num : nums) {
            if (num == 0) count0++;
            if (num == 1) count1++;
            if (num == 2) count2++;
        }

        for (int i = 0; i<count0; i++) nums[index++] = 0;
        for (int i = 0; i<count1; i++) nums[index++] = 1;
        for (int i = 0; i<count2; i++) nums[index++] = 2;

        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortColors(arr);
    }
}
